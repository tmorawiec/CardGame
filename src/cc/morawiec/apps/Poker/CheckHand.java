package cc.morawiec.apps.Poker;

import cc.morawiec.apps.Cards.Card;
import cc.morawiec.apps.Cards.CardFigure;

import java.util.ArrayList;
import java.util.Collections;
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
        Collections.sort(hand);

        // todo-me napisanie metody
        return null;
    }

    public static boolean is_royal_flush(ArrayList<Card> o){
        return true;
    }


    public static int is_straight(ArrayList<Card> o){
        int i = 0;
        int streight = 1;
        while (i < o.size()-1) {
            if (hasConsecutiveRank(o.get(i),o.get(i+1))){

                streight++;
            }

            i++;

        }
        return streight;
    }


    /**
     * Sprawdza czy dwie kolejne karty robią draw do strita
     * @param card1
     * @param card2
     * @return true jeśli jest draw do strita
     */
    public static boolean hasConsecutiveRank(Card card1, Card card2){
        return (card2.getVal() == card1.getVal() - 1)||(card1.getFigura() == CardFigure.ACE && card2.getFigura() == CardFigure.TWO);
    }

    public static boolean hasSameValue(Card card1,Card card2){
        return (card1.getVal() == card2.getVal());
    }

}

