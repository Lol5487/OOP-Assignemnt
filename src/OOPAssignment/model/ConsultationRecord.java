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

public class ConsultationRecord {

    private static final String FILE_PATH = "consultation_records.txt";
    private static final String DELIMITER = "\\|";

    private String recordId;
    private String studentUsername;
    private String counselorUsername;
    private String date;
    private String notes;
    private String recommendation;

    public ConsultationRecord() {
    }

    public ConsultationRecord(String recordId, String studentUsername, String counselorUsername,
                               String date, String notes, String recommendation) {
        this.recordId = recordId;
        this.studentUsername = studentUsername;
        this.counselorUsername = counselorUsername;
        this.date = date;
        this.notes = notes;
        this.recommendation = recommendation;
    }

    public static List<ConsultationRecord> loadAll() {
        List<ConsultationRecord> records = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return records;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(DELIMITER, -1);
                if (parts.length < 6) continue;
                records.add(new ConsultationRecord(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]));
            }
        } catch (IOException e) {
            System.err.println("Error reading consultation record file: " + e.getMessage());
        }
        return records;
    }

    private static void writeAll(List<ConsultationRecord> records) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (ConsultationRecord r : records) {
                bw.write(String.join("|", r.recordId, r.studentUsername, r.counselorUsername,
                        r.date, r.notes, r.recommendation));
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing consultation record file: " + e.getMessage());
        }
    }

    public void save() {
        List<ConsultationRecord> all = loadAll();
        all.add(this);
        writeAll(all);
    }

    public static String generateNextId() {
        return "REC" + (loadAll().size() + 1);
    }

    public static List<ConsultationRecord> findByStudent(String studentUsername) {
        List<ConsultationRecord> result = new ArrayList<>();
        for (ConsultationRecord r : loadAll()) {
            if (r.studentUsername.equalsIgnoreCase(studentUsername)) {
                result.add(r);
            }
        }
        return result;
    }

    public static List<ConsultationRecord> findByCounselor(String counselorUsername) {
        List<ConsultationRecord> result = new ArrayList<>();
        for (ConsultationRecord r : loadAll()) {
            if (r.counselorUsername.equalsIgnoreCase(counselorUsername)) {
                result.add(r);
            }
        }
        return result;
    }

    public String getRecordId() { return recordId; }
    public String getStudentUsername() { return studentUsername; }
    public String getCounselorUsername() { return counselorUsername; }
    public String getDate() { return date; }
    public String getNotes() { return notes; }
    public String getRecommendation() { return recommendation; }
}