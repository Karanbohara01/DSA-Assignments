//package UI.Screens;
//
//import java.awt.Image;
//
//import javax.swing.ImageIcon;
//
//import main.SocialMedia;
//
//public class RegistrationPage extends BasePage {
//    public RegistrationPage() {
//        initComponents();
//        errorLabel.setVisible(false);
//    }
//
//    private void initComponents() {
//        pageHeading = new javax.swing.JLabel();
//        jLabel1 = new javax.swing.JLabel();
//        jLabel2 = new javax.swing.JLabel();
//        jLabel3 = new javax.swing.JLabel();
//        jLabel4 = new javax.swing.JLabel();
//        jLabel5 = new javax.swing.JLabel();
//        jLabel6 = new javax.swing.JLabel();
//        jLabel7 = new javax.swing.JLabel();
//        jLabel8 = new javax.swing.JLabel();
//        jLabel9 = new javax.swing.JLabel();
//        jLabel10 = new javax.swing.JLabel();
//        fNameTextField = new javax.swing.JTextField();
//        lNameTextField = new javax.swing.JTextField();
//        emailTextField = new javax.swing.JTextField();
//        passwordTextField = new javax.swing.JTextField();
//        cPassTextField = new javax.swing.JTextField();
//        phoneTextField = new javax.swing.JTextField();
//        dateTextField = new javax.swing.JTextField();
//        monthTextField = new javax.swing.JTextField();
//        yearTextField = new javax.swing.JTextField();
//        registerButton = new javax.swing.JButton();
//        errorLabel = new javax.swing.JLabel();
//        backButton = new javax.swing.JButton();
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//        setPreferredSize(new java.awt.Dimension(1280, 720));
//        setSize(new java.awt.Dimension(1280, 720));
//
//        pageHeading.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
//        pageHeading.setText("Register");
//
//        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
//        jLabel1.setText("First Name:");
//
//        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
//        jLabel2.setText("Last Name:");
//
//        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
//        jLabel3.setText("Email:");
//
//        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
//        jLabel4.setText("Password:");
//
//        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
//        jLabel5.setText("Phone Number:");
//
//        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
//        jLabel6.setText("Date Of Birth:");
//
//        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
//        jLabel7.setText("Date:");
//
//        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
//        jLabel8.setText("Month:");
//
//        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
//        jLabel9.setText("Year:");
//
//        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
//        jLabel10.setText("Confirm Password:");
//
//        fNameTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        fNameTextField.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                fNameTextFieldActionPerformed(evt);
//            }
//        });
//
//        lNameTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        lNameTextField.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                lNameTextFieldActionPerformed(evt);
//            }
//        });
//
//        emailTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        emailTextField.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                emailTextFieldActionPerformed(evt);
//            }
//        });
//
//        passwordTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        passwordTextField.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                passwordTextFieldActionPerformed(evt);
//            }
//        });
//
//        cPassTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        cPassTextField.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                cPassTextFieldActionPerformed(evt);
//            }
//        });
//
//        phoneTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        phoneTextField.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                phoneTextFieldActionPerformed(evt);
//            }
//        });
//
//        dateTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        dateTextField.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                dateTextFieldActionPerformed(evt);
//            }
//        });
//
//        monthTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        monthTextField.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                monthTextFieldActionPerformed(evt);
//            }
//        });
//
//        yearTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        yearTextField.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                yearTextFieldActionPerformed(evt);
//            }
//        });
//
//        registerButton.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
//        registerButton.setText("Register");
//        registerButton.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                registerButtonActionPerformed(evt);
//            }
//        });
//
//        errorLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
//        errorLabel.setForeground(new java.awt.Color(204, 0, 51));
//        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//        errorLabel.setText("Error");
//
////        ImageIcon backIcon = new ImageIcon(getClass().getResource("/images/back icon.png"));
////        backButton.setIcon(
////            new ImageIcon(backIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH))
////        );
//        backButton.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                backButtonActionPerformed(evt);
//            }
//        });
//
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addGap(440, 440, 440)
//                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                .addGap(48, 48, 48)
//                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addComponent(jLabel6)
//                    .addGroup(layout.createSequentialGroup()
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addComponent(jLabel1)
//                            .addComponent(jLabel4)
//                            .addComponent(jLabel3))
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addGroup(layout.createSequentialGroup()
//                                .addComponent(fNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addGap(47, 47, 47)
//                                .addComponent(jLabel2)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                .addComponent(lNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
//                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
//                                .addComponent(pageHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
//                                    .addComponent(passwordTextField, javax.swing.GroupLayout.Alignment.LEADING)
//                                    .addComponent(emailTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))))
//                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
//                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
//                            .addComponent(jLabel5)
//                            .addGap(34, 34, 34)
//                            .addComponent(phoneTextField))
//                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
//                            .addComponent(jLabel10)
//                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                            .addComponent(cPassTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
//                    .addGroup(layout.createSequentialGroup()
//                        .addComponent(jLabel7)
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                        .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
//                        .addGap(71, 71, 71)
//                        .addComponent(jLabel8)
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                        .addComponent(monthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
//                        .addGap(68, 68, 68)
//                        .addComponent(jLabel9)
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                        .addComponent(yearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
//                    .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addGap(273, 273, 273))
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addGroup(layout.createSequentialGroup()
//                        .addContainerGap()
//                        .addComponent(pageHeading))
//                    .addGroup(layout.createSequentialGroup()
//                        .addGap(22, 22, 22)
//                        .addComponent(backButton)))
//                .addGap(34, 34, 34)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(jLabel1)
//                    .addComponent(jLabel2)
//                    .addComponent(fNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(lNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addGap(36, 36, 36)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(jLabel3)
//                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addGap(30, 30, 30)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(jLabel4)
//                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addGap(27, 27, 27)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(jLabel10)
//                    .addComponent(cPassTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addGap(26, 26, 26)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(jLabel5)
//                    .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addGap(26, 26, 26)
//                .addComponent(jLabel6)
//                .addGap(18, 18, 18)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(jLabel7)
//                    .addComponent(jLabel8)
//                    .addComponent(jLabel9)
//                    .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(monthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(yearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addGap(44, 44, 44)
//                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addGap(65, 65, 65)
//                .addComponent(errorLabel)
//                .addContainerGap(112, Short.MAX_VALUE))
//        );
//
//        pack();
//    }
//
//    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {
//        String year = yearTextField.getText();
//        String month = monthTextField.getText();
//        String day = dateTextField.getText();
//
//        if (lNameTextField.getText().isEmpty() || fNameTextField.getText().isEmpty()) {
//            errorLabel.setText("Name cannot be empty");
//            errorLabel.setVisible(true);
//            return;
//        }
//        if (emailTextField.getText().isEmpty()) {
//            errorLabel.setText("email Invalid");
//            errorLabel.setVisible(true);
//            return;
//        }
//        if (passwordTextField.getText().isEmpty()) {
//            errorLabel.setText("Password cannot be empty");
//            errorLabel.setVisible(true);
//            return;
//        }
//        if (!passwordTextField.getText().equals(cPassTextField.getText())) {
//            errorLabel.setText("Passwords don't match");
//            errorLabel.setVisible(true);
//            return;
//        }
//        if (year.isEmpty() || month.isEmpty() || day.isEmpty()) {
//            errorLabel.setText("Date Not Valid");
//            errorLabel.setVisible(true);
//            return;
//        }
//        if (!isValidDate(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day))) {
//            errorLabel.setText("Date Not Valid");
//            errorLabel.setVisible(true);
//            return;
//        }
//
//        String dateString = year + "-" + month + "-" + day;
//        java.sql.Date dob = java.sql.Date.valueOf(dateString);
//
//        if (SocialMedia.db.addUser(
//            fNameTextField.getText(), lNameTextField.getText(), emailTextField.getText(),
//            passwordTextField.getText(), phoneTextField.getText(), dob
//        )) {
//            errorLabel.setText("Registration Successful");
//            errorLabel.setVisible(true);
//        }
//        else {
//            errorLabel.setText("Could Not Register");
//            errorLabel.setVisible(true);
//        }
//    }
//
//    private void fNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
//        // TODO add your handling code here:
//    }
//
//    private void lNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
//        // TODO add your handling code here:
//    }
//
//    private void emailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
//        // TODO add your handling code here:
//    }
//
//    private void passwordTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
//        // TODO add your handling code here:
//    }
//
//    private void cPassTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
//        // TODO add your handling code here:
//    }
//
//    private void phoneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
//        // TODO add your handling code here:
//    }
//
//    private void dateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
//        // TODO add your handling code here:
//    }
//
//    private void monthTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
//        // TODO add your handling code here:
//    }
//
//    private void yearTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
//        // TODO add your handling code here:
//    }
//
//    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
//        SocialMedia.states.changeState(new LoginPage());
//    }
//
//    private boolean isValidDate(int year, int month, int day) {
//        if (year < 1900 || year > 2100) {
//            System.out.println("Invalid year. Please provide a year between 1900 and 2100.");
//            return false;
//        }
//
//        if (month < 1 || month > 12) {
//            System.out.println("Invalid month. Please provide a month between 1 and 12.");
//            return false;
//        }
//
//        if (day < 1 || day > 31) {
//            System.out.println("Invalid day. Please provide a day between 1 and 31.");
//            return false;
//        }
//
//        return true;
//    }
//
//    // Variables declaration - do not modify
//    private javax.swing.JTextField cPassTextField;
//    private javax.swing.JTextField dateTextField;
//    private javax.swing.JTextField emailTextField;
//    private javax.swing.JTextField fNameTextField;
//    private javax.swing.JLabel jLabel1;
//    private javax.swing.JLabel jLabel10;
//    private javax.swing.JLabel jLabel2;
//    private javax.swing.JLabel jLabel3;
//    private javax.swing.JLabel jLabel4;
//    private javax.swing.JLabel jLabel5;
//    private javax.swing.JLabel jLabel6;
//    private javax.swing.JLabel jLabel7;
//    private javax.swing.JLabel jLabel8;
//    private javax.swing.JLabel jLabel9;
//    private javax.swing.JTextField lNameTextField;
//    private javax.swing.JTextField monthTextField;
//    private javax.swing.JLabel pageHeading;
//    private javax.swing.JTextField passwordTextField;
//    private javax.swing.JTextField phoneTextField;
//    private javax.swing.JButton registerButton;
//    private javax.swing.JTextField yearTextField;
//    private javax.swing.JLabel errorLabel;
//    private javax.swing.JButton backButton;
//    // End of variables declaration
//}

package UI.Screens;

import java.awt.Image;

import javax.swing.ImageIcon;

import main.SocialMedia;

public class RegistrationPage extends BasePage {
    private javax.swing.JTextField usernameTextField;

    public RegistrationPage() {
        initComponents();
        errorLabel.setVisible(false);
    }

    private void initComponents() {
        pageHeading = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel(); // New label for Username
        fNameTextField = new javax.swing.JTextField();
        lNameTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        passwordTextField = new javax.swing.JTextField();
        cPassTextField = new javax.swing.JTextField();
        phoneTextField = new javax.swing.JTextField();
        dateTextField = new javax.swing.JTextField();
        monthTextField = new javax.swing.JTextField();
        yearTextField = new javax.swing.JTextField();
        registerButton = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        usernameTextField = new javax.swing.JTextField(); // New text field for Username

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setSize(new java.awt.Dimension(1280, 720));

        pageHeading.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        pageHeading.setText("Register");

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setText("First Name:");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel2.setText("Last Name:");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel3.setText("Email:");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel4.setText("Password:");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel5.setText("Phone Number:");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel6.setText("Date Of Birth:");

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel7.setText("Date:");

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel8.setText("Month:");

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel9.setText("Year:");

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel10.setText("Confirm Password:");

        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N // New label for Username
        jLabel11.setText("Username:"); // New label for Username

        fNameTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fNameTextFieldActionPerformed(evt);
            }
        });

        lNameTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lNameTextFieldActionPerformed(evt);
            }
        });

        emailTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        emailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextFieldActionPerformed(evt);
            }
        });

        passwordTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passwordTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTextFieldActionPerformed(evt);
            }
        });

        cPassTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cPassTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cPassTextFieldActionPerformed(evt);
            }
        });

        phoneTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        phoneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneTextFieldActionPerformed(evt);
            }
        });

        dateTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateTextFieldActionPerformed(evt);
            }
        });

        monthTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        monthTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthTextFieldActionPerformed(evt);
            }
        });

        yearTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        yearTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearTextFieldActionPerformed(evt);
            }
        });

        registerButton.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        errorLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(204, 0, 51));
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLabel.setText("Error");

        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(440, 440, 440)
                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(pageHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(passwordTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(emailTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(34, 34, 34)
                            .addComponent(phoneTextField))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cPassTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(monthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11) // New label for Username
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED) // New label for Username
                        .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)) // New text field for Username
                    .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(273, 273, 273))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pageHeading))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(backButton)))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(fNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cPassTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18) // New gap for Username
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE) // New layout group for Username
                    .addComponent(jLabel11) // New label for Username
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)) // New text field for Username
                .addGap(26, 26, 26) // New gap for Username
                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(errorLabel)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        pack();
    }

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String year = yearTextField.getText();
        String month = monthTextField.getText();
        String day = dateTextField.getText();

        if (lNameTextField.getText().isEmpty() || fNameTextField.getText().isEmpty()) {
            errorLabel.setText("Name cannot be empty");
            errorLabel.setVisible(true);
            return;
        }
        if (emailTextField.getText().isEmpty()) {
            errorLabel.setText("email Invalid");
            errorLabel.setVisible(true);
            return;
        }
        if (passwordTextField.getText().isEmpty()) {
            errorLabel.setText("Password cannot be empty");
            errorLabel.setVisible(true);
            return;
        }
        if (!passwordTextField.getText().equals(cPassTextField.getText())) {
            errorLabel.setText("Passwords don't match");
            errorLabel.setVisible(true);
            return;
        }
        if (year.isEmpty() || month.isEmpty() || day.isEmpty()) {
            errorLabel.setText("Date Not Valid");
            errorLabel.setVisible(true);
            return;
        }
        if (!isValidDate(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day))) {
            errorLabel.setText("Date Not Valid");
            errorLabel.setVisible(true);
            return;
        }

        String dateString = year + "-" + month + "-" + day;
        java.sql.Date dob = java.sql.Date.valueOf(dateString);

        if (SocialMedia.db.addUser(
            fNameTextField.getText(), lNameTextField.getText(), emailTextField.getText(),
            passwordTextField.getText(), phoneTextField.getText(), dob
        )) {
            errorLabel.setText("Registration Successful");
            errorLabel.setVisible(true);
        }
        else {
            errorLabel.setText("Could Not Register");
            errorLabel.setVisible(true);
        }
    }

    private void fNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void lNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void emailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void passwordTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void cPassTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void phoneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void dateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void monthTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void yearTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        SocialMedia.states.changeState(new LoginPage());
    }

    private boolean isValidDate(int year, int month, int day) {
        if (year < 1900 || year > 2100) {
            System.out.println("Invalid year. Please provide a year between 1900 and 2100.");
            return false;
        }

        if (month < 1 || month > 12) {
            System.out.println("Invalid month. Please provide a month between 1 and 12.");
            return false;
        }

        if (day < 1 || day > 31) {
            System.out.println("Invalid day. Please provide a day between 1 and 31.");
            return false;
        }

        return true;
    }

    // Variables declaration - do not modify
    private javax.swing.JTextField cPassTextField;
    private javax.swing.JTextField dateTextField;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JTextField fNameTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11; // New label for Username
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lNameTextField;
    private javax.swing.JTextField monthTextField;
    private javax.swing.JLabel pageHeading;
    private javax.swing.JTextField passwordTextField;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JButton backButton;
//    private javax.swing.JTextField usernameTextField; // New text field for Username
    private javax.swing.JTextField yearTextField;
    // End of variables declaration
}

