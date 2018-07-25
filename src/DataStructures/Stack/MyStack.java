package DataStructures.Stack;


//TODO: сделать поиск - метод Find
public class MyStack {
    /**
     * элементы стека
     */
    int[] items;
    /**
     * количество элементов в стеке.
     * указывает на верхушку стека.
     * не может быть больше размера стека.
     */
    int count = 0;

    /**
     * конструктор
     * @param count размер стека
     */
    public MyStack(int count) {
        items = new int[count];
    }

    /**
     * Добавляем элемент в стек
     *
     * @param value значение для добавления
     */
    public void Push(int value) {
        if (!IsFull()) {
            items[count++] = value;
        }
    }

    public int Pop() {
        if (!IsEmpty())
            return items[--count];
        return -1;
    }

    public int Peek() {
        if (!IsEmpty())
            return items[count];
        return -1;
    }

    /**
     * @return true - если пустой
     */
    public boolean IsEmpty() {
        return count == 0;
    }

    public boolean IsFull() {
        return !(count < items.length);
    }

    public String ToString() {
        String str = "\nStack items:\n";
        for (int i = 0; i < count; i++)
            str += Integer.toString(items[i]) + '\n';
        return str;
    }

    public boolean Find (int value)
    {
        for (int i = 0; i < count; i++)
        if(items[i] == value)
            return true;
        return false;
    }
}