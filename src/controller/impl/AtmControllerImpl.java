package controller.impl;

import controller.AtmController;
import controller.CardController;
import model.Atm;
import model.Card;
import repository.AtmRepository;

public class AtmControllerImpl implements AtmController {
    AtmRepository atmRepository = new AtmRepository();
    Atm atm = atmRepository.getAtmById(0);
    CardController controller = new CardControllerImpl();
    Card card;

    @Override
    public boolean inputCard(Card card, int pinCode) {
        if (controller.validatePinCode(pinCode, card)){
            this.card = card;
            return true;
        }
        return false;
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
        return true;
    }

    @Override
    public void putMoney(double value) {
        card.setMoneyValue(card.getMoneyValue() + value);
    }

    @Override
    public boolean hasMoney(Card card) {
        return card.getMoneyValue() != 0;
    }
}
