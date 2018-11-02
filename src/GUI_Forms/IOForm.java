package GUI_Forms;

import Games.Field.GameField;
import Interfaces.IO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class IOForm extends SimpleForm implements IO {
    private boolean dataReady;
    public JComponent inputControl;
    public JComponent outputControl;

    public void SetDataReady(boolean value) {
        dataReady = value;
    }

    public boolean GetDataReady() {
        return this.dataReady;
    }

    public void Init(JComponent in, JComponent out) {
        this.inputControl = in;
        this.outputControl = out;
    }

    /**
     * считать данные из контрола на форме
     *
     * @param component элемент управления на форме
     * @return
     */
    @Override
    public Object In(JComponent component) throws InterruptedException {
        while (!GetDataReady())
            Thread.sleep(1000);
        if (component.getClass().getName() == (new JTable()).getClass().getName()) {
            int row = ((JTable) component).getSelectedRow();
            int column = ((JTable) component).getSelectedColumn();
            System.out.println(String.format("%i %i", row, column));
            dataReady = false;
            return null;
        }
        if (component.getClass().getName() == (new JTextField()).getClass().getName()) {
            return ((JTextField) component).getText();
        }
        if (component.getClass().getName() == (new JFormattedTextField()).getClass().getName()) {
            return ((JFormattedTextField) component).getText();
        }
        return null;
    }

    /**
     * считать данные из консоли
     *
     * @param message инструкция по вводу
     * @return
     */
    @Override
    public Object In(String message) throws InterruptedException {
        if (message != null && message.length() > 0)
            Out(message, outputControl);
        return In(inputControl);
    }

    /**
     * вывести данные в элемент на форме
     *
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
                    for (int i = 0; i < ((GameField) object).GetSize().height; i++) {
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
        if (message != null && message.length() > 0)
            Out(message, outputControl);
        Out(object, outputControl);
    }

    /**
     * привязывает обработчики кнопок
     */
    @Override
    public void AddListeners() {

    }
}
