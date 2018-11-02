package Threads.Trains.Forms;

import GUI_Forms.SimpleForm;
import Threads.Trains.Direction;
import Threads.Trains.Train;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Semaphore;

public class Main extends SimpleForm {
    private JProgressBar pbBridge;
    private JList lstLeft;
    private JList lstRight;
    private JPanel mainPanel;
    private JLabel lblProgress;

    public Main() {
        final Semaphore semaphore = new Semaphore(1);
        DefaultListModel<String> modelLeft = new DefaultListModel<>();
        DefaultListModel<String> modelRight = new DefaultListModel<>();
        lstLeft.setModel(modelLeft);
        lstRight.setModel(modelRight);
        Init(mainPanel);
        for (int i = 0; i < 5; i++) {
            Train train = new Train(String.valueOf(i + 1) + "L", 100, pbBridge, lblProgress, modelLeft, modelRight, semaphore, Direction.Right);
            modelLeft.addElement(train.name);
            train.start();
        }
        for (int i = 0; i < 2; i++) {
            Train train = new Train(String.valueOf(i + 1) + "R", 100, pbBridge, lblProgress, modelLeft, modelRight, semaphore, Direction.Left);
            modelRight.addElement(train.name);
            train.start();
        }
    }

    @Override
    public void AddListeners() {

    }

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
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(2, 3, new Insets(0, 0, 0, 0), -1, -1));
        lstLeft = new JList();
        mainPanel.add(lstLeft, new GridConstraints(0, 0, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 150), null, 0, false));
        pbBridge = new JProgressBar();
        pbBridge.setValue(0);
        mainPanel.add(pbBridge, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(-1, 20), null, 0, false));
        lstRight = new JList();
        mainPanel.add(lstRight, new GridConstraints(0, 2, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 150), null, 0, false));
        lblProgress = new JLabel();
        lblProgress.setText("Label");
        mainPanel.add(lblProgress, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
