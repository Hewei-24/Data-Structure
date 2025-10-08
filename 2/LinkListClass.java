public class LinkListClass<E> {
    private LinkNode<E> head;
    private int size;

    private static class LinkNode<E>{
        E data;
        LinkNode<E> next;

        LinkNode(E data){
            this.data=data;
            this.next=null;
        }
    }

    public LinkListClass(){
        head=new LinkNode<>(null);
        size=0;
    }

    public void clear()
    {
        head.next=null;
        size=0;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    public LinkNode<E> geti(int i){
        if(i<0||i>=size){
            throw new IndexOutOfBoundsException("索引越界："+i);
        }
        LinkNode<E> p = head.next;
        for(int j=0;j<i;j++){
            p=p.next;
        }
        return p;
    }

    public E GetElem(int i){
        LinkNode<E> p=geti(i);
        return p.data;
    }

    public void insert(int i,E x){
        if(i<0||i>size){
            throw new IndexOutOfBoundsException("插入位置无效："+i);
        }
        LinkNode<E> newNode=new LinkNode<>(x);
        LinkNode<E> p = head;
        for(int j=0;j<i;j++){
            p=p.next;
        }
        newNode.next =p.next;
        p.next=newNode;
        size++;
        System.out.print("插入后的链表：");
        display();
    }

    public void delete(int i){
        if(i<0||i>=size){
            throw new IndexOutOfBoundsException("删除位置无效："+i);
        }
        LinkNode<E> p=head;
        for(int j=0;j<i;j++){
            p=p.next;
        }
        p.next=p.next.next;
        size--;
        System.out.print("删除后的链表：");
        display();
    }

    public int GetNo(E e){
        LinkNode<E>p=head.next;
        int index =0;
        while(p!=null){
            if(p.data.equals(e)){
                return index;
            }
            p=p.next;
            index++;
        }
        return -1;
    }

    public void display(){
        LinkNode<E> p=head.next;
        while(p!=null){
            System.out.print(p.data+" ");
            p=p.next;
        }
        System.out.println();
    }

    //设计性实验2：删除单链表里的重复元素
    public void removeDuplicates(){
        LinkNode<E> current = head.next;
        while(current!=null && current.next!=null){
            LinkNode<E> runner = current;
            while(runner.next!=null){
                if(runner.next.data.equals(current.data)){
                    runner.next=runner.next.next;
                    size--;
                }else{
                    runner=runner.next;
                }
            }
            current=current.next;
        }
        System.out.print("删除重复元素后的链表：");
        display();
    }

    //设计性实验3：合并两个有序链表
    public static <T extends Comparable<T>> LinkListClass<T> mergeSortedLists(LinkListClass<T> la, LinkListClass<T> lb) {
        LinkListClass<T> mergedList = new LinkListClass<>();
        LinkNode<T> pa = la.head.next;
        LinkNode<T> pb = lb.head.next;
        LinkNode<T> tail = mergedList.head;

        while (pa != null && pb != null) {
            LinkNode<T> newNode;
            if (pa.data.compareTo(pb.data) <= 0) {
                newNode = new LinkNode<>(pa.data);
                pa = pa.next;
            } else {
                newNode = new LinkNode<>(pb.data);
                pb = pb.next;
            }
            tail.next = newNode;
            tail = newNode;
            mergedList.size++;
        }

        // 处理剩余节点
        LinkNode<T> remaining = (pa != null) ? pa : pb;
        while (remaining != null) {
            LinkNode<T> newNode = new LinkNode<>(remaining.data);
            tail.next = newNode;
            tail = newNode;
            remaining = remaining.next;
            mergedList.size++;
        }

        return mergedList;
    }

}
