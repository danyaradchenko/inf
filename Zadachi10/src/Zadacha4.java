import java.util.Scanner;
public class Zadacha4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        for (int x = 0; x <= 2 * r; x++) {
            for (int y = 0; y <= 2 * r; y++) {
                int a = (x - r) * (x - r);
                int b = (y - r) * (y - r);
                if (a + b <= r * r) {
                    System.out.print('0');
                } else System.out.print('*');
            }
            System.out.println();
        }
    }

}