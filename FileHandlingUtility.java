// FileHandlingUtility.java

import java.io.*;
import java.util.Scanner;

public class FileHandlingUtility {

    // Method to create a file
    public static void createFile(String fileName) {
        try {
            File file = new File(fileName);

            if (file.createNewFile()) {
                System.out.println("File created successfully: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }

        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    // Method to write into file
    public static void writeFile(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName);

            writer.write(content);
            writer.close();

            System.out.println("Data written successfully.");

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // Method to read file
    public static void readFile(String fileName) {
        try {
            File file = new File(fileName);

            Scanner reader = new Scanner(file);

            System.out.println("\nReading File Content:");

            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }

            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    // Method to modify file content
    public static void modifyFile(String fileName, String oldWord, String newWord) {

        try {
            File file = new File(fileName);

            Scanner reader = new Scanner(file);

            StringBuilder data = new StringBuilder();

            while (reader.hasNextLine()) {
                data.append(reader.nextLine()).append("\n");
            }

            reader.close();

            // Replace old text with new text
            String modifiedData = data.toString().replace(oldWord, newWord);

            FileWriter writer = new FileWriter(fileName);

            writer.write(modifiedData);

            writer.close();

            System.out.println("File modified successfully.");

        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }

    // Main Method
    public static void main(String[] args) {

        String fileName = "Myfile.txt";

        // Create file
        createFile(fileName);

        // Write into file
        writeFile(fileName,
                "Hello World!\nWelcome to Java File Handling Utility.");

        // Read file
        readFile(fileName);

        // Modify file
        modifyFile(fileName, "World", "Student");

        // Read modified file
        readFile(fileName);
    }
}
