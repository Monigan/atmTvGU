package controller.impl;

import controller.CardController;
import model.Card;

public class CardControllerImpl implements CardController {

    @Override
    public Card makeCard(long number, String cardHolder, String date, int code, int pinCode, String region) {
        return new Card(number, cardHolder, date, code, pinCode, region);
    }

    @Override
    public boolean validatePinCode(int pinCode, Card card) {
        return card.getPinCode() == pinCode;
    }
}
