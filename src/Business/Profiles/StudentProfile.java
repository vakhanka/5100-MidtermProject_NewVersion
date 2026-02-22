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
public class StudentProfile extends Profile {

    Person person;
//    Transcript transcript;
    //   EmploymentHistroy employmenthistory;
    
    //bridge to Person in University Package
    private university.Persona.StudentProfile universityProfile;

    public StudentProfile(Person p) {
        super(p);

//        transcript = new Transcript(this);
//        employmenthistory = new EmploymentHistroy();
    }

    @Override
    public String getRole() {
        return "Student";
    }

    public boolean isMatch(String id) {
        return person.getPersonId().equals(id);
    }
    
    //methods to link Business package profile and University package Profile
    public void linkUniversityProfile(
            university.Persona.StudentProfile up){
        this.universityProfile = up;
    }
    
    public university.Persona.StudentProfile getUniversityProfile(){
        return universityProfile;
    }
    

}
