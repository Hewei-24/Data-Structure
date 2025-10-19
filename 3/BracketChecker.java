public class BracketChecker {
    public static String checkBrackets(String expression) {
        LinkedStackClass<Character> stack = new LinkedStackClass<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // 左括号入栈
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            // 右括号检查
            else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return "右括号多于左括号";
                }

                char top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return "左右括号配对次序不正确";
                }
            }
        }

        if (!stack.isEmpty()) {
            return "左括号多于右括号";
        }

        return "左右括号匹配正确";
    }

    private static boolean isMatchingPair(char left, char right) {
        return (left == '(' && right == ')') ||
                (left == '[' && right == ']') ||
                (left == '{' && right == '}');
    }
}

// 测试类
class BracketTest {
    public static void main(String[] args) {
        System.out.println("=== 括号匹配检查测试 ===");

        String[] testCases = {
                "(())abc{[)(]}",
                "(()))abc{[]}",
                "(()()abc{[]}",
                "(())abc{[]}"
        };

        for (String expr : testCases) {
            String result = BracketChecker.checkBrackets(expr);
            System.out.println("表达式: \"" + expr + "\" -> " + result);
        }
    }
}