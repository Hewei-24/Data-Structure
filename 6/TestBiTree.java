import java.util.ArrayList;
import java.util.List;

public class TestBiTree {
    public static void main(String[] args) {
        List<Character> preOrder = new ArrayList<>();
        preOrder.add('A');
        preOrder.add('B');
        preOrder.add('D');
        preOrder.add(null);
        preOrder.add(null);
        preOrder.add('E');
        preOrder.add(null);
        preOrder.add(null);
        preOrder.add('C');
        preOrder.add('F');
        preOrder.add(null);
        preOrder.add(null);
        preOrder.add('G');
        preOrder.add(null);
        preOrder.add(null);

        BiTree<Character> tree = new BiTree<>();
        tree.buildFromPreOrder(preOrder);

        System.out.println("Pre-order traversal:");
        tree.preOrderTraversal();

        System.out.println("In-order traversal:");
        tree.inOrderTraversal();

        System.out.println("Post-order traversal:");
        tree.postOrderTraversal();

        System.out.println("Level-order traversal:");
        tree.levelOrderTraversal();

        System.out.println("Number of nodes: " + tree.countNodes());
        System.out.println("Number of leaves: " + tree.countLeaves());
        System.out.println("Depth of tree: " + tree.depth());

        BiTreeNode<Character> found = tree.find('E');
        System.out.println("Found node E: " + (found != null));

        BiTree<Character> tree2 = new BiTree<>(tree.getRoot());
        System.out.println("Trees are equal: " + tree.equals(tree2));
    }
}