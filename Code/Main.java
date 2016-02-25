package com.JohnCrisanto;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        File trialFile;
        Scanner fileScanner;

        try {
            trialFile = new File("C:/Users/John/Desktop/Trial/Course.txt");
            fileScanner = new Scanner(trialFile);
            fileScanner.useDelimiter(",");

            while(fileScanner.hasNext()) {
                String a = fileScanner.next();
                String b = fileScanner.next();
                String c = fileScanner.next();
                String d = fileScanner.next();
                String e = fileScanner.next();
                String f = fileScanner.next();
                String g = fileScanner.next();

                System.out.printf("%-23s %-10s %-11s %-10s %-9s %-16s %-43s%n", a, b, c, d, e, f, g);
                System.out.println();

            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found");
        }
    }
}
