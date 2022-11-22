package repository;

import model.Card;

import java.util.ArrayList;
import java.util.List;

public class CardRepository {
    List<Card> cards = new ArrayList<>();

    public CardRepository() {
        this.cards.add(new Card(4400122045501488L,"Vasya Pupkink", "04/28", 628, 2344, "rub"));
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public Card getCardById(int id){
        return cards.get(id);
    }
}
