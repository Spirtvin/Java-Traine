package DataStructures;

import java.util.ArrayList;

public class MyQueue {

    ArrayList items = new ArrayList();

    public void Enqueue(int value){
        items.add(value);
    }

    public int Dequeue() throws Exception {
        if (!IsEmpty()) {
            int tmp = (int) items.get(items.size() - 1);
            items.remove(items.size()-1);
            return tmp;
        }
        throw new Exception("Empty Queue\n");
    }

    public boolean IsEmpty() {
        if (items.size() == 0)
            return true;
        return false;
    }

    public String ToString() {
        String str = "\nQueue items:\n";
        for (int i = 0; i < items.size(); i++)
            str += Integer.toString((int) items.get(i)) + '\n';
        return str;
    }
}
