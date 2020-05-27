/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shawn
 */
public class EmployeeInfo {
    protected int empNumber;
    protected String firstName;
    protected String lastName;
    protected int gender;
    protected int workLoc;
    protected double deductRate;
    
    public EmployeeInfo(int empNumber, String firstName, String lastName, int gender, int workLoc, double deductRate) {
        this.empNumber = empNumber;
        this.firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
        this.lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
        this.gender = gender;
        this.workLoc = workLoc;
        this.deductRate = deductRate;
    }
    
    public int getEmpNumber() {
        return empNumber;
    }
    
    public void setEmpNumber(int someNumber) {
        empNumber = someNumber;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String someFN) {
        firstName = someFN;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String someLN) {
        lastName = someLN;
    }
    
    public int getGender() {
        return gender;
    }
    
    public void setGender(int someGender) {
        gender = someGender;
    }
    
    public int getWorkLoc() {
        return workLoc;
    }
    
    public void setWorkLoc(int someLoc) {
        workLoc = someLoc;
    }
    
    public double getDeductRate() {
        return deductRate;
    }
    
    public String calcGender() {
        if (gender == 0) {
            return "Male";
        }
        else {
            return "Female";
        }
    }
    
    public String calcWL () {
        if (workLoc == 0) {
            return "Toronto";
        }
        else if (workLoc == 1) {
            return "Mississauga";
        }
        else {
            return "Oakville";
        }
    }
} 
