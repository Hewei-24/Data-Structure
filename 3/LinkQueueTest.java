public class LinkQueueTest {
    public static void main(String[] args){
        LinkQueueClass<Character> queue = new LinkQueueClass<>();

        System.out.println("链式队列测试：");
        System.out.println("初始队列是否为空："+queue.isEmpty());

        //入队测试
        queue.push('X');
        queue.push('Y');
        queue.push('Z');

        queue.display();

        System.out.println("队列大小："+queue.size());
        System.out.println("队头元素："+queue.peek());

        //出队测试
        System.out.println("出队："+queue.pop());
        queue.display();

    }
}
