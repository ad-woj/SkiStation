/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Marzena
 */
public class AccountInfo {
    public String name;
    public String surname;
    public String login;
    public String userID;
    public String documentNumber;
    public String street;
    public String city;
    public String country;
    public String password;
    public Boolean active;
    
    public AccountInfo() {
        name = new String();
        surname = new String();
        login = new String();
        userID = new String();
        documentNumber = new String();
        street = new String();
        city = new String();
        country = new String();
        password = new String();
        active = false;
    }
}
