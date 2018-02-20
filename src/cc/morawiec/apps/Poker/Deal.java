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
    private List<Card> board = new ArrayList<>();

    private boolean ante = true;
    private int anteLevel = 10;

    private int mainPot;
    private int sidePot;

    /**
     * Konstruktor przekazuje graczy do listy, tasuje karty i wrzuca je do kolejki
     * @throws IOException
     */
    public Deal(List<Player> playersToDeal) throws IOException {
        this.talia.shuffleDeck();
        this.talia.makeQueue();
        this.players = playersToDeal;
        this.mainPot = 0;
        this.sidePot = 0;
    }

    public void makeFlop(){
        talia.getOneCard(); //palenie karty
        for (int i = 0; i < 3; i++) {
            board.add(talia.getOneCard());
        }
        handPower();
    }

    public void makeTurnOrRiver(){
        talia.getOneCard(); //palenie karty
        board.add(talia.getOneCard());
        handPower();
    }

    public List<Card> getBoard() {
        return board;
    }

    /**
     * Sprawdza czy jest ante, true - pobiera odpowiednią ilość ante
     * Rozdaje karty wszystkim graczom
     */
    public void dealingCards(){
        if(ante){
            takeAnte(anteLevel);
        }
        for (int i = 0; i < 2; i++) {
            for (Player aGracze : players) {
                aGracze.setHand(talia.getOneCard());
            }
        }
        handPower();
    }

    /**
     * pobiera ante od wsszystkich graczy i dodaje je do mainPota
     * @param ante
     */
    private void takeAnte (int ante){
            for (Player aGracze : players) {
                if (aGracze.getStack() >= ante){
                    mainPot += aGracze.subtractStack(ante);
                }
            }
    }


    /**
     * Ustawia aktualny najmocniejszy układ na ręce gracza
     */
    private void handPower(){
        for (Player aGracze : players) {
            aGracze.setHandPower(CheckHand.handPower(CheckHand.join(aGracze.getHand(),this.board)));
        }

    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getMainPot() {
        return mainPot;
    }

    public int getSidePot() {
        return sidePot;
    }
}
