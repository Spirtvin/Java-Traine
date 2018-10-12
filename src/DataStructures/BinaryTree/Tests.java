package DataStructures.BinaryTree;

import java.util.ArrayList;
import java.util.Random;

public class Tests {
    public void Start() {
        Random r = new Random();
        ArrayList<Integer> values = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++)
            values.add(i);
            //values.add(r.nextInt() % 100);
        BinaryTree tree = new BinaryTree(values);
        tree.BinaryAdd(values);
        String str = "";
        str = tree.ToVisualStr(tree.root);
        System.out.println(str);
    }

}
