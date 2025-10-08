import java.util.Arrays;

public class SqListClass<E> {
    private static final int INIT_CAPACITY = 10;
    private E[] data;
    private int length;

    public SqListClass() {
        data = (E[]) new Object[INIT_CAPACITY];
        length = 0;
    }

    public void clear() {
        length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void CreateList(int n, E[] a) {
        if (n > data.length) {
            ensureCapacity(n);
        }
        for (int i = 0; i < n; i++) {
            data[i] = a[i];
        }
        length = n;
        System.out.print("创建的顺序表：");
        display();
    }

    public int size() {
        return length;
    }

    public E GetElem(int i) {
        if (i < 0 || i >= length) {
            throw new IndexOutOfBoundsException("索引越界：" + i);
        }
        return data[i];
    }

    public void insert(int i, E x) {
        if (i < 0 || i > length) {
            throw new IndexOutOfBoundsException("插入位置无效：" + i);
        }
        if (length == data.length) {
            ensureCapacity(length * 2);
        }
        for (int j = length; j > i; j--) {
            data[j] = data[j - 1];
        }
        data[i] = x;
        length++;
        System.out.print("插入后的顺序表：");
        display();
    }

    public void delete(int i) {
        if (i < 0 || i >= length) {
            throw new IndexOutOfBoundsException("删除位置无效：" + i);
        }
        for (int j = i; j < length - 1; j++) {
            data[j] = data[j + 1];
        }
        length--;
        System.out.print("删除后的顺序表：");
        display();
    }

    public int GetNo(E x) {
        for (int i = 0; i < length; i++) {
            if (data[i].equals(x)) {
                return i;
            }
        }
        return -1;
    }

    public void reverse() {
        int i = length-1;
        int j = 0;
        while (j < i) {
            E t = data[i];
            data[i] = data[j];
            data[j] = t;
            i--;
            j++;
        }
        System.out.print("逆置后的顺序表：");
        display();
    }

    public void ensureCapacity(int minCapacity) {
        if(minCapacity>data.length){
            E[] newData =(E[])new Object[Math.max(data.length*2,minCapacity)];
            System.arraycopy(data,0,newData,0,length);
            data = newData;
        }
    }

    public void display() {
        for (int i = 0; i < length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    // 设计性实验1：删除有序顺序表中的重复元素
    public void removeDuplicates() {
        if (length == 0) return;
        int i = 0;
        for (int j = 1; j < length; j++) {
            if (!data[i].equals(data[j])) {
                i++;
                data[i] = data[j];
            }
        }
        length = i + 1;
        System.out.print("删除重复元素后的顺序表：");
        display();
    }

    public void sort() {
        Arrays.sort(data, 0, length);
        System.out.print("排序后的顺序表：");
        display();
    }
}