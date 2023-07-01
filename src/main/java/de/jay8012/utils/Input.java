package de.jay8012.utils;

import de.jay8012.exceptions.MussMirNochWasUeberlegenException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;


@SuppressWarnings("unused")
public class Input {
    private static int counter = 5;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private Input() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Convert User input into a boolean , ensures that no exception get thrown
     *
     * @return boolean
     */
    public static boolean convertStringIntoBoolean() throws MussMirNochWasUeberlegenException, IOException {
        while (counterForTrys()) {
            String answer = br.readLine().trim().toUpperCase();
            switch (answer) {
                case "JA", "YES", "TRUE" -> {
                    counter = 3;
                    return true;
                }
                case "NEIN", "NO", "FALSE" -> {
                    counter = 3;
                    return false;
                }
                default ->
                        System.out.println("Input invalid, only \"yes\" or \"no\"\nPlease repeat: " + "You still have " + counter + " attempts");
            }
        }
        throw new MussMirNochWasUeberlegenException();
    }

    /**
     * check the User input for an int, ensures that no exception get thrown
     *
     * @return int
     */
    public static int checkAnswerForInt() throws MussMirNochWasUeberlegenException, IOException {
        while (counterForTrys()) {
            int input;
            try {
                input = Integer.parseInt(br.readLine());
                counter = 3;
                return input;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Input error!");
                if (counter != 0) {
                    System.out.println("Try again, you have " + counter + " attempts left");
                }
            }
        }
        throw new MussMirNochWasUeberlegenException();
    }

    public static int readInputAndReturnAsInt() throws MussMirNochWasUeberlegenException, IOException {
        while (counterForTrys()) {
            String input = br.readLine().trim();

            try {
                int inputAsInt = Integer.parseInt(input);
                counter = 3;
                return inputAsInt;
            } catch (NumberFormatException | InputMismatchException e) {
                input = input.toUpperCase();
                char inputAsChar = input.charAt(0);
                counter = 3;
                return (inputAsChar - 65);
            }
        }
        throw new MussMirNochWasUeberlegenException();
    }

    private static boolean counterForTrys() {
        if (counter-- != 0) {
            return true;
        }
        if (counter == 0) {
            counter = 3;
        }
        return false;
    }

    public static void close() {
        try {
            if (br != null) {
                br.close();
            }
        } catch (IOException ignore) {
            br = null;
        }
    }
}