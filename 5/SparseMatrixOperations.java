import java.util.*;

public class SparseMatrixOperations {

    static class Triple {
        int row;    // 行号
        int col;    // 列号
        int value;  // 值

        public Triple(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }

        public String toString() {
            return "(" + row + ", " + col + ", " + value + ")";
        }

        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Triple triple = (Triple) obj;
            return row == triple.row && col == triple.col && value == triple.value;
        }
    }

    static class SparseMatrix {
        private int rows;        // 矩阵行数
        private int cols;        // 矩阵列数
        private List<Triple> data; // 三元组数据

        public SparseMatrix(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
            this.data = new ArrayList<>();
        }

        public static SparseMatrix fromArray(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                throw new IllegalArgumentException("矩阵不能为空");
            }

            int rows = matrix.length;
            int cols = matrix[0].length;
            SparseMatrix sparseMatrix = new SparseMatrix(rows, cols);

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j] != 0) {
                        sparseMatrix.data.add(new Triple(i, j, matrix[i][j]));
                    }
                }
            }

            return sparseMatrix;
        }

        public SparseMatrix add(SparseMatrix other) {
            if (this.rows != other.rows || this.cols != other.cols) {
                throw new IllegalArgumentException("矩阵维度不匹配，无法相加");
            }

            SparseMatrix result = new SparseMatrix(rows, cols);
            int i = 0, j = 0;

            while (i < this.data.size() && j < other.data.size()) {
                Triple t1 = this.data.get(i);
                Triple t2 = other.data.get(j);

                int pos1 = t1.row * cols + t1.col;
                int pos2 = t2.row * cols + t2.col;

                if (pos1 < pos2) {
                    result.data.add(new Triple(t1.row, t1.col, t1.value));
                    i++;
                } else if (pos1 > pos2) {
                    result.data.add(new Triple(t2.row, t2.col, t2.value));
                    j++;
                } else {
                    int sum = t1.value + t2.value;
                    if (sum != 0) {
                        result.data.add(new Triple(t1.row, t1.col, sum));
                    }
                    i++;
                    j++;
                }
            }

            while (i < this.data.size()) {
                Triple t = this.data.get(i++);
                result.data.add(new Triple(t.row, t.col, t.value));
            }

            while (j < other.data.size()) {
                Triple t = other.data.get(j++);
                result.data.add(new Triple(t.row, t.col, t.value));
            }

            return result;
        }

        public boolean equals(SparseMatrix other) {
            if (this.rows != other.rows || this.cols != other.cols ||
                    this.data.size() != other.data.size()) {
                return false;
            }

            for (int i = 0; i < this.data.size(); i++) {
                if (!this.data.get(i).equals(other.data.get(i))) {
                    return false;
                }
            }

            return true;
        }

        public boolean isSymmetric() {
            if (rows != cols) return false;

            Map<String, Integer> map = new HashMap<>();
            for (Triple triple : data) {
                String key = triple.row + "," + triple.col;
                map.put(key, triple.value);
            }

            for (Triple triple : data) {
                String symmetricKey = triple.col + "," + triple.row;
                Integer symmetricValue = map.get(symmetricKey);

                if (symmetricValue == null || symmetricValue != triple.value) {
                    return false;
                }
            }

            return true;
        }

        public SparseMatrix multiply(SparseMatrix other) {
            if (this.cols != other.rows) {
                throw new IllegalArgumentException("矩阵维度不匹配，无法相乘");
            }

            SparseMatrix result = new SparseMatrix(this.rows, other.cols);

            SparseMatrix otherTransposed = other.transpose();

            for (Triple t1 : this.data) {
                for (Triple t2 : otherTransposed.data) {
                    if (t1.col == t2.col) { // 相当于原矩阵的列 == 转置矩阵的行
                        int product = t1.value * t2.value;
                        if (product != 0) {
                            addToElement(result, t1.row, t2.row, product);
                        }
                    }
                }
            }

            return result;
        }

        private void addToElement(SparseMatrix matrix, int row, int col, int value) {
            if (value == 0) return;

            for (int i = 0; i < matrix.data.size(); i++) {
                Triple t = matrix.data.get(i);
                if (t.row == row && t.col == col) {
                    matrix.data.set(i, new Triple(row, col, t.value + value));
                    return;
                }
            }

            matrix.data.add(new Triple(row, col, value));
        }

        public SparseMatrix transpose() {
            SparseMatrix result = new SparseMatrix(cols, rows);

            // 创建转置后的三元组
            for (Triple triple : data) {
                result.data.add(new Triple(triple.col, triple.row, triple.value));
            }

            // 按行列排序
            result.data.sort((t1, t2) -> {
                if (t1.row != t2.row) {
                    return Integer.compare(t1.row, t2.row);
                } else {
                    return Integer.compare(t1.col, t2.col);
                }
            });

            return result;
        }

        public SparseMatrix fastTranspose() {
            SparseMatrix result = new SparseMatrix(cols, rows);

            // 初始化列计数和起始位置数组
            int[] colCount = new int[cols];
            int[] startPos = new int[cols];

            // 统计每列的非零元素个数
            for (Triple triple : data) {
                colCount[triple.col]++;
            }

            // 计算每列在转置矩阵中的起始位置
            startPos[0] = 0;
            for (int i = 1; i < cols; i++) {
                startPos[i] = startPos[i - 1] + colCount[i - 1];
            }

            // 初始化结果数组
            Triple[] resultArray = new Triple[data.size()];

            // 执行转置
            for (Triple triple : data) {
                int pos = startPos[triple.col]++;
                resultArray[pos] = new Triple(triple.col, triple.row, triple.value);
            }

            // 转换为List
            result.data = new ArrayList<>(Arrays.asList(resultArray));

            return result;
        }

        public int[][] toArray() {
            int[][] matrix = new int[rows][cols];
            for (Triple triple : data) {
                matrix[triple.row][triple.col] = triple.value;
            }
            return matrix;
        }

        public void print() {
            int[][] matrix = toArray();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(matrix[i][j] + "\t");
                }
                System.out.println();
            }
        }

        public void printTriples() {
            System.out.println("三元组表 (行, 列, 值):");
            for (Triple triple : data) {
                System.out.println(triple);
            }
        }

        // Getter方法
        public int getRows() { return rows; }
        public int getCols() { return cols; }
        public List<Triple> getData() { return data; }
    }

    public static void main(String[] args) {
        System.out.println("=== 稀疏矩阵的三元组存储和运算测试 ===\n");

        // 测试矩阵A
        int[][] arrayA = {
                {0, 0, 3, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 5},
                {1, 0, 0, 0}
        };

        // 测试矩阵B
        int[][] arrayB = {
                {0, 2, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 4, 0},
                {0, 0, 0, 6}
        };

        // 创建稀疏矩阵
        SparseMatrix matrixA = SparseMatrix.fromArray(arrayA);
        SparseMatrix matrixB = SparseMatrix.fromArray(arrayB);

        System.out.println("矩阵A:");
        matrixA.print();
        matrixA.printTriples();

        System.out.println("\n矩阵B:");
        matrixB.print();
        matrixB.printTriples();

        // 测试矩阵加法
        System.out.println("\n=== 矩阵加法 A + B ===");
        SparseMatrix sum = matrixA.add(matrixB);
        sum.print();
        sum.printTriples();

        // 测试矩阵转置
        System.out.println("\n=== 矩阵A的转置 ===");
        SparseMatrix transposedA = matrixA.transpose();
        transposedA.print();
        transposedA.printTriples();

        // 测试快速转置
        System.out.println("\n=== 矩阵A的快速转置 ===");
        SparseMatrix fastTransposedA = matrixA.fastTranspose();
        fastTransposedA.print();
        fastTransposedA.printTriples();

        // 测试矩阵相等
        System.out.println("\n=== 矩阵相等判断 ===");
        System.out.println("A == A: " + matrixA.equals(matrixA));
        System.out.println("A == B: " + matrixA.equals(matrixB));

        // 测试对称矩阵判断
        System.out.println("\n=== 对称矩阵判断 ===");
        System.out.println("A是否对称: " + matrixA.isSymmetric());

        // 创建对称矩阵测试
        int[][] symmetricArray = {
                {1, 0, 2},
                {0, 0, 0},
                {2, 0, 3}
        };
        SparseMatrix symmetricMatrix = SparseMatrix.fromArray(symmetricArray);
        System.out.println("对称矩阵测试:");
        symmetricMatrix.print();
        System.out.println("是否对称: " + symmetricMatrix.isSymmetric());

        // 测试矩阵乘法
        System.out.println("\n=== 适合相乘的矩阵测试 ===");
        int[][] arrayC = {
                {1, 0, 2},
                {0, 3, 0},
                {4, 0, 5}
        };

        int[][] arrayD = {
                {0, 2},
                {1, 0},
                {3, 0}
        };

        SparseMatrix matrixC = SparseMatrix.fromArray(arrayC);
        SparseMatrix matrixD = SparseMatrix.fromArray(arrayD);

        System.out.println("矩阵C:");
        matrixC.print();
        System.out.println("矩阵D:");
        matrixD.print();

        SparseMatrix productCD = matrixC.multiply(matrixD);
        System.out.println("C × D:");
        productCD.print();
        productCD.printTriples();

        System.out.println("\n=== 测试完成 ===");
    }
}