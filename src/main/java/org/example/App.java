package org.example;

import java.io.*;
import java.util.Scanner;


public class App 
{
    public static void main( String[] args ) throws IOException {
        Scanner input = new Scanner(System.in);

        System.out.println("Your password has to meet the following criteria:\n1.Contain at least 8 characters, but no longer than 20 characters\n2.Contain at least one small and big letter\n3.Contain a special symbol, one of these: (*.,)");
        System.out.println( "Provide a secret password below:" );
        String pass = "";
        pass = input.nextLine();
        while (!checkPassword(pass)) {
            System.out.println("Password does not meet the requirements, try again");
            pass = input.nextLine();
        }
        writeToFile(pass, "C:/Users/Michal/Desktop/JavaProjects/ProgLabsProject/src/main/resources/pass.txt");
        readFile("C:/Users/Michal/Desktop/JavaProjects/ProgLabsProject/src/main/resources/text.txt");
    }



    public static String readFile(String filePath) throws IOException {
        try(BufferedReader buffer
                    = new BufferedReader( new InputStreamReader(
                new FileInputStream(filePath) ) )) {
            return buffer.readLine();
        }
    }
    public static void writeToFile(String contentToWrite, String path)
            throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(contentToWrite);

        writer.close();
    }
    public static boolean checkPassword(String password){
        if (password.length()<8 || password.length()>20) return false;

        int smallCharCount = 0;
        int bigCharCount = 0;
        int specialCharCount = 0;
        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (isSmallLetter(ch)) smallCharCount++;
            else if (isBigLetter(ch)) bigCharCount++;
            else if (isSpecialChar(ch)) specialCharCount++;
        }
        return smallCharCount >= 1 && bigCharCount >= 1 && specialCharCount >= 1;
    }
    public static boolean isSmallLetter(char ch) {
        return (ch >= 'a' && ch <= 'z');
    }
    public static boolean isBigLetter(char ch) {
        return (ch >= 'A' && ch <= 'Z');
    }
    public static boolean isSpecialChar(char ch) {
        int indx = "*.,".indexOf(ch);
        return indx != -1;
    }
}
