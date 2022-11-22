package controller;

import model.Card;

public interface AtmController {
    boolean inputCard(Card card, int pinCode);
    void removeCard();
    boolean takeMoney(double value);
    void putMoney(double value);
    boolean hasMoney(Card card);
}
