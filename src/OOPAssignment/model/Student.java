/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOPAssignment.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class Student {
    private static final String FILE_PATH = "students.txt";
    private static final String DELIMITER = "\\|";
 
    private String studentId;
    private String name;
    private String username;
    private String password;
    private String email;
    private int queueNumber;
    private List<String> appointmentHistory;
 
    // No-arg constructor: used when MainFrame creates an "empty" Student
    // object to hand to the login panel, e.g. `new Student()`.
    public Student() {
        this.queueNumber = -1;
        this.appointmentHistory = new ArrayList<>();
    }
 
    // Full constructor: used when creating/registering a student record.
    public Student(String studentId, String name, String username, String password, String email) {
        this.studentId = studentId;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.queueNumber = -1;
        this.appointmentHistory = new ArrayList<>();
    }
 
    /**
     * Called directly from StudentLoginPanel:
     *   boolean success = student.login(inputUsername, inputPassword);
     *
     * Looks the username up in students.txt, checks the password,
     * and if it matches, loads that student's full record into
     * this object so the rest of the app can use it after login.
     */
    public boolean login(String inputUsername, String inputPassword) {
        if (inputUsername == null || inputPassword == null) {
            return false;
        }
 
        Student found = findByUsername(inputUsername);
        if (found != null && found.password.equals(inputPassword)) {
            this.studentId = found.studentId;
            this.name = found.name;
            this.username = found.username;
            this.password = found.password;
            this.email = found.email;
            this.queueNumber = found.queueNumber;
            this.appointmentHistory = found.appointmentHistory;
            return true;
        }
        return false;
    }
 
    // ---------- File persistence ----------
 
    public static Student findByUsername(String username) {
        for (Student s : loadAll()) {
            if (s.username != null && s.username.equalsIgnoreCase(username)) {
                return s;
            }
        }
        return null;
    }
    
    public static String generateNextId() {
    java.util.List<Student> all = loadAll();
    return "S" + String.format("%03d", all.size() + 1);
    }
    
    public static Student findByStudentId(String studentId) {
    for (Student s : loadAll()) {
        if (s.studentId != null && s.studentId.equalsIgnoreCase(studentId)) {
            return s;
        }
    }
    return null;
    }
    
    public static List<Student> loadAll() {
        List<Student> students = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return students; // no records yet
        }
 
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(DELIMITER, -1);
                if (parts.length < 5) continue; // skip malformed lines
 
                Student s = new Student(parts[0], parts[1], parts[2], parts[3], parts[4]);
                if (parts.length >= 6) {
                    try {
                        s.queueNumber = Integer.parseInt(parts[5]);
                    } catch (NumberFormatException e) {
                        s.queueNumber = -1;
                    }
                }
                students.add(s);
            }
        } catch (IOException e) {
            System.err.println("Error reading student file: " + e.getMessage());
        }
        return students;
    }
 
    /** Saves this student to students.txt, updating if it already exists. */
    public void save() {
        List<Student> all = loadAll();
        boolean updated = false;
 
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).username.equalsIgnoreCase(this.username)) {
                all.set(i, this);
                updated = true;
                break;
            }
        }
        if (!updated) {
            all.add(this);
        }
        writeAll(all);
    }
 
    private static void writeAll(List<Student> students) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Student s : students) {
                bw.write(String.join("|",
                        s.studentId,
                        s.name,
                        s.username,
                        s.password,
                        s.email,
                        String.valueOf(s.queueNumber)));
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing student file: " + e.getMessage());
        }
    }
    
    public static boolean deleteByStudentId(String studentId) {
        List<Student> all = loadAll();
        Student toRemove = null;

        for (Student s : all) {
            if (s.studentId.equalsIgnoreCase(studentId)) {
                toRemove = s;
                break;
            }
        }

        if (toRemove != null) {
            all.remove(toRemove);
            writeAll(all);
            return true;
        }
        return false;
    }
 
    // ---------- Appointment-related helpers (per assignment Student requirements) ----------
 
    public void addAppointmentRecord(String record) {
        appointmentHistory.add(record);
    }
 
    public List<String> getAppointmentHistory() {
        return appointmentHistory;
    }
 
    public void setQueueNumber(int queueNumber) {
        this.queueNumber = queueNumber;
    }
 
    public int getQueueNumber() {
        return queueNumber;
    }
 
    // ---------- Getters ----------
 
    public String getStudentId() {
        return studentId;
    }
 
    public String getName() {
        return name;
    }
 
    public String getUsername() {
        return username;
    }
 
    public String getEmail() {
        return email;
    }
    
    public void setName(String name) {
    this.name = name;
}

public void setPassword(String password) {
    this.password = password;
}

public void setEmail(String email) {
    this.email = email;
}
}

