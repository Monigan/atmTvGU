package myinterface;

import controller.AtmController;

import javax.swing.*;
import java.awt.event.*;

public class AtmAttention extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextArea attentionArea;
    private JTextField pinCodeArea;
    private JTextArea errorArea;

    public AtmAttention(AtmController atmController) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> onOK(atmController));

        buttonCancel.addActionListener(e -> onCancel());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK(AtmController atmController) {
        // add your code here
        if (atmController.inputCard(0, Integer.parseInt(pinCodeArea.getText()))){
            dispose();
            AtmInterface atmInterface = new AtmInterface(atmController);
            atmInterface.pack();
            atmInterface.setVisible(true);
        }
        else{
            errorArea.insert("Вы ввели неверный pin-код!", 0);
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
