//geht bis 92 stufen
//https://www.digitalocean.com/community/tutorials/multithreading-in-java
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("Wie viele Stufen?");
        Scanner scanner = new Scanner(System.in);
        long eingabe = scanner.nextLong();
        long stufen = eingabe;
        if (eingabe <=0) {
            stufen = eingabe * -1;
        }
        long n = fib(stufen);
        System.out.println("Bei " + eingabe + " Stufen, gibt es " + n + " Möglichkeiten.");
    }

    // Potenzielles Problem ist eine Negative anzahl an Stufen
    static long fib(long n){
        long moeglichkeiten = 0;
        switch ((int) n){
            case 0:
                moeglichkeiten = 0;
                break;
            case 1:
                moeglichkeiten = 1;
                break;
            case 2:
                moeglichkeiten = 1;
                break;
            default:
                    moeglichkeiten = fib(n - 1) + fib(n - 2);
                }
        return moeglichkeiten;
    }
}