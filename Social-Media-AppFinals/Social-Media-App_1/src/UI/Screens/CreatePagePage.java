package UI.Screens;

import java.awt.Image;

import javax.swing.ImageIcon;

import main.SocialMedia;

public class CreatePagePage extends BasePage {
    public CreatePagePage() {
        initComponents();
		errorLabel.setVisible(false);
    }

	private void initComponents() {
        pageHeading = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pageNameTextField = new javax.swing.JTextField();
        createButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pageHeading.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        pageHeading.setText("Create Page");

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setText("Page Name:");

        pageNameTextField.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        pageNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pageNameTextFieldActionPerformed(evt);
            }
        });

        createButton.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        createButton.setText("Create");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

//        ImageIcon backIcon = new ImageIcon(getClass().getResource("/images/back icon.png"));
//        backButton.setIcon(
//            new ImageIcon(backIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH))
//        );
backButton.setText("Back");

        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        errorLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(153, 0, 51));
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLabel.setText("Error");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(408, 408, 408)
                        .addComponent(pageHeading))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(499, 499, 499)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pageNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(590, 590, 590)
                        .addComponent(createButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(432, 432, 432)
                        .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(441, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pageHeading))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(backButton)))
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(pageNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86)
                .addComponent(createButton)
                .addGap(76, 76, 76)
                .addComponent(errorLabel)
                .addContainerGap(317, Short.MAX_VALUE))
        );

        pack();
    }

    private void pageNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {
		String name = pageNameTextField.getText();

		if (!name.isEmpty()) {
    	    SocialMedia.getCurrentUser().createPage(name);
			pageNameTextField.setText("");
			errorLabel.setText("Page Created");
			errorLabel.setVisible(true);
	    }
		else {
			errorLabel.setText("Page Name Cannot Be Empty");
			errorLabel.setVisible(true);
		}
	}

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        SocialMedia.states.changeState(new SettingsPage());
    }

    // Variables declaration - do not modify
    private javax.swing.JButton backButton;
    private javax.swing.JButton createButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel pageHeading;
    private javax.swing.JTextField pageNameTextField;
	private javax.swing.JLabel errorLabel;
    // End of variables declaration
}
