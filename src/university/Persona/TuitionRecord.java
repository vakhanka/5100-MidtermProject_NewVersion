/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university.Persona;

/**
 *
 * @author Hank_Local
 */
public class TuitionRecord {
    
    private String date; //HL: payment date 
    private double amount; //HL: positive = payment from student, negative = refund to student 
    private String description; //HL: defines action, paid tuition or refund for a specific course 
    
    
    //HL: constructor 
    public TuitionRecord(String date, double amount, String description){
        this.date = date;
        this.amount = amount;
        this.description = description;
    }
    
    //HL: added getters using insert code function 
    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
    
    //HL: display formatting method
    public String getFormattedAmount(){
        if (amount < 0) return "-$" + String.format("%.2f", Math.abs(amount)); //HL: less than zero, show NEGATIVE before dollar sign
        return "$" + String.format("%.2f", amount); 
    }
}
