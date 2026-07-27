/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOPAssignment.util;

public class Validator {

    public static boolean isEmpty(String input) {
        return input == null || input.trim().length() == 0;
    }

    public static boolean isValidPassword(String password) {
        return password.length() >= 6;
    }

    public static boolean isValidUsername(String username) {
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            boolean isLetter = (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
            boolean isDigit = (c >= '0' && c <= '9');

            if (!isLetter && !isDigit) {
                return false;
            }
        }
        return true;
    }
}