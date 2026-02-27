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
public class FacultyProfile extends Profile {

    Person person;
    //   Transcript transcript;
    //   EmploymentHistroy employmenthistory;
    
    //bridge to Person in University Package
    private university.Persona.Faculty.FacultyProfile universityProfile;

    public FacultyProfile(Person p) {
        super(p);
        this.person = p;


//        transcript = new Transcript(this);
//        employmenthistory = new EmploymentHistroy();
    }

    @Override
    public String getRole() {
        return "Faculty";
    }

    public boolean isMatch(String id) {
        return person.getPersonId().equals(id);
    }
    
    //methods to link Business package profile and University package Profile
    public void linkUniversityProfile(
            university.Persona.Faculty.FacultyProfile up){
        this.universityProfile = up;
    }
    
    public university.Persona.Faculty.FacultyProfile getUniversityProfile(){
        return universityProfile;
    }
    

}
