package myinterface;

import controller.AtmController;
import model.Card;

import javax.swing.*;

public class AtmInterface extends JDialog{
    private JPanel contentPane;
    private JTextArea cardNumber;
    private JTextArea cardOwner;
    private JTextArea cardDate;
    private JButton placeholderButton1;
    private JButton placeholderButton2;
    private JButton placeholderButton3;
    private JButton takeMoneyButton;
    private JButton putMoneyButton;
    private JLabel labelText;
    private JTextArea cardNumberText;
    private JTextArea cardOwnerText;
    private JTextArea cardDateText;
    private JTextArea cardBalanseText;
    private JTextArea cardBalanse;


    public AtmInterface(AtmController atmController) {
        setContentPane(contentPane);
        setModal(true);
        parseCardInfo(atmController.getCard());
        takeMoneyButton.addActionListener(e -> {
            dispose();
            AtmTakeMoney atmTakeMoney = new AtmTakeMoney(atmController);
            atmTakeMoney.pack();
            atmTakeMoney.setVisible(true);

        });
        putMoneyButton.addActionListener(e -> {
            dispose();
            AtmPutMoney atmPutMoney = new AtmPutMoney(atmController);
            atmPutMoney.pack();
            atmPutMoney.setVisible(true);
        });
    }

    public void parseCardInfo(Card card){
        cardNumber.append(String.valueOf(card.getNumber()));
        cardDate.append(String.valueOf(card.getDate()));
        cardOwner.append(card.getCardHolder());
        cardBalanse.append(String.valueOf(card.getMoneyValue()));
    }
}
