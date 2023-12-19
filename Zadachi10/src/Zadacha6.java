import java.util.Scanner;
public class Zadacha6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        System.out.printf(
                "%sx^2%s%sx%s%s=0%n",
                a, b < 0 ? "" : "+", b, c < 0 ? "" : "+", c
        );

        double[] roots = solve(a, b, c);
        if (roots.length == 2) System.out.printf(
                "Первый корень: %s%nВторой корень: %s%n", roots[0], roots[1]
        );
        else if (roots.length == 1) System.out.printf(
                "Единственный корень: %s%n", roots[0]
        );
        else if (roots.length == 0) System.out.println(
                "Нет корней"
        );
    }

    public static double[] solve(double a, double b, double c) {
        double determinant = b * b - 4 * a * c;
        if (determinant > 0) return new double[]{
                (-b + Math.sqrt(determinant)) / (2 * a),
                (-b - Math.sqrt(determinant)) / (2 * a)
        };
        else if (determinant == 0) return new double[]{-b / (2 * a)};
        else return new double[0];
    }

}
