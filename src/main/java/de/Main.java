package de;//geht bis 92 stufen

import de.rechner.Rechner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        //Stackoverflow ab 8204

        int cores = Runtime.getRuntime().availableProcessors() + 1;
        boolean start = true;

        while (start) {
            System.out.println("Eingabe der \"Länge\". Beim Test max 8203");
//            Scanner scanner = new Scanner(System.in);
//            final long stufen = scanner.nextInt();
            final long stufen = 500;
            final List<Thread> threads = new ArrayList<>(cores);
            try {
                for (int i = 0; i < cores; i++) {
                    final Thread thread = new Thread(() -> {
                        Rechner rechner = new Rechner();
                        rechner.fib(stufen);
                    });
                    thread.start();
                    threads.add(thread);
                }
                waitForThreads(threads);
//        Rechner rechner = new Rechner();
//
//        rechner.fib(stufen);
            } catch (StackOverflowError ignore) {
                //ignore
            }
            start = input();
        }
    }

    public static void waitForThreads(List<Thread> threadList) {
        threadList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }
        });
    }
    protected static boolean input() {
        Scanner s = new Scanner(System.in);
        System.out.println("""
            (0) Nein
            (1) Ja
            """);
        int input = s.nextInt();
        if (input == 1) {
            return true;
        }
        return false;
    }
}