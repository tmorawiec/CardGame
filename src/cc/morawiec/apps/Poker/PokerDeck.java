package cc.morawiec.apps.Poker;

import cc.morawiec.apps.Cards.Card;
import cc.morawiec.apps.Cards.DeckOfCards;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class PokerDeck extends DeckOfCards {
    private Queue<Card> myQueue;

    public PokerDeck() throws IOException {
        super();
        this.myQueue = new LinkedList<Card>();
    }

    public void makeQueue(){
        for (Card aDeck : super.getDeck()) {
            this.myQueue.offer(aDeck);
        }
    }

    /**
     * wyciąga kartę z talii
     * @return karta pobrana z talii
     */
    public Card getOneCard() {
        Card nowakarta = myQueue.poll();
        System.out.println("Rozdano: "+nowakarta);
        return nowakarta;
    }

}
