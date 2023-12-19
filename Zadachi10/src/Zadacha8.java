import java.util.Arrays;
import java.util.Scanner;
public class Zadacha8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] answer = new int[n];
        int sign = 1;
        for (int i = 1; i <= n; i++) {
            answer[i - 1] =  sign * (i * 2 - 1);
            sign *= -1;
        }
        System.out.println(Arrays.toString(answer));
    }

}