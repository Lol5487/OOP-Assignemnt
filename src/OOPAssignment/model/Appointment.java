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

public class Appointment {

    private static final String FILE_PATH = "appointments.txt";
    private static final String DELIMITER = "\\|";

    private String appointmentId;
    private String studentUsername;
    private String counselorUsername;
    private String date;
    private String time;
    private String type;      // "Walk-in" or "Online"
    private String status;    // "Pending", "Confirmed", "Completed", "Cancelled"

    public Appointment() {
    }

    public Appointment(String appointmentId, String studentUsername, String counselorUsername,
                       String date, String time, String type, String status) {
        this.appointmentId = appointmentId;
        this.studentUsername = studentUsername;
        this.counselorUsername = counselorUsername;
        this.date = date;
        this.time = time;
        this.type = type;
        this.status = status;
    }

    // ---------- File persistence ----------

    public static List<Appointment> loadAll() {
        List<Appointment> appointments = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return appointments;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(DELIMITER, -1);
                if (parts.length < 7) continue;

                Appointment a = new Appointment(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
                appointments.add(a);
            }
        } catch (IOException e) {
            System.err.println("Error reading appointment file: " + e.getMessage());
        }
        return appointments;
    }

    private static void writeAll(List<Appointment> appointments) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Appointment a : appointments) {
                bw.write(String.join("|",
                        a.appointmentId,
                        a.studentUsername,
                        a.counselorUsername,
                        a.date,
                        a.time,
                        a.type,
                        a.status));
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing appointment file: " + e.getMessage());
        }
    }

    /** Saves this appointment, updating if the ID already exists, otherwise adding it. */
    public void save() {
        List<Appointment> all = loadAll();
        boolean updated = false;
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).appointmentId.equals(this.appointmentId)) {
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

    /** Generates the next appointment ID, e.g. "APT1", "APT2", ... */
    public static String generateNextId() {
        List<Appointment> all = loadAll();
        return "APT" + (all.size() + 1);
    }

    // ---------- Queries ----------

    public static List<Appointment> findByStudent(String studentUsername) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment a : loadAll()) {
            if (a.studentUsername.equalsIgnoreCase(studentUsername)) {
                result.add(a);
            }
        }
        return result;
    }

    public static List<Appointment> findByCounselor(String counselorUsername) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment a : loadAll()) {
            if (a.counselorUsername.equalsIgnoreCase(counselorUsername)) {
                result.add(a);
            }
        }
        return result;
    }

    public static Appointment findById(String appointmentId) {
        for (Appointment a : loadAll()) {
            if (a.appointmentId.equals(appointmentId)) {
                return a;
            }
        }
        return null;
    }

    /** Cancels an appointment by ID. Returns true if found and cancelled. */
    public static boolean cancelById(String appointmentId) {
        List<Appointment> all = loadAll();
        for (Appointment a : all) {
            if (a.appointmentId.equals(appointmentId)) {
                a.status = "Cancelled";
                writeAll(all);
                return true;
            }
        }
        return false;
    }

    /** Total count of appointments (used by Admin for statistics). */
    public static int getTotalCount() {
        return loadAll().size();
    }

    public static int getCountByStatus(String status) {
        int count = 0;
        for (Appointment a : loadAll()) {
            if (a.status.equalsIgnoreCase(status)) {
                count++;
            }
        }
        return count;
    }

    // ---------- Getters / Setters ----------

    public String getAppointmentId() {
        return appointmentId;
    }

    public String getStudentUsername() {
        return studentUsername;
    }

    public String getCounselorUsername() {
        return counselorUsername;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setCounselorUsername(String counselorUsername) {
        this.counselorUsername = counselorUsername;
    }
    
    public void setType(String type) {
    this.type = type;
    }
}
