public class PostfixEvaluator {
    public static int evaluatePostfix(String expression) {
        SqStackClass<Integer> stack = new SqStackClass<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = applyOperator(ch, operand1, operand2);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    private static int applyOperator(char operator, int operand1, int operand2) {
        switch (operator) {
            case '+': return operand1 + operand2;
            case '-': return operand1 - operand2;
            case '*': return operand1 * operand2;
            case '/':
                if (operand2 == 0) throw new ArithmeticException("除零错误");
                return operand1 / operand2;
            default: throw new IllegalArgumentException("无效运算符: " + operator);
        }
    }
}

// 测试类
class PostfixTest {
    public static void main(String[] args) {
        try {
            System.out.println("=== 后缀表达式求值测试 ===");

            String[] expressions = {"34+5*", "52*3+", "93/2+"};

            for (String expr : expressions) {
                int result = PostfixEvaluator.evaluatePostfix(expr);
                System.out.println("后缀式: " + expr + " = " + result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}