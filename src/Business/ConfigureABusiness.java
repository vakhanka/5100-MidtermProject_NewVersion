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
import university.Persona.Faculty.FacultyDirectory;
import university.CourseCatalog.Course;
import university.CourseSchedule.CourseSchedule;
import university.CourseSchedule.CourseOffer; 


/**
 *
 * @author kal bugrara
 */
class ConfigureABusiness {

    static Business initialize() {
        Business business = new Business("Northeastern University");
        
        // ===== DEPARTMENTS =====
        Department isDept = business.newDepartment("Information Systems");
        Department csDept = business.newDepartment("Computer Science");
        
        // Seed sample course catalog for Information Systems
        /*isDept.newCourse("Application Engineering", "INFO5100", 4);
        isDept.newCourse("Data Science Engineering Methods", "INFO6105", 4);
        isDept.newCourse("agile Software Development", "INFO5200", 4);
        isDept.newCourse("Business Analytics", "INFO5210", 4);
        isDept.newCourse("Prompt Engineering with AI", "INFO6150", 4);
        isDept.newCourse("Software QA and Management", "INFO6205", 4);*/
        
        // ===== IS COURSE CATALOG =====
        university.CourseCatalog.Course info5100 = isDept.newCourse("Application Engineering", "INFO5100", 4);
        university.CourseCatalog.Course info6105 = isDept.newCourse("Data Science Engineering Methods", "INFO6105", 4);
        university.CourseCatalog.Course info5200 = isDept.newCourse("Agile Software Development", "INFO5200", 4);
        university.CourseCatalog.Course info5210 = isDept.newCourse("Business Analytics", "INFO5210", 4);
        university.CourseCatalog.Course info6150 = isDept.newCourse("Prompt Engineering with AI", "INFO6150", 4);
        university.CourseCatalog.Course info6205 = isDept.newCourse("Software QA and Management", "INFO6205", 4);

        // ===== CS COURSE CATALOG =====
        csDept.newCourse("Object-Oriented Design", "CS5004", 4);
        csDept.newCourse("Algorithms", "CS5800", 4);

        // ===== CREATE PERSONA FACULTY (for CourseOffer faculty assignment) =====
        // NOTE: This is separate from Business.Person.Person used for UserAccounts.
        // FacultyDirectory expects university.Persona.Person.
        /*university.Persona.PersonDirectory personaPD = new university.Persona.PersonDirectory();

        university.Persona.Person pf001 = personaPD.newPerson("John Smith");
        university.Persona.Person pf002 = personaPD.newPerson("Sarah Johnson");
        university.Persona.Person pf003 = personaPD.newPerson("Michael Chen");
        university.Persona.Person pf004 = personaPD.newPerson("Emily Davis");
        university.Persona.Person pf005 = personaPD.newPerson("David Wilson");

        university.Persona.Faculty.FacultyProfile f1 = isDept.getFacultyDirectory().newFacultyProfile(pf001);
        university.Persona.Faculty.FacultyProfile f2 = isDept.getFacultyDirectory().newFacultyProfile(pf002);
        university.Persona.Faculty.FacultyProfile f3 = isDept.getFacultyDirectory().newFacultyProfile(pf003);
        university.Persona.Faculty.FacultyProfile f4 = isDept.getFacultyDirectory().newFacultyProfile(pf004);
        university.Persona.Faculty.FacultyProfile f5 = isDept.getFacultyDirectory().newFacultyProfile(pf005);
        
        // comment: Seed same faculty into Computer Science department
        csDept.getFacultyDirectory().newFacultyProfile(pf001);
        csDept.getFacultyDirectory().newFacultyProfile(pf002);
        csDept.getFacultyDirectory().newFacultyProfile(pf003);
        csDept.getFacultyDirectory().newFacultyProfile(pf004);
        csDept.getFacultyDirectory().newFacultyProfile(pf005);*/
        
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
        
        EmployeeProfile faculty1 = employeedirectory.newEmployeeProfile(person001, "Faculty");
        EmployeeProfile faculty2 = employeedirectory.newEmployeeProfile(person002, "Faculty");
        EmployeeProfile faculty3 = employeedirectory.newEmployeeProfile(person003, "Faculty");
        EmployeeProfile faculty4 = employeedirectory.newEmployeeProfile(person004, "Faculty");
        EmployeeProfile faculty5 = employeedirectory.newEmployeeProfile(person005, "Faculty");
        EmployeeProfile faculty6 = employeedirectory.newEmployeeProfile(person006, "Faculty");
        EmployeeProfile faculty7 = employeedirectory.newEmployeeProfile(person007, "Faculty");
        EmployeeProfile faculty8 = employeedirectory.newEmployeeProfile(person008, "Faculty");
        EmployeeProfile faculty9 = employeedirectory.newEmployeeProfile(person009, "Faculty");
        EmployeeProfile faculty10 = employeedirectory.newEmployeeProfile(person010, "Faculty");

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
        // comment: create admin employee using updated method signature from main
        EmployeeProfile admin = employeedirectory.newEmployeeProfile(person021, "Admin");
        
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
        
        //bridge to University Package
        
        // ===== UNIVERSITY SIDE SETUP =====
        
        /*university.Department.Department dept = business.getDepartment();

        // Create university-side courses
        university.CourseCatalog.Course info5100 = isDept.newCourse("Application Engineering", "INFO5100", 4);
        university.CourseCatalog.Course info5200 = isDept.newCourse("Data Management", "INFO5200", 4);
        university.CourseCatalog.Course info5210 = isDept.newCourse("Database Design", "INFO5210", 4);
        university.CourseCatalog.Course info6150 = isDept.newCourse("Web Development", "INFO6150", 4);
        university.CourseCatalog.Course info6205 = isDept.newCourse("Program Structures", "INFO6205", 4);*/

        // Mark INFO5100 as core requirement
        isDept.addCoreCourse(info5100);

        // ===== IS COURSE SCHEDULE — FALL 2025 =====
        university.CourseSchedule.CourseSchedule fall2025 = isDept.newCourseSchedule("Fall 2025");
        university.CourseSchedule.CourseSchedule spring2025 = isDept.newCourseSchedule("Spring 2025");
        
        university.CourseSchedule.CourseOffer co1 = fall2025.newCourseOffer("INFO5100");
        co1.generatSeats(30);
        university.CourseSchedule.CourseOffer co2 = fall2025.newCourseOffer("INFO5200");
        co2.generatSeats(30);
        university.CourseSchedule.CourseOffer co3 = fall2025.newCourseOffer("INFO5210");
        co3.generatSeats(30);
        university.CourseSchedule.CourseOffer co4 = fall2025.newCourseOffer("INFO6150");
        co4.generatSeats(30);
        university.CourseSchedule.CourseOffer co5 = fall2025.newCourseOffer("INFO6205");
        co5.generatSeats(30);

        // ===== CREATE UNIVERSITY-SIDE FACULTY AND LINK TO BUSINESS PROFILES =====
        university.Persona.Faculty.FacultyDirectory facultyDir = isDept.getFacultyDirectory();

        //university.Persona.Person uniFP1 = dept.getPersonDirectory().newPerson("John Smith");
        university.Persona.Person uniFP1 = new university.Persona.Person(faculty1.getPerson().getPersonId());
        university.Persona.Faculty.FacultyProfile uniF1 = facultyDir.newFacultyProfile(uniFP1);
        co1.AssignAsTeacher(uniF1);
        faculty1.linkUniversityProfile(uniF1);

        //university.Persona.Person uniFP2 = dept.getPersonDirectory().newPerson("Sarah Johnson");
        university.Persona.Person uniFP2 = new university.Persona.Person(faculty2.getPerson().getPersonId());
        university.Persona.Faculty.FacultyProfile uniF2 = facultyDir.newFacultyProfile(uniFP2);
        co2.AssignAsTeacher(uniF2);
        faculty2.linkUniversityProfile(uniF2);

        university.Persona.Person uniFP3 = new university.Persona.Person(faculty3.getPerson().getPersonId());
        university.Persona.Faculty.FacultyProfile uniF3 = facultyDir.newFacultyProfile(uniFP3);
        co3.AssignAsTeacher(uniF3);
        faculty3.linkUniversityProfile(uniF3);

        university.Persona.Person uniFP4 = new university.Persona.Person(faculty4.getPerson().getPersonId());
        university.Persona.Faculty.FacultyProfile uniF4 = facultyDir.newFacultyProfile(uniFP4);
        co4.AssignAsTeacher(uniF4);
        faculty4.linkUniversityProfile(uniF4);

        university.Persona.Person uniFP5 = new university.Persona.Person(faculty5.getPerson().getPersonId());
        university.Persona.Faculty.FacultyProfile uniF5 = facultyDir.newFacultyProfile(uniFP5);
        co5.AssignAsTeacher(uniF5);
        faculty5.linkUniversityProfile(uniF5);

        // Remaining faculty get university profiles without course assignments for now
        university.Persona.Person uniFP6 = new university.Persona.Person(faculty6.getPerson().getPersonId());
        university.Persona.Faculty.FacultyProfile uniF6 = facultyDir.newFacultyProfile(uniFP6);
        faculty6.linkUniversityProfile(uniF6);

        university.Persona.Person uniFP7 = new university.Persona.Person(faculty7.getPerson().getPersonId());
        university.Persona.Faculty.FacultyProfile uniF7 = facultyDir.newFacultyProfile(uniFP7);
        faculty7.linkUniversityProfile(uniF7);

        university.Persona.Person uniFP8 = new university.Persona.Person(faculty8.getPerson().getPersonId());
        university.Persona.Faculty.FacultyProfile uniF8 = facultyDir.newFacultyProfile(uniFP8);
        faculty8.linkUniversityProfile(uniF8);

        university.Persona.Person uniFP9 = new university.Persona.Person(faculty9.getPerson().getPersonId());
        university.Persona.Faculty.FacultyProfile uniF9 = facultyDir.newFacultyProfile(uniFP9);
        faculty9.linkUniversityProfile(uniF9);

        university.Persona.Person uniFP10 = new university.Persona.Person(faculty10.getPerson().getPersonId());
        university.Persona.Faculty.FacultyProfile uniF10 = facultyDir.newFacultyProfile(uniFP10);
        faculty10.linkUniversityProfile(uniF10);

        // CREATE UNIVERSITY-SIDE STUDENTS AND LINK TO BUSINESS PROFILES 
        /*String[] studentNames = {
            "Alex Thompson", "Emma Williams", "Noah Lee", "Olivia Harris", "Liam Clark",
            "Sophia Lewis", "Mason Walker", "Ava Hall", "Lucas Young", "Isabella King"
        };


        for (int i = 0; i < 10; i++) {
            university.Persona.Person uniSP = dept.getPersonDirectory().newPerson(studentNames[i]);
            university.Persona.StudentProfile uniStudent = 
                    dept.getStudentDirectory().newStudentProfile(uniSP);
            uniStudent.newCourseLoad("Fall 2025");
            bizStudents[i].linkUniversityProfile(uniStudent);
        }*/
        // Each student gets a university-side profile keyed by their Business NUID.
        // Students 1-10 all go to IS department. Split into CS when csDept is fully operational.
        
        StudentProfile[] bizStudents = {
            student1, student2, student3, student4, student5,
            student6, student7, student8, student9, student10
        };
        
        for (int i = 0; i < 10; i++) {
            String nuid = bizStudents[i].getPerson().getPersonId(); // e.g. "N00001011"
            university.Persona.Person uniSP = new university.Persona.Person(nuid);
            university.Persona.StudentProfile uniStudent = isDept.getStudentDirectory().newStudentProfile(uniSP);
            uniStudent.newCourseLoad("Fall 2025");
            bizStudents[i].linkUniversityProfile(uniStudent);
}

        // Enroll first 5 students in INFO5100 as sample seat assignments
        for (int i = 0; i < 5; i++) {
            university.Persona.StudentProfile uniStudent = bizStudents[i].getUniversityProfile();
            co1.assignEmptySeat(uniStudent.getCurrentCourseLoad());
        }

                return business;

                //
            }
}



