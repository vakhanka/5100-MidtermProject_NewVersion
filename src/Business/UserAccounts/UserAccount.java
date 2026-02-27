/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccounts;

import Business.Profiles.Profile;
import java.time.LocalDateTime;



/**
 *
 * @author kal bugrara
 */
public class UserAccount {
    
    Profile profile;
    String username;
    String password;
    private LocalDateTime lastlogintimestamp; //add a variable for tracking lastlogin
    private LocalDateTime lastupdatetimestamp; //add a variable for tracking last user account edits
    
    public UserAccount (Profile profile, String un, String pw){
        username = un;
        password = pw;
        this.profile = profile;
        this.lastupdatetimestamp = LocalDateTime.now();
        this.lastlogintimestamp = null;

    }
    //Update login and update timestamps
    
    public void updatelastlogin(){
        this.lastlogintimestamp = LocalDateTime.now();
    }

    public LocalDateTime getLastlogintimestamp() {
        return lastlogintimestamp;
    }
    
    public void updatelastupdate(){
        this.lastupdatetimestamp = LocalDateTime.now();
    }

    public LocalDateTime getLastupdatetimestamp() {
        return lastupdatetimestamp;
    }

    public void setLastupdatetimestamp(LocalDateTime lastupdatetimestamp) {
        this.lastupdatetimestamp = lastupdatetimestamp;
    }

    public String getPersonId(){
        return profile.getPerson().getPersonId();
    }
    public String getPersonName(){
        return profile.getPerson().getFullname();
    }
    public String getUserLoginName(){
        return username;
    }

    public boolean isMatch(String id){
        if(getPersonId().equals(id)) return true;
        return false;
    }
    
    public boolean usernameMatch(String un){
        if(getUsername().equals(un)){
            return true;
        }
        return false;
    }
    
    public boolean IsValidUser(String un, String pw){
        
        if (username.equalsIgnoreCase(un) && password.equals(pw)) return true;
        else return false;        
        }
    
    
        
    public String getRole(){
            return profile.getRole();
        }
        
    public Profile getAssociatedPersonProfile(){
            return profile;
        }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
        
    @Override
        public String toString(){
            
            return getUserLoginName();
        }
        
}

