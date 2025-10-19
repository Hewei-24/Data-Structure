public class LinkQueueClass<E> {
    private LinkNode<E> front;
    private LinkNode<E> rear;

    public LinkQueueClass(){
        front=rear=new LinkNode<>();
    }

    public void clear(){
        front.next=null;
        rear=front;
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public int size(){
        int len=0;
        LinkNode<E> p = front.next;
        while(p != null){
            len++;
            p=p.next;
        }
        return len;
    }

    public E peek(){
        if(isEmpty()){
            return null;
        }
        return front.next.data;
    }

    public E pop(){
        if(isEmpty()){
            return null;
        }
        LinkNode<E> p=front.next;
        front.next=p.next;
        if(rear==p){
            rear=front;
        }
        return p.data;
    }

    public void push(E x){
        LinkNode<E> newNode = new LinkNode<>(x);
        rear.next = newNode;
        rear = newNode;
    }

    public void display(){
        System.out.println("队列元素:");
        LinkNode<E> p = front.next;
        while(p!=null){
            System.out.print(p.data+" ");
            p=p.next;
        }
        System.out.println();
    }

}
