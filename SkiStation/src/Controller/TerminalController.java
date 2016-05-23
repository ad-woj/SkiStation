/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBClasses.Attraction;
import DBClasses.Employees;
import DBClasses.Users;
import DBClasses.Terminal;
import Tools.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rafał
 */
public class TerminalController {
    
    private Session s;
    
    public TerminalController()
    {
        s = HibernateUtil.getSessionFactory().openSession();
    }
    
    public boolean exist(int terminalID)
    {
        return findTerminal(terminalID) != null;
    }
    
    private Terminal findTerminal(int terminalID)
    {
         List quaryResult = s.createCriteria(Terminal.class).add(Restrictions.like("terminalid", terminalID)).list();
         Terminal terminal;
          if (quaryResult.size()>0) {
            terminal = (Terminal)quaryResult.get(0);
          }else{
            terminal = null;        
          }
          return terminal;     
    }
    
    private Attraction findAttraction(int attractionID)
    {
         List quaryResult = s.createCriteria(Attraction.class).add(Restrictions.like("attractionid", attractionID)).list();
         Attraction attraction;
          if (quaryResult.size()>0) {
            attraction = (Attraction)quaryResult.get(0);
          }else{
            attraction = null;        
          }
          return attraction;     
    }
    
    public boolean addTerminal(int parentAttractionID, int lockTime, StringBuilder message)
    {
        Attraction parentAttraction = findAttraction(parentAttractionID);
        if (parentAttraction!=null) {
            Transaction tr = s.beginTransaction();
            
            Terminal terminal = new Terminal();
            terminal.setAttraction(parentAttraction);
            terminal.setLocktime(lockTime);
            terminal.setProductitems(null);
            s.saveOrUpdate(terminal);
            tr.commit();
            
            message.append("Succesfully added new terminal");
            return true;  
        }else{
            message.append(String.format("Attraction with %d id not exist",parentAttractionID));
            return false;           
        }
    }
   
}
