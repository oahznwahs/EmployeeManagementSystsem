/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shawn
 */
import java.util.ArrayList;

public class MyHashTable {
    public ArrayList<EmployeeInfo>[] buckets;
	public int numInHashTable;
	
	public MyHashTable(int numOfBuckets) {
		buckets = new ArrayList[numOfBuckets];
		for (int i = 0; i < numOfBuckets; i++) {
			buckets[i] = new ArrayList<EmployeeInfo>();
		}
	}
	
	public int calcBucket(int keyValue) {
		return(keyValue % buckets.length);
	}
	
	public void addToTable(EmployeeInfo someEmployee) {
		if (someEmployee == null) {
			return;
		}
		
		else {
			buckets[calcBucket(someEmployee.getEmpNumber())].add(someEmployee);
                        numInHashTable++;
		}
	}
	
	public int searchTable(int someEmployee) {
		for (int i = 0; i < buckets[calcBucket(someEmployee)].size(); i++) {
			EmployeeInfo currentStudent = buckets[calcBucket(someEmployee)].get(i);
			if (currentStudent.getEmpNumber() == someEmployee) {
				return i;
			}
		}
		return -1;
	}
	
	public EmployeeInfo removeFromTable(int someEmployee) {
		if (searchTable(someEmployee) > -1) {
			EmployeeInfo currentStudent = buckets[calcBucket(someEmployee)].get(searchTable(someEmployee));
			buckets[calcBucket(someEmployee)].remove(searchTable(someEmployee));
                        numInHashTable--;
			return currentStudent;
		}
		
		return null;
	}
	
	public void displayTable() {
		for (int i = 0; i < buckets.length; i++) {
			for (int x = 0; x < buckets[i].size(); x++) {
				System.out.println(buckets[i].get(x).getEmpNumber());
			}
		}
	}
        
        public void EmptyTable() {
		for (int i = 0; i < buckets.length; i++) {
			for (int x = 0; x < buckets[i].size(); x++) {
				removeFromTable(buckets[i].get(x).getEmpNumber());
			}
		}
	}
}
