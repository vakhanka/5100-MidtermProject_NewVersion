/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.Person.Person;

/**
 *
 * @author kal bugrara
 */
public class EmployeeProfile extends Profile {
    
    private String role;
    
    //bridge to Persona Profile
    private university.Persona.Faculty.FacultyProfile universityProfile;



    public EmployeeProfile(Person p, String role) {

        super(p);
        this.role = role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    
    
    @Override
    public String getRole(){
        return  role;
    }
    
    
    // methods to link to the university package personas
    public void linkUniversityProfile(
            university.Persona.Faculty.FacultyProfile up){
        this.universityProfile = up;
    }
    
    public university.Persona.Faculty.FacultyProfile getUniversityProfile(){
        return universityProfile;
    }

}