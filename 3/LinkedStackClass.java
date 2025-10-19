class LinkNode<E> {
    E data;
    LinkNode<E> next;

    public LinkNode(){
        this.next=null;
    }

    public LinkNode(E data){
        this.data=data;
        this.next=null;
    }
}

public class LinkedStackClass<E>{
    private LinkNode<E> head;

    public LinkedStackClass(){
        head = new LinkNode<>();
    }

    public void clear(){
        head.next=null;
    }

    public boolean isEmpty(){
        return head.next==null;
    }

    public int length(){
        int len=0;
        LinkNode<E> p=head.next;
        while(p!=null){
            len++;
            p=p.next;
        }
        return len;
    }

    public E peek(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }
        return head.next.data;
    }

    public E pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }
        LinkNode<E> p = head.next;
        head.next=p.next;
        return p.data;
    }

    public void push(E x){
        LinkNode<E> newNode = new LinkNode<>(x);
        newNode.next=head.next;
        head.next=newNode;
    }

    public void display(){
        System.out.print("栈元素：");
        LinkNode<E> p = head.next;
        while(p!=null){
            System.out.print(p.data+" ");
            p=p.next;
        }
    }

}
