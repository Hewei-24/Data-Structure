public class LinkListDemo {
    //main
    public static void main(String[] args){
        LinkListClass<String> list = new LinkListClass<>();

        list.insert(0, "Apple");
        list.insert(1, "Banana");
        list.insert(2, "Orange");
        list.insert(1, "Grape");

        list.delete(2);

        int pos = list.GetNo("Apple");
        System.out.println("Apple的位置: " + pos);

        //设计性实验2
        LinkListClass<String> stringList = new LinkListClass<>();
        String[] words = {"ShangHai", "university", "ShangHai", "university", "of", "of", "electric", "electric", "power", "of"};
        for(int i=0;i<words.length;i++){
            stringList.insert(i,words[i]);
        }
        stringList.removeDuplicates();

        //设计性实验3
        LinkListClass<Integer> la = new LinkListClass<>();
        LinkListClass<Integer> lb = new LinkListClass<>();

        Integer[] a = {1, 3, 5, 7};
        Integer[] b = {2, 4, 6, 8};

        for (int i = 0; i < a.length; i++) la.insert(i, a[i]);
        for (int i = 0; i < b.length; i++) lb.insert(i, b[i]);

        LinkListClass<Integer> merged = LinkListClass.mergeSortedLists(la, lb);
        System.out.print("合并后的有序链表：");
        merged.display();
    }

}
