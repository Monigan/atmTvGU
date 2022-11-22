package controller;

import model.Card;

public interface CardController {
    Card makeCard(long number, String cardHolder, String date, int code, int pinCode, String region);
    boolean validatePinCode(int pinCode, Card card);
}
