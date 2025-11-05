public class BFAlgorithmTest {

    public static int bruteForce(String S, String T) {
        int n = S.length(), m = T.length();
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (S.charAt(i + j) != T.charAt(j)) {
                    break;
                }
            }
            if (j == m) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("========== BF算法测试 ==========");

        // 测试用例1
        String S1 = "cdbbacc";
        String T1 = "abcd";
        int result1 = bruteForce(S1, T1);
        System.out.println("主串: \"" + S1 + "\", 模式串: \"" + T1 + "\"");
        System.out.println("匹配位置: " + result1);
        System.out.println();

        // 测试用例2
        String S2 = "hello world";
        String T2 = "world";
        int result2 = bruteForce(S2, T2);
        System.out.println("主串: \"" + S2 + "\", 模式串: \"" + T2 + "\"");
        System.out.println("匹配位置: " + result2);
    }
}