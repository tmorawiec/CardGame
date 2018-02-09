package cc.morawiec.apps.Poker;

import cc.morawiec.apps.Cards.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class CheckHand {


    public static ArrayList<Card> check(ArrayList<Card> playerCards, List<Card> tableCards){
        ArrayList<Card> allCards = new ArrayList<Card>();
        allCards.addAll(playerCards);
        allCards.addAll(tableCards);

        return allCards;
    }

}

