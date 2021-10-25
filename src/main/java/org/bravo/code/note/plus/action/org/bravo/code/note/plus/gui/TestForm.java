package org.bravo.code.note.plus.action.org.bravo.code.note.plus.gui;

import javax.swing.*;
import java.awt.*;

/**
 * @author lijian
 * @since 2021/10/25
 */
public class TestForm {
    private JPanel mainPanel;
    private JTextField textField;
    private JButton button1;
    private JButton button2;

    public static void show() {
        JDialog dialog = new JDialog();

        dialog.setTitle("我的标题");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int w = (screenSize.width - 800) / 2;
        int h = (screenSize.height * 95 / 100 - 800) / 2;
        dialog.setLocation(w, h);

        TestForm testForm = new TestForm();
        dialog.setContentPane(testForm.mainPanel);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.pack();
        dialog.setVisible(true);
    }

}
