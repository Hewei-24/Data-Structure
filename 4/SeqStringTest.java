public class SeqStringTest {
    public static void main(String[] args) {
        System.out.println("========== 顺序串类测试 ==========\n");

        // 1. 测试构造函数和基本方法
        System.out.println("1. 基本功能测试:");
        SeqString str1 = new SeqString("Hello");
        System.out.println("创建串: " + str1);
        System.out.println("长度: " + str1.length());
        System.out.println("第2个字符: '" + str1.charAt(1) + "'");
        System.out.println("是否为空: " + str1.isEmpty());
        System.out.println("字符 'e' 的位置: " + str1.indexOf('e'));
        System.out.println("字符 'x' 的位置: " + str1.indexOf('x'));

        // 2. 测试子串操作
        System.out.println("\n2. 子串操作测试:");
        SeqString str2 = new SeqString("Hello World");
        System.out.println("原串: " + str2);
        SeqString sub1 = str2.substring(0, 5);
        System.out.println("子串(0,5): " + sub1);
        SeqString sub2 = str2.substring(6, 11);
        System.out.println("子串(6,11): " + sub2);

        // 3. 测试连接操作
        System.out.println("\n3. 连接操作测试:");
        SeqString str3 = new SeqString("Hello");
        SeqString str4 = new SeqString(" World");
        SeqString concated = str3.concat(str4);
        System.out.println("串1: " + str3);
        System.out.println("串2: " + str4);
        System.out.println("连接后: " + concated);

        // 4. 测试相等比较
        System.out.println("\n4. 相等比较测试:");
        SeqString str5 = new SeqString("Hello");
        SeqString str6 = new SeqString("Hello");
        SeqString str7 = new SeqString("World");
        System.out.println(str3 + " == " + str5 + " : " + str3.equals(str5));
        System.out.println(str3 + " == " + str6 + " : " + str3.equals(str6));
        System.out.println(str3 + " == " + str7 + " : " + str3.equals(str7));

        // 5. 测试空串和边界情况
        System.out.println("\n5. 边界情况测试:");
        SeqString emptyStr = new SeqString("");
        System.out.println("空串: '" + emptyStr + "'");
        System.out.println("空串长度: " + emptyStr.length());
        System.out.println("空串是否为空: " + emptyStr.isEmpty());

        //6. 综合测试
        System.out.println("\n6. 综合测试:");
        SeqString base = new SeqString("Data Structure");
        System.out.println("基础串: " + base);
        System.out.println("前4个字符: " + base.substring(0, 4));
        System.out.println("后9个字符: " + base.substring(5, 14));
        System.out.println("包含空格: " + (base.indexOf(' ') != -1));

        System.out.println("\n========== 测试完成 ==========");
    }
}