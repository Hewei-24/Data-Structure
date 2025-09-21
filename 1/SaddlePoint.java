import java.util.Scanner;

public class SaddlePoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入矩阵的行数: ");
        int rows = scanner.nextInt();
        System.out.print("请输入矩阵的列数: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("请输入矩阵元素:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        boolean found = false;

        for (int i = 0; i < rows; i++) {
            int maxInRow = matrix[i][0];
            int colIndex = 0;

            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] > maxInRow) {
                    maxInRow = matrix[i][j];
                    colIndex = j;
                }
            }

            boolean isSaddle = true;
            for (int k = 0; k < rows; k++) {
                if (matrix[k][colIndex] < maxInRow) {
                    isSaddle = false;
                    break;
                }
            }

            if (isSaddle) {
                System.out.println("鞍点位置: (" + i + ", " + colIndex + "), 值: " + maxInRow);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("没有鞍点");
        }
        scanner.close();
    }
}