class PolyNode {
    public double coef;
    public int exp;
    public PolyNode next;

    public PolyNode(double coef, int exp) {
        this.coef = coef;
        this.exp = exp;
        this.next = null;
    }

    public String toString() {
        return String.format("系数：%.1f,指数：%d", coef, exp);
    }
}

public class PolynList {
    private PolyNode head;
    private int size;

    public PolynList() {
        head = new PolyNode(0, -1);
        size = 0;
    }

    // 插入，按指数降序插入
    public void insert(double coef, int exp) {
        if (coef == 0) return;
        PolyNode newNode = new PolyNode(coef, exp);
        PolyNode prev = head;
        PolyNode curr = head.next;

        // 查找插入位置
        while (curr != null && curr.exp > exp) {
            prev = curr;
            curr = curr.next;
        }

        // 指数相同，合并同类项
        if (curr != null && curr.exp == exp) {
            curr.coef += coef;
            if (curr.coef == 0) {
                // 如果合并后系数为0，删除该节点
                prev.next = curr.next;
                size--;
            }
        } else {
            // 插入新节点
            newNode.next = curr;
            prev.next = newNode;
            size++;
        }
    }

    // 多项式加法
    public static PolynList add(PolynList polyA, PolynList polyB) {
        PolynList result = new PolynList();

        // 将多项式A的所有项插入结果
        PolyNode p = polyA.head.next;
        while (p != null) {
            result.insert(p.coef, p.exp);
            p = p.next;
        }

        // 将多项式B的所有项插入结果
        p = polyB.head.next;  // 修正：重新初始化p指针
        while (p != null) {
            result.insert(p.coef, p.exp);
            p = p.next;
        }

        return result;
    }

    // 显示多项式（修正方法名和输出格式）
    public void display() {  // 修正：方法名从 diaplay 改为 display
        if (size == 0) {
            System.out.println("0");
            return;
        }

        PolyNode p = head.next;
        boolean first = true;

        while (p != null) {
            if (!first && p.coef > 0) {
                System.out.print(" + ");  // 修正：改为 print 而不是 println
            }

            // 输出系数
            if (p.exp == 0) {
                System.out.print(p.coef);  // 修正：改为 print
            } else if (p.coef == 1) {
                System.out.print("x^" + p.exp);
            } else if (p.coef == -1) {
                System.out.print("-x^" + p.exp);
            } else {
                System.out.print(p.coef + "x^" + p.exp);
            }

            first = false;
            p = p.next;
        }
        System.out.println();
    }

    public void displayTerms() {
        PolyNode p = head.next;
        while (p != null) {
            System.out.printf("系数为：%.1f 指数为：%d\n", p.coef, p.exp);
            p = p.next;
        }
    }

    public int getSize() {
        return size;
    }
}