package cc.morawiec.apps.Poker;

import cc.morawiec.apps.Cards.Card;
import cc.morawiec.apps.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * klasa symuluje rozdanie pokerowe
 */
public class Table{
    private PokerDeck talia = new PokerDeck();
    private Player[] gracze;
    private List<Card> lista = new ArrayList<Card>();

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
            String name = "Gracz "+(Integer.toString(i+1));
            gracze[i] = new Player(name);
        }
        System.out.println("przy stoliku zasiada " + gracze.length + " graczy");
    }

    public void makeFlop(){
        System.out.println("Karty na flopie:");
        for (int i = 0; i < 3; i++) {
            lista.add(talia.getOneCard());
        }
    }

    public void makeTurn(){
        System.out.println("Karta na turnie:");
            lista.add(talia.getOneCard());
    }

    public void makeRiver(){
        System.out.println("Karta na riverze:");
            lista.add(talia.getOneCard());
    }

    public List<Card> getLista() {
        for (Card aLista : lista) {
            System.out.println(aLista);
        }
        return lista;
    }

    /**
     * Rozdaje po 2 karty wszystkim graczom
     */
    public void dealing2Cards(){
        for (Player aGracze : gracze) {
            System.out.println(aGracze.getPlayerName());
            aGracze.setFirstCard(talia.getOneCard());
        }
        for (Player aGracze : gracze) {
            System.out.println(aGracze.getPlayerName());
            aGracze.setSecondCard(talia.getOneCard());
        }
    }




}
