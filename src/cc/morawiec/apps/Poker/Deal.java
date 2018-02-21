package cc.morawiec.apps.Poker;

import cc.morawiec.apps.Cards.Card;
import cc.morawiec.apps.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * klasa symuluje pojedyncze rozdanie pokerowe
 */
public class Deal {
    private PokerDeck talia = new PokerDeck();
    private List<Player> players;
    private List<Card> board = new ArrayList<>();
    private Levels level;

    private boolean ante;
    private int anteLevel;
    private int bigBlind;
    private int smallBlind;

    private int mainPot;
    private int sidePot;

    /**
     * Konstruktor przekazuje graczy do listy, tasuje karty i wrzuca je do kolejki
     * przekazuje też level gry
     * @throws IOException
     */
    public Deal(List<Player> playersToDeal,Levels level) throws IOException {
        this.talia.shuffleDeck();
        this.talia.makeQueue();

        this.level = level;
        this.players = playersToDeal;
        this.mainPot = 0;
        this.sidePot = 0;


        this.ante = this.level.isAnte();
        this.anteLevel = this.level.getAnte();
        this.bigBlind = this.level.getBigBlind();
        this.smallBlind = this.level.getSmallBlind();

        // TODO: 20.02.2018 wymyślić coś z przejściem dealera i oznaczaniem dealera 
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
        setHandPower();
    }

    public void makeFlop(){
        talia.getOneCard(); //palenie karty
        for (int i = 0; i < 3; i++) {
            board.add(talia.getOneCard());
        }
        setHandPower();
    }

    public void makeTurnOrRiver(){
        talia.getOneCard(); //palenie karty
        board.add(talia.getOneCard());
        setHandPower();
    }





    /**
     * pobiera ante od wsszystkich graczy i dodaje je do mainPota
     * @param anteLvl
     */
    private void takeAnte (int anteLvl){
            for (Player aGracze : players) {
                if (aGracze.getStack() >= anteLvl){
                    mainPot += aGracze.subtractStack(anteLvl);
                }
            }
    }
/*
    private void takeBigBlind (int bigBlind){
        //pobieranie od gracza na pozycji bb
            if (aGracze.getStack() >= bigBlind){
                mainPot += aGracze.subtractStack(anteLvl);
            }
    }
*/

    /**
     * Ustawia aktualny najmocniejszy układ na ręce gracza
     */
    private void setHandPower(){
        for (Player aGracze : players) {
            aGracze.setHandPower(CheckHand.handPower(CheckHand.join(aGracze.getHand(),this.board)));
        }

    }

    public List<Card> getBoard() {
        return board;
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
