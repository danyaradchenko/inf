import java.util.Scanner;
public class Zadacha1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n * 2; i++) {
            for (int j = 1; j <= n * 2 - i; j++) {
                System.out.print(' ');
            }
            for (int j = 0; j < 2 * (i % n) + 1; j++) {
                System.out.print('0');
            }
            for (int j = 0; j < (n * 2 - i) * 2 - 1; j++) {
                System.out.print(' ');
            }
            for (int j = 0; j < (i / n) * (2 * (i % n) + 1); j++) {
                System.out.print('0');
            } System.out.println();
        }
    }

}