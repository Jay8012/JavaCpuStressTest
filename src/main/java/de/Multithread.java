package de;

import de.rechner.Rechner;

public class Multithread implements Runnable {
    @Override
    public void run() {
        Rechner rechner = new Rechner();
        rechner.fib(1000);
    }
}
