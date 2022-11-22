package myinterface;

import controller.AtmController;
import controller.impl.AtmControllerImpl;
import model.Card;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtmInterface extends JDialog{
    AtmController atmController = new AtmControllerImpl();
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


    public AtmInterface(Card card, int pinCode) {
        setContentPane(contentPane);
        setModal(true);
        atmController.inputCard(card, pinCode);
        parseCardInfo(card);
        takeMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (atmController.hasMoney(card)){
                    AtmTakeMoney atmTakeMoney = new AtmTakeMoney(card);
                    atmTakeMoney.pack();
                    atmTakeMoney.setVisible(true);
                }
            }
        });
    }

    public void parseCardInfo(Card card){
        cardNumber.append(String.valueOf(card.getNumber()));
        cardDate.append(String.valueOf(card.getDate()));
        cardOwner.append(card.getCardHolder());
        cardBalanse.append(String.valueOf(card.getMoneyValue()));
    }
}
