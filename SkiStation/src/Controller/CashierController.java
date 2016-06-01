/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBClasses.Attraction;
import DBClasses.Cardusage;
import DBClasses.Terminal;
import DBClasses.Users;
import Tools.HibernateUtil;
import View.MainWindow;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public List GetSkiAttractions()
    {
        List queryResult = s.createCriteria(Attraction.class).add(Restrictions.like("type", "stok")).list();
        
        return queryResult;
        
    }
    
    private Date GetDateNow()
    {
        DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        Date date = null;
        
        try {
            date = originalFormat.parse("01-21-2013 00:00:00");
        } catch (ParseException ex) {
            Logger.getLogger(CashierController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return date;
    }
    
    public int GetSkiAttractionTraffic(Attraction attraction)
    {
        int traffic = 0;
        
        for (Object terminalObject : attraction.getTerminals()) {
            Terminal terminal = (Terminal)terminalObject;
            
            
            
            List queryResult = s.createCriteria(Cardusage.class).add(Restrictions.eq("terminal", terminal))
                   .list();
            
            for (Object result : queryResult) {
                Cardusage usage = (Cardusage)result;
                
                System.out.println("Date: " + usage.getUsedate() + "is after: " + GetDateNow() + " - " + usage.getUsedate().after(GetDateNow()));
                
                if(usage.getUsedate().after(GetDateNow()))
                {
                    traffic++;
                }
            }

            //traffic += queryResult.size();
        }

         return traffic;
    }
}
