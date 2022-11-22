package de;//geht bis 92 stufen
//https://www.digitalocean.com/community/tutorials/multithreading-in-java
import de.rechner.Rechner;


public class Main {
    public static void main(String[] args) {
        long stufen = 8203; //Stackoverflow ab 8204
        Rechner rechner = new Rechner();
        rechner.fib(stufen);
    }
}