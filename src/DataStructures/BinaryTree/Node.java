package DataStructures.BinaryTree;


/**
 * элемент дерева
 */
public class Node {
    /**
     * значение
     */
    int value;
    int level;
    Node left;
    Node right;

    public Node() {
        Init(0, null, null, 0);
    }

    public Node(int _value) {
        Init(_value, null, null, 0);
    }
    public Node(int _value,int _level) {
        Init(_value, null, null, _level);
    }

    public Node(int _value, Node _left, Node _right) {
        Init(_value, _left, _right, 0);
    }

    public Node(int _value, Node _left, Node _right, int _level) {
        Init(_value, _left, _right, _level);
    }

    private void Init(int _value, Node _left, Node _right, int _level) {
        this.value = _value;
        this.level = _level;
        this.left = _left;
        this.right = _right;
    }

    public  String ToStr(){
        String str="";
        str+=String.format("  %d\n",value);
        str+=" / \\ \n" ;
        String left,right;
        if(this.left==null)
            left="_";
        else
            left = Integer.toString(this.left.value);
        if(this.right==null)
            right="_";
        else
            right = Integer.toString(this.right.value);
        str+=String.format("%s   %s\n",left,right);
        return str;
    }
}
