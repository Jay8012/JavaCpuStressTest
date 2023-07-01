package de.jay8012;

import de.jay8012.exceptions.MussMirNochWasUeberlegenException;
import de.jay8012.rechner.Rechner;
import de.jay8012.utils.Input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StressTest {
    public void start() throws MussMirNochWasUeberlegenException {

        int cores = coreInput();
        if (cores == Runtime.getRuntime().availableProcessors()) {
            cores = Runtime.getRuntime().availableProcessors() + 1;
        }

        boolean start = true;
        long stufen = 5000;
        while (start) {
            try {
                startThread(cores, stufen);
                start = input();
            } catch (StackOverflowError ignore) {
                stufen = stufen / 2;
            }
        }
    }

    private void startThread(int cores, long stufen) {
        final long fStufen = stufen;
        final List<Thread> threads = new ArrayList<>(cores);
        for (int i = 0; i < cores; i++) {
            final Thread thread = new Thread(() -> {
                Rechner rechner = new Rechner();
                rechner.fib(fStufen);
            });
            thread.start();
            threads.add(thread);
        }
        waitForThreads(threads);
    }


    public void waitForThreads(List<Thread> threadList) {
        threadList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }
        });
    }

    protected boolean input() {
        Scanner s = new Scanner(System.in);
        System.out.println("""
                (0) Nein
                (1) Ja
                """);
        int input = s.nextInt();
        return input == 1;
    }

    private int coreInput() throws MussMirNochWasUeberlegenException {
        System.out.println("How many Threads do u want to stresstest, you have " + Runtime.getRuntime().availableProcessors() + " Thread available?");
        try {
            return Input.checkAnswerForInt();
        } catch (IOException e) {
            throw new MussMirNochWasUeberlegenException();
        }
    }
}