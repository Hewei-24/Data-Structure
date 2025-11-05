public class PatternMatchCompare {
    public static class BFResult {
        int index;
        int count;
        BFResult(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    public static BFResult bruteForceWithCount(String S, String T) {
        int n = S.length(), m = T.length();
        int count = 0;
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                count++;
                if (S.charAt(i + j) != T.charAt(j)) break;
            }
            if (j == m) return new BFResult(i, count);
        }
        return new BFResult(-1, count);
    }

    public static class KMPResult {
        int index;
        int count;
        KMPResult(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    public static KMPResult kmpWithCount(String S, String T) {
        int n = S.length(), m = T.length();
        int[] next = getNext(T);
        int i = 0, j = 0, count = 0;
        while (i < n && j < m) {
            count++;
            if (j == -1 || S.charAt(i) == T.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        return new KMPResult(j == m ? i - m : -1, count);
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
        String S1 = "cdbbacc", T1 = "abcd";
        String S2 = "aaaaaaaaaa", T2 = "aaaab";

        BFResult bf1 = bruteForceWithCount(S1, T1);
        KMPResult kmp1 = kmpWithCount(S1, T1);
        BFResult bf2 = bruteForceWithCount(S2, T2);
        KMPResult kmp2 = kmpWithCount(S2, T2);

        System.out.println("S=\"cdbbacc\", T=\"abcd\"");
        System.out.println("BF: 位置=" + bf1.index + ", 比较次数=" + bf1.count);
        System.out.println("KMP: 位置=" + kmp1.index + ", 比较次数=" + kmp1.count);

        System.out.println("S=\"aaaaaaaaaa\", T=\"aaaab\"");
        System.out.println("BF: 位置=" + bf2.index + ", 比较次数=" + bf2.count);
        System.out.println("KMP: 位置=" + kmp2.index + ", 比较次数=" + kmp2.count);
    }
}