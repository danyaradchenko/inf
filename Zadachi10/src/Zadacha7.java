import java.util.Scanner;
public class Zadacha7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество чисел, которое вы хотите ввести");
        int n = scanner.nextInt();
        String[] arguments = new String[n];
        System.out.println("Введите числа");
        for (int i = 0; i < n; ++i) {
            arguments[i] = scanner.nextLine();
        }
        int k = 0;
        for (String number: arguments) {
            if (isDescending(number)) k++;
        }
        if (k == 3) System.out.println("Да, чисел 3");
        else System.out.println("Нет, чисел не 3");
    }

    public static boolean isDescending(String number) {
        for (int i = 1; i < number.length(); i++) {
            if (number.charAt(i) > number.charAt(i - 1))
                return false;
        }
        return true;
    }

}