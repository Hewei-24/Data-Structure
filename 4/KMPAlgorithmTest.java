public class KMPAlgorithmTest {

    public static int kmp(String S, String T) {
        int n = S.length(), m = T.length();
        if (m == 0) return 0;

        int[] next = getNext(T);
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (j == -1 || S.charAt(i) == T.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        return j == m ? i - m : -1;
    }

    private static int[] getNext(String T) {
        int m = T.length();
        int[] next = new int[m];
        next[0] = -1;
        int i = 0, j = -1;

        while (i < m - 1) {
            if (j == -1 || T.charAt(i) == T.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println("========== KMP算法测试 ==========");

        // 测试用例1
        String S1 = "cdbbacc";
        String T1 = "abcd";
        int result1 = kmp(S1, T1);
        System.out.println("主串: \"" + S1 + "\", 模式串: \"" + T1 + "\"");
        System.out.println("匹配位置: " + result1);
        System.out.println();

        // 测试用例2
        String S2 = "ababcabcacbab";
        String T2 = "abcac";
        int result2 = kmp(S2, T2);
        System.out.println("主串: \"" + S2 + "\", 模式串: \"" + T2 + "\"");
        System.out.println("匹配位置: " + result2);
    }
}