package DataStructures.BinaryTree;

/**
 * элемент бинароного дерева
 */
public class Node {
    int value;
    Node left;
    Node right;

    public Node() {
        this.value = 0;
        this.left = null;
        this.right = null;
    }

    public Node(int _value) {
        this.value = _value;
        this.left = null;
        this.right = null;
    }

    public Node(int _value, Node _left, Node _right) {
        this.value = _value;
        this.left = _left;
        this.right = _right;
    }
}
