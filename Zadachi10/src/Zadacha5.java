public class Zadacha5 {

    public static void main(String[] args) {
        double d = sinMac(Math.PI / 2D);
        System.out.println(d);
    }

    public static double sinMac(double x) {
        double term = x;
        double sum = x;

        int n = 2;
        while (Math.abs(term) >= 1e-9) {
            term *= x * x / ((2 * n - 1) * (2 * n - 2));
            sum += (n % 2 == 0 ? -1 : 1) * term;
            n++;
        }

        return sum;
    }

}
