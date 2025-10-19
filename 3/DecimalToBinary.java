public class DecimalToBinary {
    public static SqStackClass<Integer> decimalToBinary(int decimal) throws Exception {
        SqStackClass<Integer> stack = new SqStackClass<>();

        if (decimal == 0) {
            stack.push(0);
            return stack;
        }

        while (decimal > 0) {
            int remainder = decimal % 2;
            stack.push(remainder);
            decimal = decimal / 2;
        }

        return stack;
    }

    public static void printBinary(SqStackClass<Integer> stack) {
        System.out.print("二进制数: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }
}

// 测试类
class DecimalToBinaryTest {
    public static void main(String[] args) {
        try {
            System.out.println("十进制转二进制测试:");

            int[] testCases = {10, 15, 255, 0, 1};

            for (int num : testCases) {
                System.out.println("十进制: " + num);
                SqStackClass<Integer> binaryStack = DecimalToBinary.decimalToBinary(num);
                DecimalToBinary.printBinary(binaryStack);
                System.out.println("----------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}