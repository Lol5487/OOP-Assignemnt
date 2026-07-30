package OOPAssignment;

import OOPAssignment.Gui.MainFrame;

public class MainClass {
    public static void main(String[] args) {

        // 临时测试:造一个学生,跑一次就好
        OOPAssignment.model.Student testStudent = new OOPAssignment.model.Student(
            "S001", "Eeonn", "stud01", "stud123", "eeonn@student.apu.edu.my"
        );
        testStudent.save();

        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }
}