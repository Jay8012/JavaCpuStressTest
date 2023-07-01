package de;

import de.exceptions.MussMirNochWasUeberlegenException;
import de.utils.Input;


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