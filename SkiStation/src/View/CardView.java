/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.CardController;
import Controller.CashierController;
import Controller.ClientController;
import Controller.SessionController;
import DBClasses.Users;
import java.awt.Point;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author Marzena
 */
public class CardView {
    private MainWindow parent;
    private JPanel UserMyCardsPanel;
    private int myIndex;
    private JTextField IDTextField;
    private JTextField ActivationDateTextField;
    private JTextField ExpirationDateTextField;
    private JTextField PointsTextField;
    private JButton AddPointsButton;
    private JButton SubtractPointsButton;
    private JButton RemoveCardButton;
    private JButton PrintCardButton;
    private Boolean ignoreTextChange = true;
    private Boolean textUpdateNeeded = false;
    
    public CardView( int index, int positionY, JPanel panel, MainWindow mw ) {
        
        
        IDTextField = new javax.swing.JTextField();
        ActivationDateTextField = new javax.swing.JTextField();
        ExpirationDateTextField = new javax.swing.JTextField();
        PointsTextField = new javax.swing.JTextField();
        AddPointsButton = new javax.swing.JButton();
        SubtractPointsButton = new javax.swing.JButton();
        RemoveCardButton = new javax.swing.JButton();
        PrintCardButton = new javax.swing.JButton();       
        String number = Integer.toString(index);
        parent = mw;
        UserMyCardsPanel = panel;
        myIndex = index;

        
        IDTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        IDTextField.setEditable(false);
        IDTextField.setBackground(new java.awt.Color(250, 250, 250));
        IDTextField.setName("IDTextField" + number); // NOI18N
        IDTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        IDTextField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        UserMyCardsPanel.add(IDTextField);
        IDTextField.setBounds(20, positionY, 60, 20);

        ActivationDateTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ActivationDateTextField.setEditable(false);
        ActivationDateTextField.setBackground(new java.awt.Color(250, 250, 250));
        ActivationDateTextField.setName("ActivationDateTextField" + number); // NOI18N
        ActivationDateTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ActivationDateTextField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        UserMyCardsPanel.add(ActivationDateTextField);
        ActivationDateTextField.setBounds(90, positionY, 80, 20);

        ExpirationDateTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ExpirationDateTextField.setEditable(false);
        ExpirationDateTextField.setBackground(new java.awt.Color(250, 250, 250));
        ExpirationDateTextField.setName("ExpirationDateTextField" + number); // NOI18N
        ExpirationDateTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ExpirationDateTextField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        UserMyCardsPanel.add(ExpirationDateTextField);
        ExpirationDateTextField.setBounds(180, positionY, 80, 20);

        

        
        PointsTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PointsTextField.setName("PointsTextField" + number); // NOI18N
        PointsTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PointsTextField.addFocusListener(new java.awt.event.FocusListener() {
            public void focusGained(java.awt.event.FocusEvent e) {
            };
            public void focusLost(java.awt.event.FocusEvent e){
                if( PointsTextField.getText().length() == 0 ) {
                    PointsTextChanged();
                    PointsTextField.setText("0");
                }
                else if( textUpdateNeeded ) {
                    int id = Integer.decode(IDTextField.getText());
                    int cardPoints = CardController.GetCardPoints(id);
                    PointsTextField.setText(Integer.toString(cardPoints));
                    textUpdateNeeded = false;
                }
            };
        });
        PointsTextField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                PointsTextChanged();
            }
            public void removeUpdate(DocumentEvent e) {
                PointsTextChanged();
            }
            public void insertUpdate(DocumentEvent e) {
                PointsTextChanged();
            }
        });
        UserMyCardsPanel.add(PointsTextField);
        PointsTextField.setBounds(270, positionY, 50, 20);
        
        positionY--;
        AddPointsButton.setText("+");
        AddPointsButton.setMargin(new java.awt.Insets(0, -10, 0, -10));
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
        AddPointsButton.setBounds(355, positionY, 30, 23);

        SubtractPointsButton.setText("-");
        SubtractPointsButton.setMargin(new java.awt.Insets(0, -10, 0, -10));
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
        SubtractPointsButton.setBounds(325, positionY, 30, 23);
        
        RemoveCardButton.setText("Usuń");
        RemoveCardButton.setMargin(new java.awt.Insets(0, -10, 0, -10));
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
        RemoveCardButton.setBounds(390, positionY, 60, 23);
        
        if( UserMyCardsPanel.getName().equalsIgnoreCase( "clientCardsPanel" )) {
            PrintCardButton.setText("Wydaj");
            PrintCardButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    GiveOutCardButtonActionPerformed(evt);
                }
            });
        } else {
            PrintCardButton.setText("Drukuj");
            PrintCardButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    PrintCardButtonActionPerformed(evt);
                }
            });
        }
        PrintCardButton.setMargin(new java.awt.Insets(0, -10, 0, -10));
        PrintCardButton.setMaximumSize(new java.awt.Dimension(67, 23));
        PrintCardButton.setMinimumSize(new java.awt.Dimension(67, 23));
        PrintCardButton.setName("RemoveCardButton" + number); // NOI18N
        PrintCardButton.setPreferredSize(new java.awt.Dimension(67, 23));
        UserMyCardsPanel.add(PrintCardButton);
        PrintCardButton.setBounds(450, positionY, 60, 23);
        
        parent.GetPrintCardPanel().setVisible(false);
        
    }
    
    public void SetIndex( int i ) {
        myIndex = i;
    }
    
    public void SetTextFields( int ID, Date startDate, Date endDate, int points ){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String sd = df.format(startDate);
        String ed = df.format(endDate);
        IDTextField.setText(Integer.toString(ID));
        ActivationDateTextField.setText(sd);
        ExpirationDateTextField.setText(ed);
        PointsTextField.setText(Integer.toString(points));
    }
    
    public void SlideUp( int distance ) {
        Point position = IDTextField.getLocation();
        IDTextField.setLocation( position.x, position.y - distance );
        position = ActivationDateTextField.getLocation();
        ActivationDateTextField.setLocation( position.x, position.y - distance);
        position = ExpirationDateTextField.getLocation();
        ExpirationDateTextField.setLocation( position.x, position.y - distance );
        position = PointsTextField.getLocation();
        PointsTextField.setLocation( position.x, position.y - distance );
        position = AddPointsButton.getLocation();
        AddPointsButton.setLocation( position.x, position.y - distance );
        position = SubtractPointsButton.getLocation();
        SubtractPointsButton.setLocation( position.x, position.y - distance );
        position = RemoveCardButton.getLocation();
        RemoveCardButton.setLocation( position.x, position.y - distance );
        position = PrintCardButton.getLocation();
        PrintCardButton.setLocation( position.x, position.y - distance );
    }
    
    public void DeleteView(){
        UserMyCardsPanel.remove(IDTextField);
        UserMyCardsPanel.remove(ActivationDateTextField);
        UserMyCardsPanel.remove(ExpirationDateTextField);
        UserMyCardsPanel.remove(PointsTextField);
        UserMyCardsPanel.remove(AddPointsButton);
        UserMyCardsPanel.remove(SubtractPointsButton);
        UserMyCardsPanel.remove(RemoveCardButton);
        UserMyCardsPanel.remove(PrintCardButton);
        UserMyCardsPanel.repaint();
    }

    private void RemoveCardButtonActionPerformed(java.awt.event.ActionEvent evt) { 
        if( CardController.DeleteCard(Integer.decode(IDTextField.getText())) ) {
            DeleteView();
            parent.DeleteCardView(myIndex);
        }
    } 
    
    private void PrintCardButtonActionPerformed(java.awt.event.ActionEvent evt) { 
        parent.GetPrintCardPanel().setVisible(true);
        parent.GetPrintCardText().setText(GetCardPrintData(SessionController.GetLoggedUserData()));
    }
        
    private void GiveOutCardButtonActionPerformed(java.awt.event.ActionEvent evt) { 
        parent.GetPrintCardPanel().setVisible(true);
        parent.GetPrintCardText().setText(GetCardPrintData(CashierController.GetSelectedUserData()));
    }
    
    private void SubtractPointsButtonActionPerformed(java.awt.event.ActionEvent evt) {  
        ignoreTextChange = true;                                                     
        int points = Integer.decode(PointsTextField.getText()) - 1;
        int userPoints = Integer.decode(parent.GetAvailablePointsText()) + 1;
        if( points >= 0 ) {
            ClientController.UpdateClientPoints(SessionController.GetUserLogged(), userPoints );
            parent.SetAvailablePointsText(Integer.toString(userPoints));
            UserMyCardsPanel.repaint();
            CardController.UpdateCardPoints(points, Integer.decode(IDTextField.getText()));
            PointsTextField.setText(Integer.toString(points));
            PointsTextField.repaint();
        }
    }
    
    private void AddPointsButtonActionPerformed(java.awt.event.ActionEvent evt) {  
        ignoreTextChange = true;
        int points = Integer.decode(PointsTextField.getText()) + 1;
        int userPoints = Integer.decode(parent.GetAvailablePointsText()) - 1;
        if( userPoints >= 0) {
            ClientController.UpdateClientPoints(SessionController.GetUserLogged(), userPoints);
            parent.SetAvailablePointsText(Integer.toString(userPoints));
            UserMyCardsPanel.repaint();
            CardController.UpdateCardPoints(points, Integer.decode(IDTextField.getText()));
            PointsTextField.setText(Integer.toString(points));
            PointsTextField.repaint();
        }
    }

    
    private void PointsTextChanged() {
        if( ignoreTextChange ) {
            ignoreTextChange = false;
            return;
        }
        String text = PointsTextField.getText();
        if( text.length() == 0 )
            text = "0";
        int id = Integer.decode(IDTextField.getText());
        int cardPoints = CardController.GetCardPoints(id);
        if( !isStringNumeric( text ) ) {
            textUpdateNeeded = true;
            return;
        }
        int points = Integer.decode( text );
        int userPoints = Integer.decode(parent.GetAvailablePointsText());
        userPoints += cardPoints - points;
        if( points >= 0 && userPoints >= 0) {
            ClientController.UpdateClientPoints(SessionController.GetUserLogged(), userPoints );
            parent.SetAvailablePointsText(Integer.toString(userPoints));
            CardController.UpdateCardPoints(points, id);
            PointsTextField.repaint();
        }
        else
            textUpdateNeeded = true;            
    }
    
    private Boolean isStringNumeric( String in ) {
        if( in.length() == 0 )
            return false;
        for( int i = 0; i < in.length(); i++ )
            if( in.charAt(i) < '0' || in.charAt(i) > '9' )
                return false;
        return true;
    }
    
    private String GetCardPrintData(Users user)
    {
        if(user==null)
        {
            return "NoUser";
        }
        
        String text = "Wydrukowano kartę na punkty: \n\nID karty: " + IDTextField.getText() + "\n" + "Data ważności: " + ExpirationDateTextField.getText()
                + "\n" + "Właścicel: " + user.getName() + "\n" + "ID clienta: " + user.getUserid(); 
        
        return text;
    }
}
