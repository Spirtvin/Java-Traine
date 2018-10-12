package DataStructures.Stack.Static;


import DataStructures.DataStructure;

import java.util.ArrayList;

public class StaticStack extends DataStructure {
    /**
     * Максимальное число елементов
     */
    int maxCount = 0;

    /**
     * конструктор
     *
     * @param _maxCount маскимальный размер стека
     */
    public StaticStack(int _maxCount) {
        maxCount = _maxCount;
    }

    /**
     * Добавть в начало
     *
     * @param item
     * @return
     */
    @Override
    public void PushFront(Object item) {
        throw new UnsupportedOperationException();
    }

    /**
     * Добавть в конец
     *
     * @param item
     * @return
     */
    @Override
    public void PushBack(Object item) {
        if (!IsFull())
            items.add(item);
        else
            throw new UnsupportedOperationException();
    }

    /**
     * Извлечь и из начала
     *
     * @return
     */
    @Override
    public Object PopFront() {
        throw new UnsupportedOperationException();
    }

    /**
     * Извлечь из конца
     *
     * @return
     */
    @Override
    public Object PopBack() {
        if (!IsEmpty()) {
            Object item = items.get(items.size() - 1);
            items.remove(item);
            return item;
        } else
            throw new UnsupportedOperationException();
    }

    /**
     * @return true - если пустой
     */
    public boolean IsEmpty() {
        return items.size() == 0;
    }

    public boolean IsFull() {
        if (items != null)
            return maxCount == items.size();
        return false;
    }

    /**
     * Очистка
     *
     * @return
     */
    @Override
    public void Clear() {
        items.clear();
    }


}