public class LinkedStackTest {
    public static void main(String[] args){
        LinkedStackClass<String> stack = new LinkedStackClass<>();

        System.out.println("链式栈测试：");
        System.out.println("初始是否为空："+stack.isEmpty());

        //入栈测试
        stack.push("A");
        stack.push("B");
        stack.push("C");

        stack.display();
        System.out.println("栈长度："+stack.length());
        System.out.println("栈顶元素："+stack.peek());

        //出战测试
        System.out.println("出栈："+stack.pop());
        stack.display();


    }
}
