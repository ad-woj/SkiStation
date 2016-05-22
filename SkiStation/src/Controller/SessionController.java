/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
/**
 *
 * @author Marzena
 */
public class SessionController {
    private static String userLogged = "";
    private static long noActionTime = 0;
    //maximum no action time for active session is 5 minutes (300000 miliseconds)
    private static final Integer MAX_TIME = 300000;
    private static RegistrationController.UserTypes loggedUserType;

    public SessionController() {
    }
    
    public static void SetUserLogged( String user ){
        userLogged = user;
        noActionTime = System.currentTimeMillis();
    }
    
    public static void ResetSession() {
        userLogged = "";
        noActionTime = 0;
    }
    public static String GetUserLogged() {
        return userLogged;
    }
    
    public static void UpdateSession() {
        noActionTime = System.currentTimeMillis();
    }
    
    public static Boolean IsUserLogged() {
        long currentTime = System.currentTimeMillis();
        if( currentTime-noActionTime > MAX_TIME )
        {
            noActionTime = 0;
            userLogged = "";
            return false;
        }
        noActionTime = currentTime;
        return true;
    } 
    
    public static void setLoggedUserType(RegistrationController.UserTypes userType){
        loggedUserType = userType;
    }
    
    public static RegistrationController.UserTypes getLoggedUserType(){
        return loggedUserType;
    }
}
