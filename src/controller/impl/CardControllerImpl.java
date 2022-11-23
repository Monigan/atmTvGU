package controller.impl;

import controller.CardController;
import model.Card;
import repository.CardRepository;

public class CardControllerImpl implements CardController {
    CardRepository cardRepository = new CardRepository();
    @Override
    public void makeCard(long number, String cardHolder, String date, int code, int pinCode, String region) {
        cardRepository.addCard(new Card(number, cardHolder, date, code, pinCode, region));
    }

    @Override
    public Card getCardById(int id) {
        return cardRepository.getCardById(id);
    }

    @Override
    public boolean validatePinCode(int pinCode, Card card) {
        return card.getPinCode() == pinCode;
    }

    @Override
    public void saveState(Card card) {
        cardRepository.saveState(card);
    }
}
