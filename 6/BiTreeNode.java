public class BiTreeNode<T> {
    T data;
    BiTreeNode<T> left;
    BiTreeNode<T> right;

    public BiTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}