/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOPAssignment.model;

import OOPAssignment.util.FileHandler;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 *
 * @author Asus
 */
public class Receptionist extends User{
    
private User[] studentList;
    private int studentCount;
 
    private int nextQueueNumber;
 
    public Receptionist(String username, String password, String name) {
        super(username, password, name);
        studentList = new User[100];
        studentCount = 0;
        nextQueueNumber = 1;
 
        loadStudents();
    }
 
    // ---------- CRUD for students ----------
 
    public boolean addStudent(User newStudent) {
        if (studentCount >= studentList.length) {
            System.out.println("Student list is full!");
            return false;
        }
        studentList[studentCount] = newStudent;
        studentCount++;
 
        String line = newStudent.getUsername() + "," + newStudent.getPassword() + "," + newStudent.getName();
        FileHandler.appendLine("students.txt", line);
 
        return true;
    }
 
    public String viewAllStudents() {
        String result = "=== Student List ===\n";
        for (int i = 0; i < studentCount; i++) {
            result += (i + 1) + ". " + studentList[i].getName() + " (" + studentList[i].getUsername() + ")\n";
        }
        return result;
    }
 
    public int getStudentCount() {
        return studentCount;
    }
 
    public boolean updateStudent(String username, String newName) {
        for (int i = 0; i < studentCount; i++) {
            if (studentList[i].getUsername().equals(username)) {
                studentList[i].setName(newName);
                rewriteStudentFile();
                return true;
            }
        }
        return false;
    }
 
    public boolean deleteStudent(String username) {
        for (int i = 0; i < studentCount; i++) {
            if (studentList[i].getUsername().equals(username)) {
                for (int j = i; j < studentCount - 1; j++) {
                    studentList[j] = studentList[j + 1];
                }
                studentCount--;
                rewriteStudentFile();
                return true;
            }
        }
        return false;
    }
 
    public boolean isUsernameTaken(String username) {
        for (int i = 0; i < studentCount; i++) {
            if (studentList[i].getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
 
    public User findStudentByUsername(String username) {
        for (int i = 0; i < studentCount; i++) {
            if (studentList[i].getUsername().equals(username)) {
                return studentList[i];
            }
        }
        return null;
    }
 
    // ---------- Queue number generation ----------
 
    public int generateQueueNumber() {
        int number = nextQueueNumber;
        nextQueueNumber++;
        return number;
    }
 
    // ---------- File handling ----------
 
    private void loadStudents() {
        String[] lines = FileHandler.readAllLines("students.txt");
 
        for (int i = 0; i < lines.length; i++) {
            String[] parts = lines[i].split(",");
 
            if (parts.length < 3) {
                continue;
            }
 
            String username = parts[0];
            String password = parts[1];
            String name = parts[2];
 
            if (studentCount < studentList.length) {
                studentList[studentCount] = new Student(username, password, name);
                studentCount++;
            }
        }
    }
 
    private void rewriteStudentFile() {
        try {
            FileWriter fw = new FileWriter("students.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < studentCount; i++) {
                bw.write(studentList[i].getUsername() + "," + studentList[i].getPassword() + "," + studentList[i].getName());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Error rewriting student file: " + e.getMessage());
        }
    }
}
