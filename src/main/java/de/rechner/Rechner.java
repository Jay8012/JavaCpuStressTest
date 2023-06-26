package de.rechner;

public class Rechner {
     public long fib(long n) {
        long moeglichkeiten = 0;
        switch ((int) n){
            case 0:
                moeglichkeiten = 0;
                break;
            case 1, 2:
                moeglichkeiten = 1;
                break;
            default:
                moeglichkeiten = fib(n - 1) + fib(n - 2);
        }

         return moeglichkeiten;
     }
}


