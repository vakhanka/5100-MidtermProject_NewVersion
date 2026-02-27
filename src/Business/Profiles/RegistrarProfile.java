/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Profiles;

import Business.Person.Person;

/**
 *
 * @author Lanre
 */
public class RegistrarProfile extends Profile {
    private String officeHours;
    
    public RegistrarProfile(Person p) {
        super(p);
        this.officeHours = officeHours;
        
        
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }
    
    
    @Override
    public String getRole() {
        return "Registrar";
    }
}
