public class SqStackTest {
    public static void main(String[] args){
        try{
            SqStackClass<Integer> stack = new SqStackClass<>();
            System.out.println("顺序栈测试：");
            System.out.println("初始是否为空:"+stack.isEmpty());

            //入栈测试
            for(int i=1;i<=12;i++){
                stack.push(i);
                System.out.println("入栈："+i);
            }
            stack.display();
            System.out.println("栈长度："+stack.length());
            System.out.println("栈顶元素："+stack.peek());

            //出栈测试
            System.out.println("出栈："+stack.pop());
            System.out.println("出栈："+stack.pop());

            stack.display();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
