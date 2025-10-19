public class sqQueueTest {
    public static void main(String[] args){
        SqQueueClass<Integer> queue = new SqQueueClass<>();

        System.out.println("顺序循环队列测试：");
        System.out.println("初始是否为空："+queue.isEmpty());

        //入队测试
        for(int i=0;i<=5;i++){
            queue.push(i);
            System.out.println("入队"+i);
        }

        queue.display();
        System.out.println("队列大小："+queue.size());
        System.out.println("队头元素："+queue.peek());

        //出队测试
        System.out.println("出队"+queue.pop());
        System.out.println("出队"+queue.pop());

        queue.display();

    }
}
