import java.util.Scanner;

public class PolynListTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入多项式A
        System.out.println("请输入A多项式的项数：");
        int nA = scanner.nextInt();
        PolynList polyA = new PolynList();

        System.out.println("请分别输入多项式A各项的系数和指数：");
        for (int i = 0; i < nA; i++) {
            double coef = scanner.nextDouble();
            int exp = scanner.nextInt();
            polyA.insert(coef, exp);
        }

        // 输入多项式B
        System.out.println("请输入B多项式的项数：");
        int nB = scanner.nextInt();
        PolynList polyB = new PolynList();

        System.out.println("请分别输入多项式B各项的系数和指数：");
        for (int i = 0; i < nB; i++) {
            double coef = scanner.nextDouble();
            int exp = scanner.nextInt();
            polyB.insert(coef, exp);
        }

        // 计算和
        PolynList sum = PolynList.add(polyA, polyB);

        // 输出结果
        System.out.println("求和后的多项式各项为：");
        sum.displayTerms();

        System.out.print("多项式A: ");
        polyA.display();
        System.out.print("多项式B: ");
        polyB.display();
        System.out.print("和多项式: ");
        sum.display();

        scanner.close();
    }
}