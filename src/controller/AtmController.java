package controller;

import model.Card;

public interface AtmController {
    boolean inputCard(int cardId, int pinCode);
    Card getCard();
    void removeCard();
    boolean takeMoney(double value);
    void putMoney(double value);
}
