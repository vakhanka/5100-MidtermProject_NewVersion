/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.CourseSchedule;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseLoad {
    String semester;
    ArrayList<SeatAssignment> seatassignments;
    
    public CourseLoad(String s){
        seatassignments = new ArrayList();
        semester = s;
    }
    public SeatAssignment newSeatAssignment(CourseOffer co){
        
        Seat seat = co.getEmptySeat(); // seat linked to courseoffer
        if (seat==null) return null;
        SeatAssignment sa = seat.newSeatAssignment(this);
        seatassignments.add(sa);  //add to students course 
        return sa;
    }
    
    public void registerStudent(SeatAssignment sa){
        
        
        sa.assignSeatToStudent(this);
        seatassignments.add(sa);
    }
    
    /* HL: commenting out because we are changing from float to string 
    public float getSemesterScore(){ //total score for a full semeter
        float sum = 0;
        for (SeatAssignment sa: seatassignments){
            sum = sum + sa.GetCourseStudentScore();
        }
        return sum;
    }*/
    
    public double getSemesterScore(){ //HL: total points for full semsester 
        double sum = 0;
        for (SeatAssignment sa : seatassignments){
            sum = sum + sa.getCourseStudentScore(); 
        }
        return sum; 
    }
    
    //HL: method to returns total credits for a semester, enforces 8-credit hours limit per semester (from instructions)
    public int getTotalCredits(){
        int total = 0;
        for (SeatAssignment sa : seatassignments){
            total = total + sa.getCreditHours();
        }
        return total; 
    }
    
    //HL: method to calculate Semester GPA (Transcript.java calls this method)
    public double getSemesterGPA(){
        int totalCredits = getTotalCredits();
        if (totalCredits == 0) return 0.0;
        return getSemesterScore() / totalCredits; 
    }
    
    
    
        public ArrayList<SeatAssignment> getSeatAssignments(){
            return seatassignments;
        }
            
}
