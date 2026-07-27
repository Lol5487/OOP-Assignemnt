package OOPAssignment.model;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import OOPAssignment.util.FileHandler;

public class Admin extends User{

    private User[] staffList;
    private int staffCount;

    private String[] scheduleNames;   // 员工名字
    private String[] scheduleDays;    // 对应的上班日
    private int scheduleCount;

    public Admin(String username, String password, String name) {
        super(username, password, name);
        staffList = new User[50];
        staffCount = 0;

        scheduleNames = new String[50];
        scheduleDays = new String[50];
        scheduleCount = 0;
        
        loadStaff();   // 加这行,一造出Admin,就自动读取旧资料
    }

    // ---------- CRUD for staff ----------

    public boolean addStaff(User newStaff) {
        if (staffCount >= staffList.length) {
            System.out.println("Staff list is full!");
            return false;
        }
        staffList[staffCount] = newStaff;
        staffCount++;

        String role = newStaff.getClass().getSimpleName();   // 会自动变成 "Counselor" 或 "Receptionist"
        String line = newStaff.getUsername() + "," + newStaff.getPassword() + "," + newStaff.getName() + "," + role;
        FileHandler.appendLine("staff.txt", line);
        
        return true;
   }

    public String viewAllStaff() {
        String result = "=== Staff List ===\n";
        for (int i = 0; i < staffCount; i++) {
            result += (i + 1) + ". " + staffList[i].getName() + " (" + staffList[i].getUsername() + ")\n";
        }
        return result;
    }

    public boolean updateStaff(String username, String newName) {
        for (int i = 0; i < staffCount; i++) {
            if (staffList[i].getUsername().equals(username)) {
                staffList[i].setName(newName);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStaff(String username) {
        for (int i = 0; i < staffCount; i++) {
            if (staffList[i].getUsername().equals(username)) {
                for (int j = i; j < staffCount - 1; j++) {
                    staffList[j] = staffList[j + 1];
                }
                staffCount--;
                return true;
            }
        }
        return false;
    }

    // ---------- Roster / Schedule ----------

    public boolean addSchedule(String staffName, String day) {
        if (scheduleCount >= scheduleNames.length) {
            System.out.println("Schedule list is full!");
            return false;
        }
        scheduleNames[scheduleCount] = staffName;
        scheduleDays[scheduleCount] = day;
        scheduleCount++;
        return true;
    }

    public String viewSchedule() {
        String result = "=== Staff Roster ===\n";
        for (int i = 0; i < scheduleCount; i++) {
            result += scheduleNames[i] + " works on " + scheduleDays[i] + "\n";
        }
        return result;
    }

    // ---------- Generate report (writes to a text file) ----------

    public boolean generateReport(String type) {
        try {
            FileWriter fw = new FileWriter(type + "_report.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("=== " + type.toUpperCase() + " REPORT ===\n");
            bw.write("Total staff: " + staffCount + "\n\n");

            for (int i = 0; i < staffCount; i++) {
                bw.write((i + 1) + ". " + staffList[i].getName() + " (" + staffList[i].getUsername() + ")\n");
            }

            bw.close();
            System.out.println("Report saved as " + type + "_report.txt");
            return true;
        } catch (IOException e) {
            System.out.println("Error writing report: " + e.getMessage());
            return false;
        }
    }
    private void loadStaff() {
    String[] lines = FileHandler.readAllLines("staff.txt");

    for (int i = 0; i < lines.length; i++) {
        String[] parts = lines[i].split(",");
    
        if (parts.length < 4) {
            continue;   // 资料格式不对,跳过这一行
        }
        String username = parts[0];
        String password = parts[1];
        String name = parts[2];
        String role = parts[3];

        User staff = null;

        if (role.equals("Counselor")) {
            staff = new Counselor(username, password, name);
        }
        // 之后Receptionist写好了,这里也加:
        // else if (role.equals("Receptionist")) {
        //     staff = new Receptionist(username, password, name);
        // }

        if (staff != null && staffCount < staffList.length) {
            staffList[staffCount] = staff;
            staffCount++;
        }
    }
}
    public boolean isUsernameTaken(String username) {
    for (int i = 0; i < staffCount; i++) {
        if (staffList[i].getUsername().equals(username)) {
            return true;
        }
    }
        return false;
        }
}
