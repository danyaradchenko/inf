import java.util.Scanner;

import static java.lang.Math.abs;

public class Matrix {
    int rowsCount;
    int colsCount;
    double [][] array;
    Scanner in = new Scanner(System.in);

    public void input() {
        System.out.println("Enter matrix size");
        System.out.print("rows: ");
        rowsCount = in.nextInt();
        System.out.print("cols: ");
        colsCount = in.nextInt();
        array = new double [rowsCount][colsCount];
        System.out.println("How do you wanna enter matrix: element by element(1) or line by line(2)? Enter only 1 or 2!!!!");
        String reply = in.next();
        if (reply.equals("1")) {
            for (int i = 0; i < rowsCount; i++) {
                for (int j = 0; j < colsCount; j++) {
                    System.out.println("Enter the element of " + (i + 1) + " row " + (j + 1) + " col");
                    array[i][j] = in.nextDouble();
                }
            }
        } else if (reply.equals("2")) {
            for (int i = 0; i < rowsCount; i++) {
                System.out.println("Enter "+ colsCount + " elements of " + (i + 1) + " row separated by spaces");
                for (int j = 0; j < colsCount; j++) {
                    String elS = in.next();
                    double elD = Double.parseDouble(elS);
                    array[i][j] = elD;
                }
            }
        } else {
            System.out.println("You entered worng! Eneter again. Only 1 or 2");
            String reply2 = in.next();
            if (reply2.equals("1")) {
                for (int i = 0; i < rowsCount; i++) {
                    for (int j = 0; j < colsCount; j++) {
                        System.out.println("Enter the element of " + (i + 1) + " row " + (j + 1) + " col");
                        array[i][j] = in.nextDouble();
                    }
                }
            } else if (reply2.equals("2")) {
                for (int i = 0; i < rowsCount; i++) {
                    System.out.println("Enter "+ colsCount + " elements of " + (i + 1) + " row separated by spaces");
                    for (int j = 0; j < colsCount; j++) {
                        String elS = in.next();
                        double elD = Double.parseDouble(elS);
                        array[i][j] = elD;
                    }
                }
            }
        }
    }
    public void output() {
        System.out.println("Matrix ( " + rowsCount + " * " + colsCount + " )");
        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < colsCount; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    public Matrix multiply(Matrix matrixB) {
        Matrix matrixMultiply = new Matrix();
        if (colsCount == matrixB.rowsCount) {
            matrixMultiply.rowsCount = this.rowsCount;
            matrixMultiply.colsCount = matrixB.colsCount;
            matrixMultiply.array = new double [rowsCount][matrixB.colsCount];
            for (int i = 0; i < rowsCount; i++) {
                for (int j = 0; j < matrixB.colsCount; j++) {
                    for(int k = 0; k < matrixB.colsCount; k++) {
                        matrixMultiply.array[i][j] += array[i][k] * matrixB.array[k][j];
                    }
                }
            }
            return matrixMultiply;
        } else if (matrixB.colsCount == rowsCount) {
            System.out.println("Matrix A * Matrix B multiplication is not possible. Do you wanna do Matrix B * Matrix A?");
            String reply1 = in.next();
            if (reply1.equalsIgnoreCase("y") | reply1.equalsIgnoreCase("yes") | reply1.equalsIgnoreCase("д") |reply1.equalsIgnoreCase("да")) {
                matrixMultiply.array = new double[matrixB.rowsCount][colsCount];
                matrixMultiply.rowsCount = matrixB.rowsCount;
                matrixMultiply.colsCount = this.colsCount;
                for (int i = 0; i < matrixB.rowsCount; i++) {
                    for (int j = 0; j < colsCount; j++) {
                        for (int k = 0; k < rowsCount; k++) {
                            matrixMultiply.array[i][j] += matrixB.array[i][k] * array[k][j];
                        }
                    }
                }
                return matrixMultiply;
            } else{
                return null;
            }
        } else {
            System.out.println("Multiplication is not possible");
            return null;
        }
    }

    public Matrix add(Matrix matrixB) {
        if (this.rowsCount == matrixB.rowsCount & this.colsCount == matrixB.colsCount) {
            Matrix matrixAdd = new Matrix();
            matrixAdd.rowsCount = this.rowsCount;
            matrixAdd.colsCount = this.colsCount;
            matrixAdd.array = new double [rowsCount][matrixB.colsCount];
            for (int i = 0; i < rowsCount; i++) {
                for (int j = 0; j < colsCount; j++) {
                    matrixAdd.array[i][j] = array[i][j] + matrixB.array[i][j];

                }
            }
            return matrixAdd;
        }
        System.out.println("Addition is not possible");
        return null;
    }
    public static int rank(Matrix matrix) {

        matrix = gauss(matrix);
        int result = 0;
        int temp;

        for (int i = 0; i < matrix.rowsCount; i++) {
            temp = 0;
            for (int j = 0; j < matrix.colsCount; j++) {
                if (matrix.array[i][j] == 0) {
                    temp++;
                }
            }
            if (temp == matrix.colsCount) {
                result++;
            }
        }
        return matrix.rowsCount - result;
    }

    public static Matrix gauss(Matrix matrix) {

        for (int i = 0; i < Math.min(matrix.rowsCount, matrix.colsCount); i++) {

            double maxNumber = abs(matrix.array[i][i]);
            int maxRow = i;

            for (int j = i + 1; j < matrix.rowsCount; j++) {
                if (abs(matrix.array[j][i]) > maxNumber) {
                    maxNumber = abs(matrix.array[j][i]);
                    maxRow = j;
                }
            }

            double[] tempRow = matrix.array[i];
            matrix.array[i] = matrix.array[maxRow];
            matrix.array[maxRow] = tempRow;

            for (int k = i + 1; k < matrix.rowsCount; k++) {
                double coef = -(matrix.array[k][i] / matrix.array[i][i]);
                for (int j = i; j < matrix.colsCount; j++) {
                    if (i == j) {
                        matrix.array[k][j] = 0;
                    } else {
                        matrix.array[k][j] += coef * matrix.array[i][j];
                    }
                }
            }
        }
        return matrix;
    }

    public Matrix solve(Matrix matrix) {

        if (matrix.colsCount != 1 | this.rowsCount != matrix.rowsCount) {
            return null;
        }

        Matrix solveM = new Matrix();//расширенная матрица
        solveM.rowsCount = this.rowsCount;
        solveM.colsCount = this.colsCount + 1;
        solveM.array = new double[solveM.rowsCount][solveM.colsCount];

        for (int i = 0; i < this.rowsCount; i++) {
            for (int j = 0; j < solveM.colsCount; j++) {
                if (j == solveM.colsCount - 1) {
                    solveM.array[i][j] = matrix.array[i][0];
                } else {
                    solveM.array[i][j] = this.array[i][j];
                }
            }
        }

        solveM.array = gauss(solveM).array;

        if (rank(this) == rank(solveM) && rank(this) == this.colsCount) {

            for (int i = solveM.rowsCount - 1; i >= 0 ; i--) {
                for (int k = i - 1; k >= 0; k--) {
                    double coef = -(solveM.array[k][i] / solveM.array[i][i]);

                    for (int j = solveM.colsCount - 1; j >= 0; j--) {
                        if (i == j) {
                            solveM.array[k][j] = 0;
                        } else {
                            solveM.array[k][j] += coef * solveM.array[i][j];

                        }
                    }
                }
            }

            System.out.println("System has only one solution");


            Matrix solutions = new Matrix(); //матрица ответов
            solutions.rowsCount = solveM.rowsCount;
            solutions.colsCount = 1;
            solutions.array = new double[solutions.rowsCount][solutions.colsCount];
            for (int i = 0; i < solutions.rowsCount; i++) {
                solutions.array[i][0] = solveM.array[i][solveM.colsCount - 1] / solveM.array[i][i];
            }
            return solutions;

        } else if (rank(this) != rank(solveM)) {
            System.out.println("System has no solutions");
            return null;

        } else {
            System.out.println("System has infinity number of solutions");
            return null;
        }
    }
}