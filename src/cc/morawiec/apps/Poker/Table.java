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
    private PokerDeck talia = new PokerDeck();        //talia
    private Player[] gracze;                          //
    private List<Card> lista = new ArrayList<Card>(); //board

    /**
     * Konstruktor tworzy tablicę graczy, tasuje karty i wrzuca je do kolejki
     * @throws IOException
     */
    public Table() throws IOException {
        this.talia.shuffleDeck();
        this.talia.makeQueue();

        /*
        tymczasowy fragment: tworzy 3 graczy i dodaje do tablicy, przerobić że gracze
        są przekazywani w parametrze
         */
        this.gracze = new Player[3];
        for (int i=0; i<gracze.length ; i++){
            String name = "Gracz "+(Integer.toString(i+1));
            gracze[i] = new Player(name,5000);
        }
    }

    public void makeFlop(){
        talia.getOneCard(); //palenie karty
        for (int i = 0; i < 3; i++) {
            lista.add(talia.getOneCard());
        }
    }

    public void makeTurnOrRiver(){
        talia.getOneCard(); //palenie karty
        lista.add(talia.getOneCard());
    }

    public List<Card> getLista() {
        for (Card aLista : lista) {
            System.out.println(aLista);
        }
        return lista;
    }

    /**
     * Rozdaje karty wszystkim graczom
     */
    public void dealingCards(){
        for (int i = 0; i < 2; i++) {
            for (Player aGracze : gracze) {
                aGracze.setHand(talia.getOneCard());
            }
        }
    }

    public Player[] getGracze() {
        return gracze;
    }


}
