package DataStructures.BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * бинарное дерево
 */
public class BinaryTree {
    //TODO: 4) вывод дерева.
    //TODO: почитать про обходы деревьев
    Node root = null;

    /**
     * @param values наш массив.
     *               Конвертирует его в ArrayList.
     */
    public void BinaryAdd(Integer[] values) {
        BinaryAdd(new ArrayList<Integer>(Arrays.asList(values)));
    }

    public void BinaryAdd(ArrayList<Integer> items) {
        BinaryAdd(items, 0, items.size() - 1);
    }

    public void BinaryAdd(ArrayList<Integer> items, int start, int end) {
        if (start <= end) {
            int mid = (end - start) / 2 + start;
            Add(items.get(mid));
            BinaryAdd(items, start, mid - 1);
            BinaryAdd(items, mid + 1, end);
        }
    }

    public BinaryTree(ArrayList<Integer> values) {
        for (int i = 0; i < values.size(); i++)
            for (int j = 0; j < values.size(); j++) {
                if (values.get(i) > values.get(j)) {
                    int tmp = values.get(i);
                    values.set(i, values.get(j));
                    values.set(j, tmp);
                }
            }
    }

    public void Add(int value) {
        //если дерево пустое
        if (root == null)
            root = new Node(value, null, null);
        else {
            Node current = root;
            while (current != null) {
                if (current.value < value) {
                    if (current.right != null)
                        current = current.right;
                    else {
                        current.right = new Node(value);
                        break;
                    }
                } else {
                    if (current.left != null)
                        current = current.left;
                    else {
                        current.left = new Node(value);
                        break;
                    }

                }
            }
        }
    }

}
