/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccounts;

import Business.Profiles.Profile;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class UserAccountDirectory {
    
      ArrayList<UserAccount> useraccountlist ;
    
      public UserAccountDirectory (){
          
       useraccountlist = new ArrayList();

    }

    public UserAccount newUserAccount(Profile p, String un, String pw) {

        UserAccount ua = new UserAccount (p,  un,  pw);
        useraccountlist.add(ua);
        return ua;
    }

    public UserAccount findUserAccount(String id) {

        for (UserAccount ua : useraccountlist) {

            if (ua.isMatch(id)) {
                return ua;
            }
        }
            return null; //not found after going through the whole list
         }
     public UserAccount AuthenticateUser(String un, String pw) {

        for (UserAccount ua : useraccountlist) {

            if (ua.IsValidUser(un, pw)) {
                return ua;
            }
        }
            return null; //not found after going through the whole list
         }   
     public ArrayList<UserAccount> getUserAccountList()
     {
         return useraccountlist;
     }
     
     //Add delete user functionality
     public void removeUser(UserAccount ua){
         useraccountlist.remove(ua);
     }
     /*public Person findPerson(String id) {

        for (Person p : personlist) {

            if (p.isMatch(id)) {
                return p;
            }
        }
            return null; //not found after going through the whole list
         }*/
     public UserAccount findusername (String un){
         
         for (UserAccount ua : useraccountlist){
             
             if (ua.getUserLoginName().equals(un)){
                 return ua;
             }
        }
         return null; // username not found
     }
     
     // Method for verifying if an email exists
    public boolean isEmailTaken(String email) {
    for (UserAccount ua : useraccountlist) {
        Profile p = ua.getAssociatedPersonProfile();
        if (p.getEmail() != null && p.getEmail().equalsIgnoreCase(email)) {
            return true;
        }
    }
    return false;
}
}
