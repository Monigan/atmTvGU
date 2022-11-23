package controller.impl;

import controller.AtmController;
import controller.CardController;
import model.Card;

public class AtmControllerImpl implements AtmController {
    CardController controller = new CardControllerImpl();
    Card card;

    @Override
    public boolean inputCard(int cardId, int pinCode) {
        if (controller.validatePinCode(pinCode, controller.getCardById(cardId))){
            this.card = controller.getCardById(cardId);
            return true;
        }
        return false;
    }

    @Override
    public Card getCard() {
        return this.card;
    }

    @Override
    public void removeCard() {
        this.card = null;
    }

    @Override
    public boolean takeMoney(double value) {
        if (value>card.getMoneyValue()){
            return false;
        }
        card.setMoneyValue(card.getMoneyValue() - value);
        controller.saveState(card);
        return true;
    }

    @Override
    public void putMoney(double value) {
        card.setMoneyValue(card.getMoneyValue() + value);
        controller.saveState(card);
    }
}
