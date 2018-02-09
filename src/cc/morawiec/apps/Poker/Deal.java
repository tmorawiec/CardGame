package cc.morawiec.apps.Poker;

import cc.morawiec.apps.Cards.Card;
import cc.morawiec.apps.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * klasa symuluje rozdanie pokerowe
 */
public class Deal {
    private PokerDeck talia = new PokerDeck();
    private List<Player> players;
    private List<Card> board = new ArrayList<Card>();

    /**
     * Konstruktor przekazuje graczy do listy, tasuje karty i wrzuca je do kolejki
     * @throws IOException
     */
    public Deal(List<Player> playersToDeal) throws IOException {
        this.talia.shuffleDeck();
        this.talia.makeQueue();
        this.players = playersToDeal;
    }

    public void makeFlop(){
        talia.getOneCard(); //palenie karty
        for (int i = 0; i < 3; i++) {
            board.add(talia.getOneCard());
        }
    }

    public void makeTurnOrRiver(){
        talia.getOneCard(); //palenie karty
        board.add(talia.getOneCard());
    }

    public List<Card> getBoard() {
        return board;
    }

    /**
     * Rozdaje karty wszystkim graczom
     */
    public void dealingCards(){
        for (int i = 0; i < 2; i++) {
            for (Player aGracze : players) {
                aGracze.setHand(talia.getOneCard());
            }
        }
    }

    public List<Player> getPlayers() {
        return players;
    }


}
