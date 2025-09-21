public class YangHuiTriangle {
    public static void main(String[] args) {
        int n = 6;
        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    mat[i][j] = 1;
                } else {
                    mat[i][j] = mat[i-1][j-1] + mat[i-1][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}