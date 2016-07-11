/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBClasses.Clients;
import DBClasses.Users;
import Tools.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Marzena
 */
public class ClientController {
    
        
    public static Boolean UpdateClientPoints( String login, int points ) {
         
        int id = GetClientIDFromLogin( login );
        return UpdateClientPoints( id, points );
    }
    
    public static Boolean UpdateClientPoints( int id, int points ) {
                      
        if( id < 0 )
            return false;
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = s.beginTransaction(); 
        Query query = s.createQuery(String.format("UPDATE Clients SET points = '%d' WHERE clientid = '%d'", points, id));
        if (query == null){
            s.close();
            return false;
        }
        query.executeUpdate();
        tr.commit();
        s.close();
        return true;
    }
    
    public static int GetClientIDFromLogin( String login ) {
        UserManagementAdminController controller = new UserManagementAdminController();
        Users u = controller.FindUser(login);
        if (u == null){
            return -1;
        }        
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery(String.format("FROM Clients C WHERE C.users.userid = '%d'", u.getUserid() ));
        if (query == null){
            return -1;
        }
        Clients client = (Clients) query.list().get(0);
        s.close();
        return client.getClientid();
    }
    
    public static int GetClientPoints( int clientID ) {
        Clients client = GetClient( clientID );
        return client.getPoints();
    }
    
    public static Clients GetClient( int clientID ) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery(String.format("FROM Clients C WHERE C.clientid = %d", clientID));
        if (query == null || query.list().isEmpty()){
            return null;
        }
        Clients client = (Clients) query.list().get(0);
        s.close();
        return client;
    }
    
        public static Clients GetClientFromUserID( int userid ) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery(String.format("FROM Clients C WHERE C.users = '%d'", userid));
        if (query == null || query.list().isEmpty()){
            return null;
        }
        Clients client = (Clients) query.list().get(0);
        s.close();
        return client;
    }
}
