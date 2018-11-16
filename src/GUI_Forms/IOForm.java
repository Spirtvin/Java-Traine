package GUI_Forms;

import Games.Field.GameField;
import Interfaces.IO;
import Interfaces.IOType;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class IOForm extends SimpleForm implements IO {
    /**
     * данные, которые ввел пользователь
     */
    public Object data;
    private boolean dataReady;
    public JComponent[] inputControl;
    public JComponent[] outputControl;

    public void SetDataReady(boolean value) {
        dataReady = value;
    }

    public boolean GetDataReady() {
        return this.dataReady;
    }

    public void Init(JComponent[] in, JComponent[] out, JPanel mainPanel) {
        add(mainPanel);
        this.inputControl = in;
        this.outputControl = out;
    }

    public void Open(JPanel mainPanel) {
        //Runnable component = () -> Init(mainPanel);
        //new Thread(component).start();
        Init(mainPanel);
    }

    /**
     * возвращает тип объекта
     *
     * @return
     */
    @Override
    public IOType GetType() {
        return IOType.form;
    }

    /**
     * считать данные из контрола на форме
     *
     * @param component элемент управления на форме
     * @return
     */
    @Override
    public Object In(JComponent component) throws InterruptedException {
        //System.out.println(Thread.currentThread().getId());
        //while (!GetDataReady())
        //    Thread.currentThread().sleep(1000);
        if (component.getClass().getName() == (new JTable()).getClass().getName()) {
            int row = ((JTable) component).getSelectedRow();
            int column = ((JTable) component).getSelectedColumn();
            this.data = new Integer[]{row, column};
            System.out.println(String.format("%d %d", ((Integer[]) this.data)[0], ((Integer[]) this.data)[1]));
            dataReady = true;
            return this.data;
        }
        if (component.getClass().getName() == (new JTextField()).getClass().getName()) {
            dataReady = true;
            return ((JTextField) component).getText();
        }
        if (component.getClass().getName() == (new JFormattedTextField()).getClass().getName()) {
            dataReady = true;
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
            new OutputForm<>("Ok", message);
        return In(inputControl[0]);
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
                ((JLabel) component).setText(object.toString());
                this.dataReady = false;
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
                    this.dataReady = false;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error: ", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * вывести данные в элементы на форме
     *
     * @param objects объекты для вывода, порядок важен
     * @param message подпись(выводится над объектом)
     */
    @Override
    public void Out(Object[] objects, String message) {
        if (message != null && message.length() > 0)
            new OutputForm<>("Ok", message);
        if (objects.length == this.outputControl.length)
            for (int i = 0; i < objects.length; i++)
                Out(objects[i], this.outputControl[i]);
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
            new OutputForm<>("Ok", message);
        Out(object, outputControl[0]);
    }

    /**
     * привязывает обработчики кнопок
     */
    @Override
    public void AddListeners() {

    }

    @Override
    public void Close() {

    }
}
