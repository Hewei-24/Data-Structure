public class SqQueueClass<E> {
    final int MaxSize = 100;
    private E[] data;
    private int front,rear;

    public SqQueueClass(){
        data=(E[]) new Object[MaxSize];
        front = 0;
        rear = 0;
    }

    public void clear(){
        front = rear=0;
    }

    public boolean isEmpty(){
        return front==rear;
    }

    public int size(){
        return (rear-front+MaxSize)%MaxSize;
    }

    public E peek(){
        if(isEmpty()){
            return null;
        }
        return data[front];
    }

    public E pop(){
        if(isEmpty()){
            return null;
        }
        E value =data[front];
        front=(front+1)%MaxSize;
        return value;
    }

    public void push(E x){
        if((rear+1)%MaxSize==front){
            throw new RuntimeException("队列已满");
        }
        data[rear] = x;
        rear=(rear+1)%MaxSize;
    }

    public void display(){
        System.out.println("队列元素：");
        int i = front;
        while(i!=rear){
            System.out.print(data[i]+" ");
            i=(i+1)%MaxSize;
        }
        System.out.println();
    }

}
