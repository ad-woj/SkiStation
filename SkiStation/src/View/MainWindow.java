/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.RegistrationController;
import Controller.LoginController;
import Controller.UserManagmanetAdminController;
import Model.TestClass;
import java.awt.CardLayout;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;


/**
 *
 * @author Adam
 */
public class MainWindow extends javax.swing.JFrame {

    private boolean userLogged;
    private StringBuilder loginStatusMessage = new StringBuilder();
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UserRoleChooseGroup = new javax.swing.ButtonGroup();
        Login = new javax.swing.JPanel();
        LoginButton = new javax.swing.JButton();
        LoginTextField = new javax.swing.JTextField();
        PasswordTextField = new javax.swing.JPasswordField();
        MessageLabel = new javax.swing.JLabel();
        PasswordLabel = new javax.swing.JLabel();
        LoginLabel = new javax.swing.JLabel();
        CreateAccountLink = new javax.swing.JLabel();
        BackgroundImageLabel = new javax.swing.JLabel();
        ActionInfoLabel = new javax.swing.JLabel();
        Register = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        LoginTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Password = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Surname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        DocumentNumber = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        City = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Country = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Street = new javax.swing.JTextField();
        BackButton = new javax.swing.JButton();
        RegisterButton = new javax.swing.JButton();
        RegisterBackgroundImage1 = new javax.swing.JLabel();
        AdminMainPanel = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        RegisterBackgroundImage2 = new javax.swing.JLabel();
        UserManagmenAdmintPanel = new javax.swing.JPanel();
        UpdateUser = new javax.swing.JButton();
        RemoveUser = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        FindLoginTextField = new javax.swing.JTextField();
        FindUser = new javax.swing.JButton();
        FindResultLabel = new javax.swing.JLabel();
        UserRadio = new javax.swing.JRadioButton();
        CashierRadio = new javax.swing.JRadioButton();
        AdminRadio = new javax.swing.JRadioButton();
        UpdateResultLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 700));
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        Login.setLayout(null);

        LoginButton.setText("Zaloguj");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        Login.add(LoginButton);
        LoginButton.setBounds(490, 120, 80, 23);

        LoginTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginTextFieldActionPerformed(evt);
            }
        });
        Login.add(LoginTextField);
        LoginTextField.setBounds(450, 50, 220, 30);

        PasswordTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordTextFieldActionPerformed(evt);
            }
        });
        Login.add(PasswordTextField);
        PasswordTextField.setBounds(450, 80, 220, 30);

        MessageLabel.setForeground(new java.awt.Color(51, 255, 0));
        MessageLabel.setToolTipText("");
        Login.add(MessageLabel);
        MessageLabel.setBounds(430, 74, 220, 20);
        MessageLabel.getAccessibleContext().setAccessibleName("MessageLabel");

        PasswordLabel.setForeground(new java.awt.Color(255, 255, 255));
        PasswordLabel.setText("Hasło:");
        Login.add(PasswordLabel);
        PasswordLabel.setBounds(390, 90, 50, 10);

        LoginLabel.setForeground(new java.awt.Color(255, 255, 255));
        LoginLabel.setText("Login:");
        Login.add(LoginLabel);
        LoginLabel.setBounds(390, 60, 50, 14);

        CreateAccountLink.setForeground(new java.awt.Color(255, 255, 255));
        CreateAccountLink.setText("Załóż konto");
        CreateAccountLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreateAccountLinkMouseClicked(evt);
            }
        });
        Login.add(CreateAccountLink);
        CreateAccountLink.setBounds(600, 120, 70, 20);

        BackgroundImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/login.jpg"))); // NOI18N
        BackgroundImageLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Login.add(BackgroundImageLabel);
        BackgroundImageLabel.setBounds(10, 0, 1310, 890);

        ActionInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ActionInfoLabel.setText("Trwa logowanie... [Tu będzie jakiś obrazek przedstawiający kręcące się coś albo status bar]");
        ActionInfoLabel.setToolTipText("");
        Login.add(ActionInfoLabel);
        ActionInfoLabel.setBounds(10, 0, 750, 440);

        getContentPane().add(Login, "login");
        Login.getAccessibleContext().setAccessibleName("");

        Register.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ulica");
        Register.add(jLabel8);
        jLabel8.setBounds(360, 240, 90, 30);

        LoginTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginTextField1ActionPerformed(evt);
            }
        });
        Register.add(LoginTextField1);
        LoginTextField1.setBounds(450, 30, 220, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hasło");
        Register.add(jLabel1);
        jLabel1.setBounds(360, 60, 90, 30);

        Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordActionPerformed(evt);
            }
        });
        Register.add(Password);
        Password.setBounds(450, 60, 220, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Imię");
        Register.add(jLabel2);
        jLabel2.setBounds(360, 90, 90, 30);

        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });
        Register.add(Name);
        Name.setBounds(450, 90, 220, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nazwisko");
        Register.add(jLabel3);
        jLabel3.setBounds(360, 120, 90, 30);

        Surname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SurnameActionPerformed(evt);
            }
        });
        Register.add(Surname);
        Surname.setBounds(450, 120, 220, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nr dokumentu");
        Register.add(jLabel4);
        jLabel4.setBounds(360, 150, 90, 30);

        DocumentNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DocumentNumberActionPerformed(evt);
            }
        });
        Register.add(DocumentNumber);
        DocumentNumber.setBounds(450, 150, 220, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Miasto");
        Register.add(jLabel5);
        jLabel5.setBounds(360, 180, 70, 30);

        City.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CityActionPerformed(evt);
            }
        });
        Register.add(City);
        City.setBounds(450, 180, 220, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Państwo");
        Register.add(jLabel6);
        jLabel6.setBounds(360, 210, 90, 30);

        Country.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CountryActionPerformed(evt);
            }
        });
        Register.add(Country);
        Country.setBounds(450, 210, 220, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Login");
        Register.add(jLabel7);
        jLabel7.setBounds(360, 30, 90, 30);

        Street.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StreetActionPerformed(evt);
            }
        });
        Register.add(Street);
        Street.setBounds(450, 240, 220, 30);

        BackButton.setText("Powrót");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        Register.add(BackButton);
        BackButton.setBounds(480, 280, 90, 30);

        RegisterButton.setText("Załóż konto");
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });
        Register.add(RegisterButton);
        RegisterButton.setBounds(570, 280, 100, 30);

        RegisterBackgroundImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/register.jpg"))); // NOI18N
        RegisterBackgroundImage1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Register.add(RegisterBackgroundImage1);
        RegisterBackgroundImage1.setBounds(-6, -6, 1220, 890);

        getContentPane().add(Register, "register");

        AdminMainPanel.setLayout(null);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Stok");
        AdminMainPanel.add(jButton2);
        jButton2.setBounds(180, 370, 160, 80);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("Punkty");
        jButton3.setToolTipText("");
        AdminMainPanel.add(jButton3);
        jButton3.setBounds(350, 280, 160, 80);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setText("Tryb Kasjera");
        AdminMainPanel.add(jButton4);
        jButton4.setBounds(180, 460, 160, 80);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel9.setText("Panel Administratora");
        AdminMainPanel.add(jLabel9);
        jLabel9.setBounds(210, 210, 290, 37);

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton5.setText("Bramki");
        AdminMainPanel.add(jButton5);
        jButton5.setBounds(350, 370, 160, 80);

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton6.setText("Tryb Klienta");
        AdminMainPanel.add(jButton6);
        jButton6.setBounds(350, 460, 160, 80);

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton7.setText("Użytkownicy");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        AdminMainPanel.add(jButton7);
        jButton7.setBounds(180, 280, 160, 80);

        RegisterBackgroundImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/skibackgroundAdmin.jpg"))); // NOI18N
        RegisterBackgroundImage2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        AdminMainPanel.add(RegisterBackgroundImage2);
        RegisterBackgroundImage2.setBounds(-6, -6, 1220, 890);

        getContentPane().add(AdminMainPanel, "adminPanelMain");

        UserManagmenAdmintPanel.setLayout(null);

        UpdateUser.setText("jButton1");
        UpdateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateUserActionPerformed(evt);
            }
        });
        UserManagmenAdmintPanel.add(UpdateUser);
        UpdateUser.setBounds(180, 180, 73, 30);

        RemoveUser.setText("jButton1");
        RemoveUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveUserActionPerformed(evt);
            }
        });
        UserManagmenAdmintPanel.add(RemoveUser);
        RemoveUser.setBounds(70, 180, 73, 30);

        Back.setText("jButton1");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        UserManagmenAdmintPanel.add(Back);
        Back.setBounds(10, 260, 73, 23);

        FindLoginTextField.setText("jTextField1");
        FindLoginTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FindLoginTextFieldActionPerformed(evt);
            }
        });
        UserManagmenAdmintPanel.add(FindLoginTextField);
        FindLoginTextField.setBounds(40, 50, 59, 20);

        FindUser.setText("jButton1");
        FindUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FindUserActionPerformed(evt);
            }
        });
        UserManagmenAdmintPanel.add(FindUser);
        FindUser.setBounds(100, 50, 73, 23);

        FindResultLabel.setText("jLabel10");
        UserManagmenAdmintPanel.add(FindResultLabel);
        FindResultLabel.setBounds(220, 50, 160, 14);

        UserRoleChooseGroup.add(UserRadio);
        UserRadio.setText("User");
        UserRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserRadioActionPerformed(evt);
            }
        });
        UserManagmenAdmintPanel.add(UserRadio);
        UserRadio.setBounds(130, 90, 47, 23);

        UserRoleChooseGroup.add(CashierRadio);
        CashierRadio.setText("Cashier");
        UserManagmenAdmintPanel.add(CashierRadio);
        CashierRadio.setBounds(130, 120, 61, 23);

        UserRoleChooseGroup.add(AdminRadio);
        AdminRadio.setText("Admin");
        UserManagmenAdmintPanel.add(AdminRadio);
        AdminRadio.setBounds(130, 150, 55, 23);

        UpdateResultLabel.setText("jLabel10");
        UserManagmenAdmintPanel.add(UpdateResultLabel);
        UpdateResultLabel.setBounds(160, 230, 40, 14);

        getContentPane().add(UserManagmenAdmintPanel, "userManagmentAdminPanel");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginTextFieldActionPerformed

    private void PasswordTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordTextFieldActionPerformed

    private void CreateAccountLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateAccountLinkMouseClicked
        // TODO add your handling code here:
        CardLayout loginPaneLayout = (CardLayout) getContentPane().getLayout();
        loginPaneLayout.show(getContentPane(), "register");
    }//GEN-LAST:event_CreateAccountLinkMouseClicked

    private void LoginTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginTextField1ActionPerformed

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordActionPerformed

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameActionPerformed

    private void SurnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SurnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SurnameActionPerformed

    private void DocumentNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DocumentNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DocumentNumberActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        //TestClass.test();        // TODO add your handling code here:
        StringBuilder viewPanel = new StringBuilder();
        if (LoginController.logIn(LoginTextField.getText(), new String(PasswordTextField.getPassword()), userLogged, viewPanel, loginStatusMessage)){
            CardLayout loginPaneLayout = (CardLayout) getContentPane().getLayout();
            loginPaneLayout.show(getContentPane(), viewPanel.toString());
            //TODO change view x----DDDDDDDD
        } else
            ;//TODO error message, wrong login and/or password
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void CityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CityActionPerformed

    private void CountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CountryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CountryActionPerformed

    private void StreetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StreetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StreetActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        CardLayout loginPaneLayout = (CardLayout) getContentPane().getLayout();
        loginPaneLayout.show(getContentPane(), "login");
    }//GEN-LAST:event_BackButtonActionPerformed

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed
        RegistrationController regController = new RegistrationController();
        Boolean isSuccess = regController.register(Name.getText(), Surname.getText(), City.getText(), Country.getText(), Street.getText(), LoginTextField1.getText(), new String(Password.getPassword()), DocumentNumber.getText());
        if (isSuccess) {
            CardLayout loginPaneLayout = (CardLayout) getContentPane().getLayout();
            loginPaneLayout.show(getContentPane(), "login");
        }else{
            LoginTextField1.setText("");
        }
    }//GEN-LAST:event_RegisterButtonActionPerformed

    private void UpdateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateUserActionPerformed
            UserManagmanetAdminController controller = new UserManagmanetAdminController();
            String choosingRole = getSelectedButtonText(UserRoleChooseGroup);
            if (controller.exist(FindLoginTextField.getText())) {
            controller.updateUser(FindLoginTextField.getText(), choosingRole);
            UpdateResultLabel.setText("Updated!");
        }else{
                UpdateResultLabel.setText("UserNotExist!");
            }
    }//GEN-LAST:event_UpdateUserActionPerformed

    private void RemoveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveUserActionPerformed
            UserManagmanetAdminController controller = new UserManagmanetAdminController();
            if (controller.removeUser(FindLoginTextField.getText())) {
                UpdateResultLabel.setText("Removed");
            }else{
                UpdateResultLabel.setText("User Not Exist!");
            }
    }//GEN-LAST:event_RemoveUserActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
            CardLayout loginPaneLayout = (CardLayout) getContentPane().getLayout();
            loginPaneLayout.show(getContentPane(), "adminPanelMain");
    }//GEN-LAST:event_BackActionPerformed

    private void FindLoginTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FindLoginTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FindLoginTextFieldActionPerformed

    private void FindUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FindUserActionPerformed
            UserManagmanetAdminController controller = new UserManagmanetAdminController();
            
            if (controller.exist(FindLoginTextField.getText())) {
                FindResultLabel.setText("User Exist!");
                String roleName = controller.getUserRole(FindLoginTextField.getText());

                if (roleName=="User") {
                   UserRoleChooseGroup.setSelected(UserRadio.getModel(), true);
                }else if (roleName.equals(RegistrationController.EmployeeTypes.Admin.toString())) {
                   UserRoleChooseGroup.setSelected(AdminRadio.getModel(), true);
                }else if (roleName.equals(RegistrationController.EmployeeTypes.Cashier.toString())) {
                   UserRoleChooseGroup.setSelected(CashierRadio.getModel(), true);
                }
            }else{
                UserRoleChooseGroup.clearSelection();
                FindResultLabel.setText("User Not Exist!");
            }
            
    }//GEN-LAST:event_FindUserActionPerformed

    private String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
        
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
            CardLayout loginPaneLayout = (CardLayout) getContentPane().getLayout();
            loginPaneLayout.show(getContentPane(), "userManagmentAdminPanel");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void UserRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserRadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserRadioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ActionInfoLabel;
    private javax.swing.JPanel AdminMainPanel;
    private javax.swing.JRadioButton AdminRadio;
    private javax.swing.JButton Back;
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel BackgroundImageLabel;
    private javax.swing.JRadioButton CashierRadio;
    private javax.swing.JTextField City;
    private javax.swing.JTextField Country;
    private javax.swing.JLabel CreateAccountLink;
    private javax.swing.JTextField DocumentNumber;
    private javax.swing.JTextField FindLoginTextField;
    private javax.swing.JLabel FindResultLabel;
    private javax.swing.JButton FindUser;
    private javax.swing.JPanel Login;
    private javax.swing.JButton LoginButton;
    private javax.swing.JLabel LoginLabel;
    private javax.swing.JTextField LoginTextField;
    private javax.swing.JTextField LoginTextField1;
    private javax.swing.JLabel MessageLabel;
    private javax.swing.JTextField Name;
    private javax.swing.JPasswordField Password;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JPasswordField PasswordTextField;
    private javax.swing.JPanel Register;
    private javax.swing.JLabel RegisterBackgroundImage1;
    private javax.swing.JLabel RegisterBackgroundImage2;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JButton RemoveUser;
    private javax.swing.JTextField Street;
    private javax.swing.JTextField Surname;
    private javax.swing.JLabel UpdateResultLabel;
    private javax.swing.JButton UpdateUser;
    private javax.swing.JPanel UserManagmenAdmintPanel;
    private javax.swing.JRadioButton UserRadio;
    private javax.swing.ButtonGroup UserRoleChooseGroup;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
