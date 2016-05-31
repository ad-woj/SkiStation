/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBClasses.Users;
import Tools.HibernateUtil;
import View.MainWindow;
import java.util.List;
import java.util.Random;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Bluu
 */
public class CashierController {
 
    private static Users selectedUser;
    private Session s;
    
    
    public CashierController()
    {
        s = HibernateUtil.getSessionFactory().openSession();
    }
    
    public List GetUsersList(String text)
    {
         List queryResult = s.createCriteria(Users.class).add(Restrictions.disjunction()
                 .add(Restrictions.like("login", text,MatchMode.ANYWHERE))
                 .add(Restrictions.like("name", text,MatchMode.ANYWHERE))
                 .add(Restrictions.like("surname", text,MatchMode.ANYWHERE))).list();
         
          return queryResult;     
    }
    
    public Users GetRandomUser()
    {
        List queryResult = s.createCriteria(Users.class).list();
        
        Random random = new Random();        
        int randomIndex = Math.abs(random.nextInt()) % queryResult.size();
         
        return (Users)queryResult.get(randomIndex);     
    }
    
    public static void SetSelectedUser(Users newUser, JTextPane textPane)
    {
        selectedUser = newUser;
        SetText(textPane);
    }
    
    public void SetSelectedUserWithString(String newUserString, JTextPane textPane)
    {
        String convertedString = newUserString.subSequence(newUserString.indexOf("(") + 1, newUserString.indexOf(")")).toString();              
        List queryResult = s.createCriteria(Users.class).add(Restrictions.like("login", convertedString,MatchMode.EXACT)).list();
        
        if(queryResult.size() > 0)
        {
            selectedUser = (Users)queryResult.get(0);
        }

        SetText(textPane);
    }

    private static void SetText(JTextPane textPane)
    {
        textPane.setText("Użytkownik: " + GetUserConvertedName(selectedUser));
    }
    
    public static String GetUserConvertedName(Users user)
    {
        return user.getName() + " " + user.getSurname() + " (" + user.getLogin() + ")";
    }
    
}
