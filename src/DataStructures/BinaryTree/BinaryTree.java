package DataStructures.BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Бинарное дерево.
 */
public class BinaryTree {
    /**
     * Корчень дерева.
     */
    Node root = null;

    /**
     * количество уровней дерева
     */
    int levels = 0;

    /**
     * Конвертирует его в ArrayList.
     *
     * @param values наш массив.
     */
    public void BinaryAdd(Integer[] values) {
        BinaryAdd(new ArrayList<Integer>(Arrays.asList(values)));
    }

    /**
     * Устанавливает флаги на начало и конец узла.
     *
     * @param items
     */
    public void BinaryAdd(ArrayList<Integer> items) {
        BinaryAdd(items, 0, items.size() - 1);
    }

    /**
     * Рекурсивно добавляет создаёт дерево и з отсортированных элементов.
     *
     * @param items
     * @param start начало узла
     * @param end   конец зла
     */
    public void BinaryAdd(ArrayList<Integer> items, int start, int end) {
        if (start <= end) {
            int mid = (end - start) / 2 + start;
            Add(items.get(mid));
            BinaryAdd(items, start, mid - 1);
            BinaryAdd(items, mid + 1, end);
        }
    }

    /**
     * Сортирует дерево
     *
     * @param values
     */
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

    /**
     * Добавляет элимент в дерево.
     *
     * @param value - добавляемый элемент.
     */
    public void Add(int value) {
        //если дерево пустое
        if (root == null)
            root = new Node(value, null, null);
        else {
            Node current = root;
            int curLevel = root.level;
            while (current != null) {
                curLevel++;
                if (current.value < value) {
                    if (current.right != null)
                        current = current.right;
                    else {
                        current.right = new Node(value, curLevel);
                        levels = Math.max(levels, curLevel);
                        break;
                    }
                } else {
                    if (current.left != null)
                        current = current.left;
                    else {
                        current.left = new Node(value, curLevel);
                        levels = Math.max(levels, curLevel);
                        break;
                    }
                }
            }
        }
    }

    /**
     * Записывает дерево в строку.
     *
     * @param node - текущий узел.
     * @param str  - строка.
     * @return
     */
    public String ToStr(Node node, String str) {
        if (node != null) {
            str += Integer.toString(node.value) + " ";
            //начало рекурсии
            str = ToStr(node.left, str);
            str = ToStr(node.right, str);
        }
        return str;
    }

    public String ToStr(Node node, int level) {
        String str = "";
        if (node != null) {
            if (node.level == level)
                str += Integer.toString(node.value) + " ";
            //начало рекурсии
            str += ToStr(node.left, level);
            str += ToStr(node.right, level);

        }
        return str;
    }

    public String ToVisualStr(Node node) {
        String str = "";
        if(node!=null) {
            str += node.ToStr();
            str += ToVisualStr(node.left);
            str += ToVisualStr(node.right);
        }
        return str;
    }

}
