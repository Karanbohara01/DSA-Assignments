package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class AsynchronousDownloader extends JFrame {
    private JTextField urlField = new JTextField("https://images.unsplash.com/photo-1708068435015-b5afefddf7d1?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw4fHx8ZW58MHx8fHx8");
    private JButton addButton = new JButton(" Download");
    private JButton pauseButton = new JButton("Pause/Resume");
    private JButton cancelButton = new JButton("Cancel ");
    private JButton showButton = new JButton("View Downloads");
    private DefaultListModel<DownloadInfo> listModel = new DefaultListModel<>();
    private JList<DownloadInfo> downloadList = new JList<>(listModel);
    private ExecutorService downloadExecutor = Executors.newFixedThreadPool(10); // 10 concurrent downloads

    public AsynchronousDownloader() {
        super("Asynchronous Image Downloader");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        layoutComponents();
        setVisible(true);
        setLocationRelativeTo(null); // Center the JFrame on the screen
    }

    private void layoutComponents() {
        // Set dark theme
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set background color to black and font to Roboto 14 for all components
        Font roboto14 = new Font("poppins", Font.PLAIN, 20);
        Color whiteColor = Color.WHITE;
        Color blackColor = Color.BLACK;

        getContentPane().setBackground(blackColor);
        urlField.setFont(roboto14);
        urlField.setForeground(blackColor);
        addButton.setFont(roboto14);
        addButton.setBackground(Color.black);
        addButton.setForeground(Color.white);

        JPanel addPanel = new JPanel();
        addPanel.setBackground(Color.pink);
        addPanel.setLayout(new BorderLayout());
        addPanel.add(urlField, BorderLayout.CENTER);
        addPanel.add(addButton, BorderLayout.EAST);

        JScrollPane scrollPane = new JScrollPane(downloadList);
        downloadList.setCellRenderer(new DownloadListRenderer());
        scrollPane.setBackground(Color.black);
        scrollPane.setForeground(Color.black);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setAlignmentX(50);
        buttonPanel.setAlignmentY(50);
        buttonPanel.setBackground(Color.pink);

        pauseButton.setFont(roboto14);
        pauseButton.setBackground(Color.black);
        pauseButton.setForeground(Color.white);

        cancelButton.setFont(roboto14);
        cancelButton.setBackground(Color.black);
        cancelButton.setForeground(Color.white);

        showButton.setFont(roboto14);
        showButton.setBackground(Color.black);
        showButton.setForeground(Color.white);

        buttonPanel.add(pauseButton);
        buttonPanel.add(cancelButton);
        buttonPanel.add(showButton);

        addButton.addActionListener(e -> addDownload(urlField.getText().trim()));
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DownloadInfo selectedInfo = downloadList.getSelectedValue();
                if (selectedInfo != null) {
                    selectedInfo.togglePauseResume();
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DownloadInfo selectedInfo = downloadList.getSelectedValue();
                if (selectedInfo != null) {
                    selectedInfo.cancel();
                    listModel.removeElement(selectedInfo);
                }
            }
        });

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().open(new File("downloads"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        setLayout(new BorderLayout());

        add(addPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

    }

    private void addDownload(String url) {
        try {
            new URL(url);
            DownloadInfo info = new DownloadInfo(url);
            listModel.addElement(info);
            DownloadTask task = new DownloadTask(info, () -> SwingUtilities.invokeLater(this::repaint));
            info.setFuture(downloadExecutor.submit(task));
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(this, "Invalid URL: " + url, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AsynchronousDownloader::new);
    }
}

class DownloadInfo {
    private final String url;
    private volatile String status = "Waiting..."; // Corrected the typo here
    private volatile long totalBytes = 0L;
    private volatile long downloadedBytes = 0L;
    private Future<?> future;
    private final AtomicBoolean paused = new AtomicBoolean(false);

    public DownloadInfo(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public synchronized boolean isPaused() {
        return paused.get();
    }

    public synchronized void togglePauseResume() {
        paused.set(!paused.get());
        notifyAll();
    }
    public String getStatus() {
        return status;
    }
    public synchronized void setStatus(String status) {
        this.status = status;
    }

    public void setFuture(Future<?> future) {
        this.future = future;
    }

    public void cancel() {
        if (future != null)
            future.cancel(true);
    }

    public synchronized void setTotalBytes(long totalBytes) {
        this.totalBytes = totalBytes;
    }

    public synchronized void addDownloadedBytes(long bytes) {
        this.downloadedBytes += bytes;
    }

    public long getDownloadedBytes() {
        return downloadedBytes;
    }

    public long getTotalBytes() {
        return totalBytes;
    }
}

class DownloadTask implements Callable<Void> {
    private final DownloadInfo info;
    private final Runnable updateUI;

    public DownloadTask(DownloadInfo info, Runnable updateUI) {
        this.info = info;
        this.updateUI = updateUI;
    }

    @Override
    public Void call() throws Exception {
        info.setStatus("Downloading");
        @SuppressWarnings("deprecation")
        URL url = new URL(info.getUrl());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        long fileSize = connection.getContentLengthLong();
        info.setTotalBytes(fileSize);

        try (InputStream in = new BufferedInputStream(connection.getInputStream())) {
            Path targetPath = Paths.get("downloads", new File(url.getPath()).getName());
            Files.createDirectories(targetPath.getParent());
            try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(targetPath))) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    synchronized (info) {
                        while (info.isPaused())
                            info.wait();
                    }
                    out.write(buffer, 0, bytesRead);
                    info.addDownloadedBytes(bytesRead);
                    updateUI.run();
                    Thread.sleep(200);
                }
                info.setStatus("Completed");
            }
        } catch (IOException | InterruptedException e) {
            info.setStatus("Error: " + e.getMessage());
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
        } finally {
            updateUI.run();
        }
        return null;
    }
}

class DownloadListRenderer extends JPanel implements ListCellRenderer<DownloadInfo> {
    @Override
    public Component getListCellRendererComponent(JList<? extends DownloadInfo> list, DownloadInfo value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        this.removeAll();
        setLayout(new BorderLayout());
        JLabel urlLabel = new JLabel(value.getUrl());
        JProgressBar progressBar = new JProgressBar(0, 100);
        if (value.getTotalBytes() > 0) {
            int progress = (int) ((value.getDownloadedBytes() * 100) / value.getTotalBytes());
            progressBar.setValue(progress);
        }
        JLabel statusLabel = new JLabel(value.getStatus());
        add(urlLabel, BorderLayout.LINE_START);
        add(progressBar, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        return this;
    }
}
