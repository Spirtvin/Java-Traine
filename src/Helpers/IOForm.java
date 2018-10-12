package Helpers;

import Games.Field.GameField;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class IOForm implements IO {
    /**
     * считать данные из контрола на форме
     * @param component элемент управления на форме
     * @return
     */
    @Override
    public Object In(JComponent component) {
        if (component.getClass().getName() == (new JTable()).getClass().getName()) {
            return null;
        }
        return null;
    }

    /**
     * считать данные из консоли
     * @param message инструкция по вводу
     * @return
     */
    @Override
    public Object In(String message) {
        throw new NotImplementedException();
    }

    /**
     * вывести данные в элемент на форме
     * @param object    объект для вывода
     * @param component элемент на форме
     */
    @Override
    public void Out(Object object, JComponent component) {
        try {
            if (component.getClass().getName() == (new JLabel()).getClass().getName()) {
                ((JLabel) component).setText((String) object);
            }
            if (component.getClass().getName() == (new JTable()).getClass().getName()) {
                if (object.getClass().getName() == (new GameField(3)).getClass().getName()) {
                    DefaultTableModel model = new DefaultTableModel();
                    for (int i = 0; i < ((GameField) object).GetSize().width; i++) {
                        model.addColumn("Col" + i);
                    }
                    for (int i = 0; i < ((GameField) object).GetSize().height ; i++) {
                        Object[] items = new Object[((GameField) object).GetSize().height];
                        for (int j = 0; j < ((GameField) object).GetSize().width; j++) {
                            items[j] = ((GameField) object).GetCell(i, j).toString();
                        }
                        model.addRow(items);
                    }
                    ((JTable) component).setModel(model);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error: ", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * вывести данные в консоль
     *
     * @param object  объект для вывода
     * @param message подпись(выводится над объектом)
     */
    @Override
    public void Out(Object object, String message) {
        throw new NotImplementedException();
    }
}
