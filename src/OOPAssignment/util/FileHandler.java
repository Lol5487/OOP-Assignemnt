/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOPAssignment.util;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileHandler {

    // 把一行资料,写进文件最后面(append模式)
    public static void appendLine(String fileName, String line) {
        try {
            FileWriter fw = new FileWriter(fileName, true);   // true = append,不会覆盖旧资料
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(line);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // 读取整个文件,回传一个String array,每个element是一行
    public static String[] readAllLines(String fileName) {
        String[] lines = new String[100];   // 先假设最多100行
        int count = 0;

        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null && count < lines.length) {
                lines[count] = line;
                count++;
            }
            br.close();
        } catch (IOException e) {
            System.out.println("File not found or error reading: " + e.getMessage());
        }

        // 把array缩到实际的大小(去掉多余的null)
        String[] result = new String[count];
        for (int i = 0; i < count; i++) {
            result[i] = lines[i];
        }
        return result;
    }
}