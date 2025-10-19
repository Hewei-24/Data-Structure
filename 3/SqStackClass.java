public class SqStackClass<E> {
    final int initcapacity=10;
    private int capacity;
    private E[] data;
    private int top;

    public SqStackClass(){
        capacity = initcapacity;
        data = (E[]) new Object[capacity];
        top=1;
    }

    public void clear(){
        top=-1;
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public int length(){
        return top+1;
    }

    public E peek(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }
        return data[top];
    }

    public E pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }
        E value = data[top];
        top --;
        return value;
    }

    public void push(E x) {
        if(top==capacity-1){
            resize();
        }
        top++;
        data[top]=x;
    }

    private void resize(){
        int newCapacity = capacity*2;
        E[] newData = (E[]) new Object[newCapacity];
        System.arraycopy(data,0,newData,0,capacity);
        data = newData;
        capacity = newCapacity;
        System.out.println("栈容量已扩容至"+capacity);
    }

    public void display(){
        System.out.println("栈元素：");
        for(int i=0;i<=top;i++){
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }
}
