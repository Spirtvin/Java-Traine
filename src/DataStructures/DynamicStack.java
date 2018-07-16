package DataStructures;

import java.util.ArrayList;


//TODO:
public class DynamicStack {
    /**
     * Наш ArrayList.
     */
    ArrayList items = new ArrayList();

    /**
     * Добавляем элемент в список.
     * @param value - добовляемый элемент.
     */
    public void Push(int value) {
        items.add(value);
    }

    /**
     * @return Возвращает верхний элемент и удаляет его.
     */
    public int Pop() throws Exception {
        if (!IsEmpty()) {
            int tmp = (int) items.get(items.size() - 1);
            items.remove(items.size()-1);
            return tmp;
        }
        throw new Exception("Empty stack\n");
    }

    /**
     * @return Возвращает верхний элемент.
     */
    public int Peek() throws Exception {
        if (!IsEmpty())
            return (int) items.get(items.size() - 1);
        throw new Exception("Empty stack\n");
    }

    /**
     * @return Проверка на пустоту листа.
     */
    public boolean IsEmpty() {
        if (items.size() == 0)
            return true;
        return false;
    }

    public String ToString() {
        String str = "\nStack items:\n";
        for (int i = 0; i < items.size(); i++)
            str += Integer.toString((int) items.get(i)) + '\n';
        return str;
    }

    /**
     * Поиск
     * @param value ищим.
     * @return если нашли true, если нет false.
     */
    public boolean Find(int value){
        for (int i = 0; i < items.size(); i++)
            if((int)items.get(i) == value) {
                System.out.print("Мы его нашли! Он есть в списке:)");
                return true;
            }
        System.out.print("Мы не нашли! Его нет в списке:(");
        return false;
    }
}