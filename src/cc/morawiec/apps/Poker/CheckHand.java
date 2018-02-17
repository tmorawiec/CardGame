package cc.morawiec.apps.Poker;

import cc.morawiec.apps.Cards.Card;
import cc.morawiec.apps.Cards.CardFigure;
import cc.morawiec.apps.Cards.CardSorter;
import com.sun.corba.se.pept.transport.ContactInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * metody stosować po uprzednim posegregowaniu kart wg wartosci
 */
public final class CheckHand {
    ArrayList<Card> sortHand;

    /**
     * Don't let anyone instantiate this class.
     */
    private CheckHand(){}

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

    private static ArrayList<Card> getSortedByFigure(ArrayList<Card> o) {
        Collections.sort(o, Card.figureComparator);
        return o;
    }
    private static ArrayList<Card> getSortedBySuit(ArrayList<Card> o) {
        Collections.sort(o, Card.suitComparator);
        return o;
    }



    public static boolean isRoyalFlush(ArrayList<Card> o){
        return false;
        // TODO: 16.02.2018  
    }

    public static boolean isPoker(ArrayList<Card> o){
        return false;
        // TODO: 16.02.2018
    }


    public static boolean isStraight(ArrayList<Card> o){
        getSortedByFigure(o);
        int i = 0;
        int straight = 1;

        while (i < o.size()-1) {
            if (hasConsecutiveRank(o.get(i),o.get(i+1))){
                straight++;
                if (straight==5) break;
            }
            else if (!hasSameValue(o.get(i),o.get(i+1))){
                straight = 1;
            }
            i++;
        }
        if (straight == 4 && hasConsecutiveRank(o.get(0),o.get(o.size()-1))){ //daje strita przy A2
            straight = 5;
        }
        return (straight==5);
    }

    public static boolean isOnePair(ArrayList<Card> o){
        getSortedByFigure(o);
        for(int i=0;i<o.size()-1;i++){
            if (hasSameValue(o.get(i),o.get(i+1))){
                return true;
            }
        }
        return false;
    }

    public static boolean isThreeOfKind(ArrayList<Card> o){
        getSortedByFigure(o);
        for(int i=0;i<o.size()-2;i++){
            if (hasSameValue(o.get(i),o.get(i+1),o.get(i+2))){
                return true;
            }
        }
        return false;
    }

    public static boolean isQuads(ArrayList<Card> o){
        getSortedByFigure(o);
        for(int i=0;i<o.size()-3;i++){
            if (hasSameValue(o.get(i),o.get(i+1),o.get(i+2),o.get(i+3))){
                return true;
            }
        }
        return false;
    }

    // TODO: 16.02.2018
    public static boolean isFlush(ArrayList<Card> o){
        getSortedBySuit(o);
        for(int i=0;i<o.size()-4;i++){
            if (hasSameSuit(o.get(i),o.get(i+1),o.get(i+2),o.get(i+3),o.get(i+4))){
                return true;
            }
        }
        return false;
    }

    public static boolean isTwoPair(ArrayList<Card> o){
        getSortedByFigure(o);
        boolean firstPair = false;
        boolean secondPair = false;
        int usedNumb = 0;
        int kicker = 0;

        for(int i=0;i<o.size()-1;i++){
            if (hasSameValue(o.get(i),o.get(i+1))){
                usedNumb = o.get(i).getVal();
                firstPair = true;
            }
        }
        if (firstPair){
            for(int i=0;i<o.size()-1;i++){
                if ((hasSameValue(o.get(i),o.get(i+1))) && (o.get(i).getVal() != usedNumb)){
                    secondPair = true;
                }
            }
        }
        return (secondPair);
    }

    public static boolean isFullhouse(ArrayList<Card> o){
        getSortedByFigure(o);
        boolean is_three = false;
        boolean is_two = false;
        int usedNumb = 0;
        int kicker = 0;

            for(int i=0;i<o.size()-2;i++){
                if (hasSameValue(o.get(i),o.get(i+1),o.get(i+2))){
                    usedNumb = o.get(i).getVal();
                    kicker = usedNumb;
                    is_three = true;
                }
            }
            if (is_three){
                for(int i=0;i<o.size()-1;i++){
                    if (hasSameValue(o.get(i),o.get(i+1))){
                        if (o.get(i).getVal() != usedNumb){
                            is_two = true;
                            if (usedNumb < o.get(i).getVal()){
                                kicker = o.get(i).getVal();
                            }
                        }
                    }
                }
            }
        return (is_two);
    }




    /**
     * Sprawdza czy dwie kolejne karty robią draw do strita
     * @param card1
     * @param card2
     * @return true jeśli jest draw do strita
     */
    private static boolean hasConsecutiveRank(Card card1, Card card2){
        return (card2.getVal() == card1.getVal() - 1)||(card1.getFigura() == CardFigure.ACE && card2.getFigura() == CardFigure.TWO);
    }

    private static boolean hasSameValue(Card card1, Card card2){
        return (card1.getVal() == card2.getVal());
    }

    private static boolean hasSameValue(Card card1, Card card2, Card card3){
        return ((card1.getVal() == card2.getVal()) && (card1.getVal() == card3.getVal()));
    }

    private static boolean hasSameValue(Card card1, Card card2, Card card3, Card card4){
        return ((card1.getVal() == card2.getVal()) && (card1.getVal() == card3.getVal()) && (card1.getVal() == card4.getVal()));
    }

    private static boolean hasSameSuit(Card card1, Card card2, Card card3, Card card4, Card card5){
        return ((card1.getKolor() == card2.getKolor()) && (card1.getKolor() == card3.getKolor()) && (card1.getKolor() == card4.getKolor()) && (card1.getKolor() == card5.getKolor()));
    }

}

