package DataStructures;

import java.util.ArrayList;

/**
 * структура данных
 */
public abstract class DataStructure {

    //<editor-fold desc="Fields">
    /**
     * элементы
     */
    public ArrayList<Object> items = new ArrayList<>();
    //</editor-fold>

    //<editor-fold desc="Methods">

    /**
     * Добавть в начало
     *
     * @return
     */
    public abstract void PushFront(Object item);

    /**
     * Добавть в конец
     *
     * @return
     */
    public abstract void PushBack(Object item);

    /**
     * Извлечь и из начала
     *
     * @return
     */
    public abstract Object PopFront();

    /**
     * Извлечь из конца
     *
     * @return
     */
    public abstract Object PopBack();

    /**
     * Проверка на пустоту
     *
     * @return
     */
    public abstract boolean IsEmpty();

    /**
     * Проверка на заполненность
     *
     * @return
     */
    public abstract boolean IsFull();

    /**
     * Очистка
     *
     * @return
     */
    public abstract void Clear();

    /**
     * поиск
     *
     * @param obj элемент для поиска
     * @return
     */
    public boolean Search(Object obj) {
        for (Object item : items)
            if (item.equals(obj))
                return true;
        return false;
    }

    /**
     * преобразует в строку
     *
     * @return
     */
    public String toString() {
        String str = "\nStack items:\n";
        for (int i = 0; i < items.size(); i++)
            str += items.get(i).toString() + '\n';
        return str;
    }



    //</editor-fold>
}
