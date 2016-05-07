/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Tools.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author MG
 */
public class LoginController {
    
    public static boolean logIn(String login, String password, boolean logged){
        
        Session s = HibernateUtil.getSessionFactory().openSession();
        String hashPass = HashingHelper.sha256(password);
        Query query = s.createQuery(String.format("FROM Users U WHERE U.login = '%s' AND U.password = '%s'", login, hashPass ));
        List results = query.list();
        if (query.list().isEmpty()){
            return false;
        } else {
            logged = true;
            return true;
        }
    }
    
}
