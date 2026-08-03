package OOPAssignment.model;

import OOPAssignment.util.FileHandler;

public class Receptionist extends User {
    

    private String[] studentIds;
    private String[] studentNames;
    private int studentCount;

    private String[] apptDates;
    private String[] apptStudents;
    private String[] apptStatuses;
    private int apptCount;

    public Receptionist(String username, String password, String name) {
        super(username, password, name);
        
        studentIds = new String[100];
        studentNames = new String[100];
        studentCount = 0;

        apptDates = new String[100];
        apptStudents = new String[100];
        apptStatuses = new String[100];
        apptCount = 0;

        loadStudents();
        loadAppointments();
    }

    public int countStudents() { return studentCount; }
    public int countAppointments() { return apptCount; }
    
    public int countPending() {
        int pending = 0;
        for (int i = 0; i < apptCount; i++) {
            if ("Pending".equalsIgnoreCase(apptStatuses[i])) {
                pending++;
            }
        }
        return pending;
    }
    public int getLiveStudentCount() {
        int count = 0;
        try {
            String[] lines = OOPAssignment.util.FileHandler.readAllLines("students.txt");
            for (String line : lines) {
                if (line != null && !line.trim().isEmpty()) {
                    count++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading students.txt");
        }
        return count;
    }

    public int getLiveAppointmentCount() {
        int count = 0;
        try {
            String[] lines = OOPAssignment.util.FileHandler.readAllLines("appointments.txt");
            for (String line : lines) {
                if (line != null && !line.trim().isEmpty()) {
                    count++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading appointments.txt");
        }
        return count;
    }

    
    public void addAppointment(String appointmentId, String studentUser, String counselorUser, String date, String time, String type, String status) {

        
        
        String line = appointmentId + "|" + studentUser + "|" + counselorUser + "|" + date + "|" + time + "|" + type + "|" + status;
        
        
        FileHandler.appendLine("appointments.txt", line);


        if (apptCount < apptDates.length) {
            apptDates[apptCount] = date;
            apptStudents[apptCount] = studentUser;
            apptStatuses[apptCount] = status;
            apptCount++;
        }
    }

    public void refreshData() {
        studentCount = 0;
        apptCount = 0;
        loadStudents();
        loadAppointments();
    }

    private void loadStudents() {
        String[] lines = FileHandler.readAllLines("students.txt");
        for (String line : lines) {
            if (line.trim().isEmpty()) continue;
            String[] parts = line.split("\\|"); 
            if (parts.length >= 2 && studentCount < studentIds.length) {
                studentIds[studentCount] = parts[0].trim();
                studentNames[studentCount] = parts[1].trim();
                studentCount++;
            }
        }
    }

    
    private void loadAppointments() {
        String[] lines = FileHandler.readAllLines("appointments.txt");
        for (String line : lines) {
            if (line.trim().isEmpty()) continue;
            
            String[] parts = line.split("\\|"); 

            
            if (parts.length >= 7 && apptCount < apptDates.length) {
                apptDates[apptCount] = parts[3].trim(); 
                apptStudents[apptCount] = parts[1].trim();
                apptStatuses[apptCount] = parts[6].trim(); 
                apptCount++;
            }
        }
    }
}