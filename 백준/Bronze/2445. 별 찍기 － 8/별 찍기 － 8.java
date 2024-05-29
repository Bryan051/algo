import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < i+1 ; j++) {System.out.print("*");}
            for (int k = 0; k < 2 * N - 2 * (i+1); k++) {System.out.print(" ");}
            for (int j = 0; j < i+1 ; j++) {System.out.print("*");}
            System.out.println();
        }

        for (int i = N - 1; i > 0 ; i--) {
            for (int j = 0; j < i ; j++) {System.out.print("*");}
            for (int k = 0; k < 2 * ( N - i ); k++) {System.out.print(" ");}
            for (int j = 0; j < i ; j++) {System.out.print("*");}
            System.out.println();
        }
    }
}