package handler;

import java.io.*;
import java.util.Scanner;

/**
 * This class defines how to handle files with document numbers
 */
public class FileHandler {

    public static void readFile() {
        String docNumber;
        String message;
        String path;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the absolute path to the file with document numbers: ");
        path = sc.nextLine();
        File file = new File(path);
        File validNumbers = new File(file.getParent() + "//valid-numbers.txt");
        File invalidNumbers = new File(file.getParent() + "//invalid-numbers.txt");

        try {
            if (!validNumbers.exists()) {
                validNumbers.createNewFile();
            }
            if (!invalidNumbers.exists()) {
                invalidNumbers.createNewFile();
            }
        } catch (Exception ex) {
            System.out.println("Failed to create file");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter wValid = new BufferedWriter(new FileWriter(validNumbers));
             BufferedWriter wInvalid = new BufferedWriter(new FileWriter(invalidNumbers))) {
            while ((docNumber = reader.readLine()) != null) {
                if ((message = Validator.checkNumber(docNumber)) == null) {
                    wValid.write(docNumber + "\n");
                } else {
                    wInvalid.write(docNumber + message + "\n");
                }
            }
        } catch (IOException ex) {
            System.out.println("File not found");
        }
    }
}
