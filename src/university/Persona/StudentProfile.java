/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.Persona;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import university.CourseSchedule.CourseLoad;
import university.CourseSchedule.SeatAssignment;
import university.Persona.EmploymentHistory.EmploymentHistroy;

/**
 *
 * @author kal bugrara
 */
public class StudentProfile {

    Person person;
    Transcript transcript;
    EmploymentHistroy employmenthistory;
    
    //HL: tution balance
    //HL: begins @ 0, balance increases when courses are added, balance decreases when student makes a pamyment. Negative or 0 = fully paid 
    private double balance = 0.0; 
    
    //HL: list for the history of payments & refunds for a student 
    private List<TuitionRecord> paymentHistory = new ArrayList<>(); //HL: added import using AltEnter 

    public StudentProfile(Person p) {

        person = p;
        transcript = new Transcript(this);
        employmenthistory = new EmploymentHistroy();
    }

    public boolean isMatch(String id) {
        return person.getPersonId().equals(id);
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public CourseLoad getCourseLoadBySemester(String semester) {

        return transcript.getCourseLoadBySemester(semester);
    }

    public CourseLoad getCurrentCourseLoad() {

        return transcript.getCurrentCourseLoad();
    }

    public CourseLoad newCourseLoad(String s) {

        return transcript.newCourseLoad(s);
    }

    public ArrayList<SeatAssignment> getCourseList() {

        return transcript.getCourseList();

    }
    
    //HL: method to calcualte total tuition owed (enrolled courses from all semesters
    //HL: called by TuitionPaymentJPanel. Sets initial balance when student opens the panel
    public double getTotalTuitionOwed(){
        double total = 0;
        for (SeatAssignment sa : getCourseList()){
            total += sa.getAssociatedCourse().getCoursePrice();
        }
        return total; 
    }
    
    //HL: getter to return outstanding balance (if any) 
    public double getBalance(){
        return balance; 
    }
    
    //HL: setter to set balance when student opens the payment panel
    public void setBalance(double amount){
        this.balance = amount; 
    }
    
    //HL: method to process payments - subtracts payment amount from balance & records the payment transaction 
    public void pay(double amt){
        balance -= amt;  // reduce outstanding balance
        String date = LocalDate.now().toString(); //HL: added import using AltEnter 
        paymentHistory.add(new TuitionRecord(date, amt, "Tuition Payment")); 
    }
    //HL: method for refund processing - adds payment amount back to balance & records the refund transaction 
    public void refund(double amt, String courseName){
        balance += amt;
        String date = LocalDate.now().toString();
        paymentHistory.add(new TuitionRecord(date, -amt, "Redund: " + courseName));
    }
    
    //HL: boolean - returns true if balance is paid - used to lock & unlock transcript in TranscriptJPanel 
    public boolean isTuitionPaid(){
        return balance <= 0; 
    }
    
    //HL: payment history list - populates list in TuitionPaymentJPanel 
    public List<TuitionRecord> getPaymentHistory(){
        return paymentHistory; 
    }

    
    //HL: called from CourseRegistrationJPanel 
    public int getBalanace() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
