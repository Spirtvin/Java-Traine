package Interfaces;

import javax.swing.*;

/**
 * интерфейс ввода/вывода для консолей и окон
 */
public interface IO {
    /**
     * возвращает тип объекта
     *
     * @return
     */
    IOType GetType();

    /**
     * считать данные из контрола на форме
     *
     * @param component элемент управления на форме
     * @return
     */
    Object In(JComponent component) throws InterruptedException;

    /**
     * считать данные из консоли
     *
     * @param message инструкция по вводу
     * @return
     */
    Object In(String message) throws InterruptedException;

    /**
     * вывести данные в элемент на форме
     *
     * @param object    объект для вывода
     * @param component элемент на форме
     */
    void Out(Object object, JComponent component);

    /**
     * вывести данные в элементы на форме
     *
     * @param objects объекты для вывода, порядок важен
     * @param message подпись(выводится над объектом)
     */
    void Out(Object[] objects, String message);

    /**
     * вывести данные в консоль
     *
     * @param object  объект для вывода
     * @param message подпись(выводится над объектом)
     */
    void Out(Object object, String message);

    void SetDataReady(boolean value);

    boolean GetDataReady();
}
