package org.example;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AppTest 
{
    @Test
    public void testCorrectPassword()
    {
        System.out.println("Testing password: Password.");
        String pass = "Password.";
        boolean result = App.checkPassword(pass);
        assertTrue(result);
    }
    @Test
    public void testPasswordNoCapitalLetters()
    {
        System.out.println("Testing password: password.");
        String pass = "password.";
        boolean result = App.checkPassword(pass);
        assertFalse(result);
    }
    @Test
    public void testPasswordNoSpecialChars()
    {
        System.out.println("Testing password: Password");
        String pass = "Password";
        boolean result = App.checkPassword(pass);
        assertFalse(result);
    }
    @Test
    public void testPasswordNoLettters()
    {
        System.out.println("Testing password: 123456789");
        String pass = "123456789";
        boolean result = App.checkPassword(pass);
        assertFalse(result);
    }
    @Test
    public void testPasswordMoreThan20()
    {
        System.out.println("Testing password: Password.Password.Password");
        String pass = "Password.Password.Password";
        boolean result = App.checkPassword(pass);
        assertFalse(result);
    }
    @Test
    public void readWriteTest() throws IOException {
        System.out.println("Writing to a text file and reading from it to compare strings");
        String toWrite = "Testing methods 123";
        App.writeToFile(toWrite, "C:/Users/Michal/Desktop/JavaProjects/ProgLabsProject/src/main/resources/readWriteTest.txt");
        assertTrue(toWrite.equals());
    }
}
