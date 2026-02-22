/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

*/
package Business;

import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Profiles.EmployeeDirectory;
import Business.Profiles.EmployeeProfile;
import Business.Profiles.RegistrarProfile;
import Business.Profiles.StudentDirectory;
import Business.Profiles.StudentProfile;

import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;
import university.Department.Department;


/**
 *
 * @author kal bugrara
 */
class ConfigureABusiness {

    static Business initialize() {
        Business business = new Business("Northeastern University");
        
        Department isDept = business.newDepartment("Information Systems");
        Department csDept = business.newDepartment("Computer Science");
        
        // Seed sample course catalog for Information Systems
        isDept.newCourse("Application Engineering", "INFO5100", 4);
        isDept.newCourse("Data Science Engineering Methods", "INFO6105", 4);

        // Seed sample course catalog for Computer Science
        csDept.newCourse("Object-Oriented Design", "CS5004", 4);
        csDept.newCourse("Algorithms", "CS5800", 4);

        // ===== CREATE 30 PERSONS =====
        PersonDirectory persondirectory = business.getPersonDirectory();
        
        // Faculty persons (10)
        Person person001 = persondirectory.newPerson("John Smith");
        Person person002 = persondirectory.newPerson("Sarah Johnson");
        Person person003 = persondirectory.newPerson("Michael Chen");
        Person person004 = persondirectory.newPerson("Emily Davis");
        Person person005 = persondirectory.newPerson("David Wilson");
        Person person006 = persondirectory.newPerson("Jennifer Martinez");
        Person person007 = persondirectory.newPerson("Robert Anderson");
        Person person008 = persondirectory.newPerson("Lisa Taylor");
        Person person009 = persondirectory.newPerson("James Brown");
        Person person010 = persondirectory.newPerson("Maria Garcia");
        
        // Student persons (10)
        Person person011 = persondirectory.newPerson("Alex Thompson");
        Person person012 = persondirectory.newPerson("Emma Williams");
        Person person013 = persondirectory.newPerson("Noah Lee");
        Person person014 = persondirectory.newPerson("Olivia Harris");
        Person person015 = persondirectory.newPerson("Liam Clark");
        Person person016 = persondirectory.newPerson("Sophia Lewis");
        Person person017 = persondirectory.newPerson("Mason Walker");
        Person person018 = persondirectory.newPerson("Ava Hall");
        Person person019 = persondirectory.newPerson("Lucas Young");
        Person person020 = persondirectory.newPerson("Isabella King");
        
        // Admin and Registrar persons
        Person person021 = persondirectory.newPerson("Admin User");
        Person person022 = persondirectory.newPerson("Registrar User");
        
        // Additional persons to reach 30
        Person person023 = persondirectory.newPerson("Daniel Wright");
        Person person024 = persondirectory.newPerson("Grace Lopez");
        Person person025 = persondirectory.newPerson("Benjamin Hill");
        Person person026 = persondirectory.newPerson("Chloe Scott");
        Person person027 = persondirectory.newPerson("Henry Green");
        Person person028 = persondirectory.newPerson("Mia Adams");
        Person person029 = persondirectory.newPerson("Sebastian Baker");
        Person person030 = persondirectory.newPerson("Amelia Nelson");

        // ===== CREATE 10 FACULTY PROFILES =====
        EmployeeDirectory employeedirectory = business.getEmployeeDirectory();
        
        EmployeeProfile faculty1 = employeedirectory.newEmployeeProfile(person001);
        EmployeeProfile faculty2 = employeedirectory.newEmployeeProfile(person002);
        EmployeeProfile faculty3 = employeedirectory.newEmployeeProfile(person003);
        EmployeeProfile faculty4 = employeedirectory.newEmployeeProfile(person004);
        EmployeeProfile faculty5 = employeedirectory.newEmployeeProfile(person005);
        EmployeeProfile faculty6 = employeedirectory.newEmployeeProfile(person006);
        EmployeeProfile faculty7 = employeedirectory.newEmployeeProfile(person007);
        EmployeeProfile faculty8 = employeedirectory.newEmployeeProfile(person008);
        EmployeeProfile faculty9 = employeedirectory.newEmployeeProfile(person009);
        EmployeeProfile faculty10 = employeedirectory.newEmployeeProfile(person010);

        // ===== CREATE 10 STUDENT PROFILES =====
        StudentDirectory studentdirectory = business.getStudentDirectory();
        
        StudentProfile student1 = studentdirectory.newStudentProfile(person011);
        StudentProfile student2 = studentdirectory.newStudentProfile(person012);
        StudentProfile student3 = studentdirectory.newStudentProfile(person013);
        StudentProfile student4 = studentdirectory.newStudentProfile(person014);
        StudentProfile student5 = studentdirectory.newStudentProfile(person015);
        StudentProfile student6 = studentdirectory.newStudentProfile(person016);
        StudentProfile student7 = studentdirectory.newStudentProfile(person017);
        StudentProfile student8 = studentdirectory.newStudentProfile(person018);
        StudentProfile student9 = studentdirectory.newStudentProfile(person019);
        StudentProfile student10 = studentdirectory.newStudentProfile(person020);

        // ===== CREATE ADMIN & REGISTRAR =====
        EmployeeProfile admin = employeedirectory.newEmployeeProfile(person021);
        
        // Registrar is an administrative employee role; modeled as Profile subtype for role-based UI routing.
        RegistrarProfile registrar = new RegistrarProfile(person022);

        // ===== CREATE USER ACCOUNTS =====
        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
        
        // Admin account
        UserAccount adminAccount = uadirectory.newUserAccount(admin, "admin", "admin123");
        
        // Registrar account
        // Registrar login uses RegistrarProfile so the system loads RegistrarWorkAreaJPanel after authentication.
        UserAccount registrarAccount = uadirectory.newUserAccount(registrar, "registrar", "registrar123");
        
        // Faculty accounts
        UserAccount faculty1Account = uadirectory.newUserAccount(faculty1, "faculty1", "password");
        UserAccount faculty2Account = uadirectory.newUserAccount(faculty2, "faculty2", "password");
        UserAccount faculty3Account = uadirectory.newUserAccount(faculty3, "faculty3", "password");
        UserAccount faculty4Account = uadirectory.newUserAccount(faculty4, "faculty4", "password");
        UserAccount faculty5Account = uadirectory.newUserAccount(faculty5, "faculty5", "password");
        UserAccount faculty6Account = uadirectory.newUserAccount(faculty6, "faculty6", "password");
        UserAccount faculty7Account = uadirectory.newUserAccount(faculty7, "faculty7", "password");
        UserAccount faculty8Account = uadirectory.newUserAccount(faculty8, "faculty8", "password");
        UserAccount faculty9Account = uadirectory.newUserAccount(faculty9, "faculty9", "password");
        UserAccount faculty10Account = uadirectory.newUserAccount(faculty10, "faculty10", "password");
        
        // Student accounts
        UserAccount student1Account = uadirectory.newUserAccount(student1, "student1", "password");
        UserAccount student2Account = uadirectory.newUserAccount(student2, "student2", "password");
        UserAccount student3Account = uadirectory.newUserAccount(student3, "student3", "password");
        UserAccount student4Account = uadirectory.newUserAccount(student4, "student4", "password");
        UserAccount student5Account = uadirectory.newUserAccount(student5, "student5", "password");
        UserAccount student6Account = uadirectory.newUserAccount(student6, "student6", "password");
        UserAccount student7Account = uadirectory.newUserAccount(student7, "student7", "password");
        UserAccount student8Account = uadirectory.newUserAccount(student8, "student8", "password");
        UserAccount student9Account = uadirectory.newUserAccount(student9, "student9", "password");
        UserAccount student10Account = uadirectory.newUserAccount(student10, "student10", "password");

        return business;
    }
}



