/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shawn
 */
public class PartTimeEmployee extends EmployeeInfo {
    
    protected double hourlyWage;
    protected double hoursPerWeek;
    protected double weeksPerYear;
    
    
            
    public PartTimeEmployee(int eN, String fN, String lN, int g, int wL, double dR, double hW, double hPW, double wPY) {
        super(eN, fN, lN, g, wL, dR);
        hourlyWage = hW;
        hoursPerWeek = hPW;
        weeksPerYear = wPY;
    }
    
    public double calcSalary() {
        double salary = hourlyWage * hoursPerWeek * weeksPerYear * (1 - deductRate);
        return salary;
    }
    
    public double getHourlyWage() {
        return hourlyWage;
    }
    
    public void setHourlyWage(double someWage) {
        hourlyWage = someWage;
    }
    
    public double getHoursPerWeek() {
        return hoursPerWeek;
    }
    
    public void setHoursPerWeek(double someHours) {
        hoursPerWeek = someHours;
    }
    
    public double getWeeksPerYear() {
        return weeksPerYear;
    }
    
    public void setWeeksPerYear(double someWeeks) {
        weeksPerYear = someWeeks;
    }
    
    public String[] getPTEComponent() {
        String EN = Integer.toString(empNumber);
        String FN = firstName;
        String LN = lastName;
        String G = calcGender();
        String WL = calcWL();
        String AW = String.format("%.2f", calcSalary());
        String[] PTE = {"Employee Number: " + EN, "Name: " + FN + " " + LN, "Gender: " + G, "Work Location: " + WL, "Net Annual Income: $" + AW};
        return PTE;
     }
    
    public String[] getPTEComponent_Save() {
        String EN = Integer.toString(empNumber);
        String FN = firstName;
        String LN = lastName;
        String G = calcGender();
        String WL = calcWL();
        String DR = Double.toString(deductRate);
        String HW = Double.toString(hourlyWage); 
        String HPW = Double.toString(hoursPerWeek);
        String WPY = Double.toString(weeksPerYear);
        String[] PTE = {EN,FN,LN,WL,G,DR,HW,HPW,WPY};
        return PTE;
     }
}
