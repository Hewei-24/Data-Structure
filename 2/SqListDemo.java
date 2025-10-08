import java.util.Scanner;

public class SqListDemo {
    //main方法
    public static void main(String[] args){
        SqListClass<Integer> list = new SqListClass<>();

        Integer[] arr={10,20,30,40,50};
        list.CreateList(5,arr);
        list.insert(2,25);
        list.delete(3);
        int index = list.GetNo(25);
        System.out.println("元素25的位置："+index);
        list.reverse();

        //设计性实验

        SqListClass<Integer> lists = new SqListClass<>();

                // 输入 n 个整数
                Scanner scanner = new Scanner(System.in);
                System.out.print("请输入整数个数 n：");
                int n = scanner.nextInt();
                Integer[] arrs = new Integer[n];
                System.out.println("请输入 " + n + " 个整数：");
                for (int i = 0; i < n; i++) {
                    arrs[i] = scanner.nextInt();
                }

                // 创建顺序表并排序
                lists.CreateList(n, arrs);
                lists.sort();

                // 删除重复元素
                lists.removeDuplicates();
            }
        }
