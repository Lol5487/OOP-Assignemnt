/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopassignment.model;

public class Admin extends User {

    // array to store staff (Counselor/Receptionist), fixed size for now
    private User[] staffList;
    private int staffCount;

    public Admin(String username, String password, String name) {
        super(username, password, name);
        staffList = new User[50]; // max 50 staff, can adjust
        staffCount = 0;
    }

    // CREATE - add new staff (Counselor or Receptionist)
    public boolean addStaff(User newStaff) {
        if (staffCount >= staffList.length) {
            System.out.println("Staff list is full!");
            return false;
        }
        staffList[staffCount] = newStaff;
        staffCount++;
        return true;
    }


    // READ - return all staff as one String, so GUI can display it
    public String viewAllStaff() {
        String result = "=== Staff List ===\n";
        for (int i = 0; i < staffCount; i++) {
            result += (i + 1) + ". " + staffList[i].getName() + " (" + staffList[i].getUsername() + ")\n";
        }
        return result;
}

    // UPDATE - find staff by username, update name
    public boolean updateStaff(String username, String newName) {
        for (int i = 0; i < staffCount; i++) {
            if (staffList[i].getUsername().equals(username)) {
                staffList[i].setName(newName);
                return true;
            }
        }
        return false; // not found
    }

    // DELETE - remove staff by username
    public boolean deleteStaff(String username) {
        for (int i = 0; i < staffCount; i++) {
            if (staffList[i].getUsername().equals(username)) {
                // shift everyone after this one, back by 1
                for (int j = i; j < staffCount - 1; j++) {
                    staffList[j] = staffList[j + 1];
                }
                staffCount--;
                return true;
            }
        }
        return false; // not found
    }

    public void generateReport(String type) {
        System.out.println("Generating " + type + " report...");
    }
}