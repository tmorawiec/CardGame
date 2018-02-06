package cc.morawiec.apps.Poker;

import cc.morawiec.apps.Cards.Card;
import cc.morawiec.apps.Player;

import java.io.IOException;

/**
 * klasa symuluje rozdanie pokerowe
 */
public class Table{
    private PokerDeck talia = new PokerDeck();
    private Player[] gracze;

    /**
     * Konstruktor tworzy tablicę graczy, tasuje karty i wrzuca je do kolejki
     * @throws IOException
     */
    public Table() throws IOException {
        this.talia.shuffleDeck();
        this.talia.makeQueue();

        /*
        tymczasowy fragment: tworzy 3 graczy i dodaje do tablicy
         */
        this.gracze = new Player[3];
        for (int i=0; i<gracze.length ; i++){
            String name = "Gracz "+(Integer.toString(i));
            gracze[i] = new Player(name);
        }
        System.out.println("przy stoliku zasiada " + gracze.length + " graczy");
    }

    /**
     * Rozdaje po 2 karty wszystkim graczom
     */
    // do zrobienia:
    public void dealing2Cards(){
        Card[] tempArray = new Card[2];
        tempArray[0] = talia.getOneCard();
        gracze[0].setHand(tempArray);
    }




}
