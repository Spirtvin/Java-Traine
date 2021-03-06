package GUI_Forms;

import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;

public abstract class SimpleForm extends JFrame {

    private JPanel basePanel;

    public SimpleForm() {
        //Init(this.basePanel);
    }

    public void Open(JPanel mainPanel) {
        //Runnable formRunnable = () -> Init(mainPanel);
        //new Thread(formRunnable).start();
        Init(mainPanel);
    }

    /**
     * Инициализирует форму
     *
     * @param mainPanel главная панель
     */
    public void Init(JPanel mainPanel) {
        add(mainPanel);
        setLocationRelativeTo(null);
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        AddListeners();
    }

    /**
     * привязывает обработчики кнопок
     */
    public abstract void AddListeners();

    public abstract void Close();

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        basePanel = new JPanel();
        basePanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return basePanel;
    }

}
