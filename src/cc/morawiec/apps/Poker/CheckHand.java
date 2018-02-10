package cc.morawiec.apps.Poker;

import cc.morawiec.apps.Cards.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class CheckHand {

    /**
     * scala karty gracza z kartami na stole
     * @param playerCards
     * @param tableCards
     * @return tablica scalonych kart
     */
    public static ArrayList<Card> join(ArrayList<Card> playerCards, List<Card> tableCards){
        ArrayList<Card> allCards = new ArrayList<Card>();
        allCards.addAll(playerCards);
        allCards.addAll(tableCards);
        return allCards;
    }

    /**
     * Sprawdza układ pokerowy na ręce gracza
     * @param hand ręka gracza
     * @return najwyższy układ pokerowy
     */
    public static HandRank checkHand(ArrayList<Card> hand){
        // todo-me napisanie metody
        return null;
    }

}

