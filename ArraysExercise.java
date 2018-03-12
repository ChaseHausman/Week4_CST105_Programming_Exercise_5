import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Program: Week4, Programming Exercise 5
 * File: ArraysExercise.java
 * Summary: Creates a multi-dimensional array of characters.
 * Author: Chase Hausman
 * Date: March 10, 2018
 */
public class ArraysExercise {
    public static void main(String args[]) {
        // Open the text file
        File txtFile = new File("src/sampletext.txt");
        Scanner input = null;

        try {
            input = new Scanner(txtFile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found...");
            System.exit(0);
        }

        // Create the array at the specified size
        char[][] theArray = new char[20][45];

        // Get the string of text from the file
        String theText = input.useDelimiter("\\Z").next();

        int row = 0;
        int column = 0;

        // Loop through all the letters of the string.
        for (int i = 0; i < 900; i++) {

            if(i < theText.length()) {
                theArray[row][column] = theText.charAt(i);
            } else {
                theArray[row][column] = "@".charAt(0);
            }

            // Selectively decide when to increment where we store the next character.
            if(column < 44) {
                column++;
            } else {
                column = 0;
                row++;
            }
        }

        // Create a new String
        String newString = "";

        // Reset counting variables
        row = 0;
        column = 0;

        // Loop through every element of the 2D array
        for(int i = 0; i < 900; i++) {
            newString = newString.concat(String.valueOf(theArray[row][column]));

            // Selectively decide when to increment where we get the next character from.
            if(row < 19) {
                row++;
            } else {
                row = 0;
                column++;
            }
        }

        // Display the new string
        System.out.println(newString);
    }
}
