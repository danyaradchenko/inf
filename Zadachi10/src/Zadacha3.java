import java.util.Scanner;
public class Zadacha3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float n = scanner.nextFloat();
        System.out.println(root(n));
    }
    public static float root(float n) {
        float inc = 0.00001F;
        if (n <= 1)
            for (float i = 1; i >= n; i -= inc) {
                if (i * i <= n) return i;
            }
        else
            for (float i = inc; i <= n; i += inc) {
                if (i * i >= n) return i;
            }
        return 0;
    }
}
