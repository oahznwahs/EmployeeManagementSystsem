/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shawn
 */
public class FullTimeEmployee extends EmployeeInfo {
    
    protected double yearlySalary;
    
    public FullTimeEmployee(int empNumber, String firstName, String lastName, int gender, int workLoc, double deductRate, double yearlySalary) {
        super(empNumber, firstName, lastName, gender, workLoc, deductRate);
        this.yearlySalary = yearlySalary;
    }
    
    public double calcSalary() {
        return yearlySalary * (1 - deductRate);
    }
    
    public double getYearlySalary() {
        return yearlySalary;
    }
    
    public void setYearlySalary(double someSalary) {
        yearlySalary = someSalary;
    }
    
    public String[] getFTEComponent() {
        String EN = Integer.toString(empNumber);
        String FN = firstName;
        String LN = lastName;
        String G = calcGender();
        String WL = calcWL();
        String AW = String.format("%.2f", calcSalary());
        String[] FTE = {"Employee Number: " + EN, "Name: " + FN + " " + LN,  "Gender: " + G, "Work Location: " + WL, "Net Annual Income: $" + AW};
        return FTE;
     }
    
    public String[] getFTEComponent_Save() {
        String EN = Integer.toString(empNumber);
        String FN = firstName;
        String LN = lastName;
        String G = calcGender();
        String WL = calcWL();
        String DR = Double.toString(deductRate);
        String YS = Double.toString(yearlySalary);
        String[] FTE = {EN,FN,LN,WL,G,DR,YS};
        return FTE;
     }
}
