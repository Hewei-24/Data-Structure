public class PalindromeChecker {
    public static boolean isPalindrome(String str) {
        LinkedStackClass<Character> stack = new LinkedStackClass<>();

        // 所有字符入栈
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        // 出栈与原字符串比较
        for (int i = 0; i < str.length(); i++) {
            if (stack.pop() != str.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}

// 测试类
class PalindromeTest {
    public static void main(String[] args) {
        System.out.println("回文序列判断测试");

        String[] testCases = {"abba", "abdba", "hello", "racecar", "world"};

        for (String str : testCases) {
            boolean result = PalindromeChecker.isPalindrome(str);
            System.out.println("序列: \"" + str + "\" 是回文? " + result);
        }
    }
}