/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBClasses.Employees;
import DBClasses.Users;
import Tools.HibernateUtil;
import com.sun.media.jfxmedia.logging.Logger;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import Controller.RegistrationController;
/**
 *
 * @author MG
 */
public class LoginController {
    
    public static boolean logIn(String login, String password, boolean logged, StringBuilder viewName){
        
        Session s = HibernateUtil.getSessionFactory().openSession();
        String hashPass = HashingHelper.sha256(password);
        Query query = s.createQuery(String.format("FROM Users U WHERE U.login = '%s' AND U.password = '%s'", login, hashPass ));
        if (query.list().isEmpty() || login.equals("") || password.equals("")){
            System.out.println("Failed login");
            return false;
        } else {
            logged = true;
            Users user = (Users)query.list().get(0);
            Query query2 = s.createQuery(String.format("FROM Employees E WHERE E.users = '%d'",user.getUserid()));
            Employees employee = (Employees)query2.list().get(0);
            
            if (employee == null) {
                viewName.append("userPanel");
            }else if (employee.getRole().equals(RegistrationController.EmployeeTypes.Admin.toString()) ) {
                viewName.append("adminPanelMain");
            }else if (employee.getRole().equals(RegistrationController.EmployeeTypes.Cashier.toString())) {
                viewName.append("cashierPanel");
            }
            
            System.out.println("Successful login");  
            return true;
        }
    }
    
}
