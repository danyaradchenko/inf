public class Main {
    public static void main(String []args){
        Matrix m1 = new Matrix();
        Matrix m2 = new Matrix();
        Matrix m3 = new Matrix();
        m1.input();
        m2.input();
        m3 = m1.solve(m2);
        if (m3 != null) m3.output();
    }
}