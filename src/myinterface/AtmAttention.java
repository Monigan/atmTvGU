package myinterface;

import controller.AtmController;
import controller.impl.AtmControllerImpl;
import repository.CardRepository;

import javax.swing.*;
import java.awt.event.*;

public class AtmAttention extends JDialog {
    AtmController atmController = new AtmControllerImpl();
    CardRepository cardRepository = new CardRepository();
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextArea attentionArea;
    private JTextField pinCodeArea;

    public AtmAttention() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        if (atmController.inputCard(cardRepository.getCardById(0), Integer.parseInt(pinCodeArea.getText()))){
            dispose();
            AtmInterface atmInterface = new AtmInterface(cardRepository.getCardById(0), Integer.parseInt(pinCodeArea.getText()));
            atmInterface.pack();
            atmInterface.setVisible(true);
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
