/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import javax.swing.JPanel;

/**
 *
 * @author Marzena
 */
public class CardView {
    private MainWindow parent;
    private JPanel UserMyCardsPanel;
    private int myIndex;
    private javax.swing.JTextField IDTextField;
    private javax.swing.JTextField ActivationDateTextField;
    private javax.swing.JTextField ExpirationDateTextField;
    private javax.swing.JTextField PointsTextField;
    private javax.swing.JButton AddPointsButton;
    private javax.swing.JButton SubtractPointsButton;
    private javax.swing.JButton RemoveCardButton;
    
    public CardView( int index, int positionY, JPanel panel, MainWindow mw ) {
        IDTextField = new javax.swing.JTextField();
        ActivationDateTextField = new javax.swing.JTextField();
        ExpirationDateTextField = new javax.swing.JTextField();
        PointsTextField = new javax.swing.JTextField();
        AddPointsButton = new javax.swing.JButton();
        SubtractPointsButton = new javax.swing.JButton();
        RemoveCardButton = new javax.swing.JButton();
        String number = Integer.toString(index);
        parent = mw;
        UserMyCardsPanel = panel;
        
        IDTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        IDTextField.setEnabled(false);
        IDTextField.setName("IDTextField" + number); // NOI18N
        IDTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        UserMyCardsPanel.add(IDTextField);
        IDTextField.setBounds(20, positionY, 50, 20);

        ActivationDateTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ActivationDateTextField.setEnabled(false);
        ActivationDateTextField.setName("ActivationDateTextField" + number); // NOI18N
        ActivationDateTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        UserMyCardsPanel.add(ActivationDateTextField);
        ActivationDateTextField.setBounds(80, positionY, 80, 20);

        ExpirationDateTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ExpirationDateTextField.setEnabled(false);
        ExpirationDateTextField.setName("ExpirationDateTextField" + number); // NOI18N
        ExpirationDateTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        UserMyCardsPanel.add(ExpirationDateTextField);
        ExpirationDateTextField.setBounds(170, positionY, 80, 20);

        PointsTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PointsTextField.setName("PointsTextField" + number); // NOI18N
        PointsTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        UserMyCardsPanel.add(PointsTextField);
        PointsTextField.setBounds(260, positionY, 50, 20);

        AddPointsButton.setText("+");
        AddPointsButton.setMaximumSize(new java.awt.Dimension(67, 23));
        AddPointsButton.setMinimumSize(new java.awt.Dimension(67, 23));
        AddPointsButton.setName("AddPointsButton" + number); // NOI18N
        AddPointsButton.setPreferredSize(new java.awt.Dimension(67, 23));
        AddPointsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPointsButtonActionPerformed(evt);
            }
        });
        UserMyCardsPanel.add(AddPointsButton);
        AddPointsButton.setBounds(350, positionY, 40, 20);

        SubtractPointsButton.setText("-");
        SubtractPointsButton.setMaximumSize(new java.awt.Dimension(67, 23));
        SubtractPointsButton.setMinimumSize(new java.awt.Dimension(67, 23));
        SubtractPointsButton.setName("SubtractPointsButton" + number); // NOI18N
        SubtractPointsButton.setPreferredSize(new java.awt.Dimension(67, 23));
        SubtractPointsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubtractPointsButtonActionPerformed(evt);
            }
        });        
        UserMyCardsPanel.add(SubtractPointsButton);
        SubtractPointsButton.setBounds(310, positionY, 40, 20);
        
        RemoveCardButton.setText("Usuń kartę");
        RemoveCardButton.setMaximumSize(new java.awt.Dimension(67, 23));
        RemoveCardButton.setMinimumSize(new java.awt.Dimension(67, 23));
        RemoveCardButton.setName("RemoveCardButton" + number); // NOI18N
        RemoveCardButton.setPreferredSize(new java.awt.Dimension(67, 23));
        RemoveCardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveCardButtonActionPerformed(evt);
            }
        });
        UserMyCardsPanel.add(RemoveCardButton);
        RemoveCardButton.setBounds(400, positionY, 100, 23);
    }
    
    public void SetIndex( int i ) {
        myIndex = i;
    }

    private void RemoveCardButtonActionPerformed(java.awt.event.ActionEvent evt) {   
        UserMyCardsPanel.remove(IDTextField);
        UserMyCardsPanel.remove(ActivationDateTextField);
        UserMyCardsPanel.remove(ExpirationDateTextField);
        UserMyCardsPanel.remove(PointsTextField);
        UserMyCardsPanel.remove(AddPointsButton);
        UserMyCardsPanel.remove(SubtractPointsButton);
        UserMyCardsPanel.remove(RemoveCardButton);
        parent.DeleteCardView(myIndex);
    } 
    
    private void SubtractPointsButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
    } 
    
    private void AddPointsButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }
}
