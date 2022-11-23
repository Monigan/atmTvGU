package myinterface;

import controller.AtmController;

import javax.swing.*;
import java.awt.event.*;

public class AtmPutMoney extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel cardBalansText;
    private JTextArea cardBalans;
    private JLabel cardPutText;
    private JTextField cardPut;

    public AtmPutMoney(AtmController atmController) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        cardBalans.insert(atmController.getCard().getMoneyValue() + atmController.getCard().getRegion(), 0);
        buttonOK.addActionListener(e -> onOK(atmController));

        buttonCancel.addActionListener(e -> onCancel(atmController));

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel(atmController);
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(atmController), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK(AtmController atmController) {
        // add your code here
        dispose();
        atmController.putMoney(Double.parseDouble(cardPut.getText()));
        atmController.removeCard();
        AtmAttention atmAttention = new AtmAttention(atmController);
        atmAttention.pack();
        atmAttention.setVisible(true);
    }

    private void onCancel(AtmController atmController) {
        // add your code here if necessary
        dispose();
        atmController.removeCard();
        AtmAttention atmAttention = new AtmAttention(atmController);
        atmAttention.pack();
        atmAttention.setVisible(true);
    }

}
