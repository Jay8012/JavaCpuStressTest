package de.jay8012;

import de.jay8012.exceptions.MussMirNochWasUeberlegenException;
import de.jay8012.utils.Input;


public class Main {
    public static void main(String[] args) {
        try {
            new StressTest().start();
        } catch (MussMirNochWasUeberlegenException e) {
            Input.close();
            System.exit(1);
        }
        Input.close();
    }
}