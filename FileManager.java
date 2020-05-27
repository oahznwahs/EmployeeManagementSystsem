/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author shawn
 */
public class FileManager {
    
    
    private static int getOrdinalIndex(String string, String delimiter, int occurrence) {
        int position = string.indexOf(delimiter);
        while (--occurrence > 0 && position != -1) {
            position = string.indexOf(delimiter, position + 1);
        }
        return position;
    }
    
    public void saveConfig(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.append(content);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String loadConfig (String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            return (line);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void loadToHashTable(String fileName, MyHashTable hash, boolean showMessage) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String rawLine = reader.readLine();
            while (!rawLine.equals(null)) {
                int employeeNumber = Integer.parseInt(rawLine.substring(getOrdinalIndex(rawLine, "$", 1) + 1, getOrdinalIndex(rawLine, "$", 2)));
                String firstName = rawLine.substring(getOrdinalIndex(rawLine, "$", 2) + 1, getOrdinalIndex(rawLine, "$", 3));
                String lastName = rawLine.substring(getOrdinalIndex(rawLine, "$", 3) + 1, getOrdinalIndex(rawLine, "$", 4));
                int workLocation = Integer.parseInt(rawLine.substring(getOrdinalIndex(rawLine, "$", 4) + 1, getOrdinalIndex(rawLine, "$", 5)));
                int gender = Integer.parseInt(rawLine.substring(getOrdinalIndex(rawLine, "$", 5) + 1, getOrdinalIndex(rawLine, "$", 6)));
                double deduction = Double.parseDouble(rawLine.substring(getOrdinalIndex(rawLine, "$", 6) + 1, getOrdinalIndex(rawLine, "$", 7)));
                System.out.println(employeeNumber + lastName + deduction);
                if (rawLine.indexOf("F") == 0) {
                    double salary = Double.parseDouble(rawLine.substring(getOrdinalIndex(rawLine, "$", 7) + 1));
                    System.out.println(salary);
                    FullTimeEmployee employee = new FullTimeEmployee(employeeNumber, firstName, lastName, gender, workLocation, deduction, salary);
                    hash.addToTable(employee);
                    rawLine = reader.readLine();
                } else {
                    double hourlyWage = Double.parseDouble(rawLine.substring(getOrdinalIndex(rawLine, "$", 7) + 1, getOrdinalIndex(rawLine, "$", 8)));
                    double hoursPerWeek = Double.parseDouble(rawLine.substring(getOrdinalIndex(rawLine, "$", 8) + 1, getOrdinalIndex(rawLine, "$", 9)));
                    double weeksPerYear = Double.parseDouble(rawLine.substring(getOrdinalIndex(rawLine, "$", 9) + 1));
                    PartTimeEmployee employee = new PartTimeEmployee(employeeNumber, firstName, lastName,
                             gender, workLocation, deduction, hourlyWage, hoursPerWeek, weeksPerYear);
                    hash.addToTable(employee);
                    rawLine = reader.readLine();
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            if (showMessage) {
                JOptionPane.showMessageDialog(null, "File Loaded Successfully!");
            }
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveToFile(String fileName, MyHashTable hash) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < hash.buckets.length; i++) {
			for (int x = 0; x < hash.buckets[i].size(); x++) {
                    EmployeeInfo currentEmployee = hash.buckets[i].get(x);
                    if (currentEmployee instanceof FullTimeEmployee) {
                        FullTimeEmployee employee = (FullTimeEmployee) currentEmployee;
                        writer.append("F$" + employee.empNumber + "$" + employee.firstName + "$" + employee.lastName + "$" + employee.workLoc 
                                + "$" + employee.gender + "$" + employee.deductRate + "$" + employee.yearlySalary);
                        writer.newLine();
                    } else if (currentEmployee instanceof PartTimeEmployee) {
                        PartTimeEmployee employee = (PartTimeEmployee) currentEmployee;
                        writer.append("P$" + employee.empNumber + "$" + employee.firstName + "$" + employee.lastName + "$"
                                + employee.workLoc + "$" + employee.gender + "$" + employee.deductRate + "$" + employee.hourlyWage
                                + "$" + employee.hoursPerWeek + "$" + employee.weeksPerYear);
                        writer.newLine();
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "File Saved Successfully");
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }catch (NullPointerException ex) {
            
        }
    }
}

