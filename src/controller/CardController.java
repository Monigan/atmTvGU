package controller;

import model.Card;

public interface CardController {
    void makeCard(long number, String cardHolder, String date, int code, int pinCode, String region);
    Card getCardById(int id);
    boolean validatePinCode(int pinCode, Card card);
    void saveState(Card card);
}
