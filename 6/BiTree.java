import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class BiTree<T> {
    private BiTreeNode<T> root;

    public BiTree() {
        root = null;
    }

    public BiTree(BiTreeNode<T> root) {
        this.root = root;
    }

    public BiTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(BiTreeNode<T> root) {
        this.root = root;
    }

    public void buildFromPreOrder(List<T> preOrder) {
        int[] index = {0};
        root = buildFromPreOrderHelper(preOrder, index);
    }

    private BiTreeNode<T> buildFromPreOrderHelper(List<T> preOrder, int[] index) {
        if (index[0] >= preOrder.size() || preOrder.get(index[0]) == null) {
            index[0]++;
            return null;
        }
        BiTreeNode<T> node = new BiTreeNode<>(preOrder.get(index[0]));
        index[0]++;
        node.left = buildFromPreOrderHelper(preOrder, index);
        node.right = buildFromPreOrderHelper(preOrder, index);
        return node;
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
        System.out.println();
    }

    private void preOrderTraversal(BiTreeNode<T> node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(BiTreeNode<T> node) {
        if (node == null) return;
        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
        System.out.println();
    }

    private void postOrderTraversal(BiTreeNode<T> node) {
        if (node == null) return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    public void levelOrderTraversal() {
        if (root == null) return;
        Queue<BiTreeNode<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BiTreeNode<T> node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        System.out.println();
    }

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(BiTreeNode<T> node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(BiTreeNode<T> node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }

    public int depth() {
        return depth(root);
    }

    private int depth(BiTreeNode<T> node) {
        if (node == null) return 0;
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public BiTreeNode<T> find(T data) {
        return find(root, data);
    }

    private BiTreeNode<T> find(BiTreeNode<T> node, T data) {
        if (node == null) return null;
        if (node.data.equals(data)) return node;
        BiTreeNode<T> leftResult = find(node.left, data);
        if (leftResult != null) return leftResult;
        return find(node.right, data);
    }

    public boolean equals(BiTree<T> other) {
        return equals(root, other.root);
    }

    private boolean equals(BiTreeNode<T> node1, BiTreeNode<T> node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        return node1.data.equals(node2.data) &&
               equals(node1.left, node2.left) &&
               equals(node1.right, node2.right);
    }
}