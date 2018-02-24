package cc.morawiec.apps.Poker;

import cc.morawiec.apps.Cards.Card;
import cc.morawiec.apps.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * klasa symuluje pojedyncze rozdanie pokerowe
 * dealerem jest zawsze ostatni gracz listy
 */
public class Deal {
    private PokerDeck talia = new PokerDeck();
    private List<Player> players;
    private List<Card> board = new ArrayList<>();

    private boolean ante;
    private int anteLevel;
    private int bigBlind;
    private int smallBlind;
    private int minimalBet; //minialny zakład


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

        this.players = playersToDeal;
        this.mainPot = 0;
        this.sidePot = 0;

        this.ante = level.isAnte();
        this.anteLevel = level.getAnte();
        this.bigBlind = level.getBigBlind();
        this.smallBlind = level.getSmallBlind();

        this.minimalBet = bigBlind;

    }

    /**
     * Sprawdza czy jest ante, true - pobiera odpowiednią ilość ante
     * pobiera smalla i biga od graczy, dealer to trzecia od tyłu pozycja players
     * Rozdaje karty wszystkim graczom
     */
    public void dealingCards(){
        if(ante) takeAnte(anteLevel);

        if (players.size()==2){ //head's up
            takeBlind(bigBlind,players.get(0));
            takeBlind(smallBlind,players.get(1));
        }
        else{ //standard game
            takeBlind(smallBlind,players.get(players.size()-2));
            takeBlind(bigBlind,players.get(players.size()-1));
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
                    mainPot += aGracze.subtractAndReturnStack(anteLvl);
                    //aGracze.setAddedToPot(anteLvl);
                }
            }
    }


    private void takeBlind (int blind, Player playerOnBlind){
            if (playerOnBlind.getStack() >= blind){
                mainPot += playerOnBlind.subtractAndReturnStack(blind);
                playerOnBlind.setAddedToPot(blind);
            }
    }



    /**
     * Ustawia aktualny najmocniejszy układ na ręce gracza
     */
    private void setHandPower(){
        for (Player aGracze : players) {
            aGracze.setHandPower(CheckHand.handPower(CheckHand.join(aGracze.getHand(),this.board)));
        }

    }

    public int getMinimalBet() {
        return minimalBet;
    }

    public void setMinimalBet(int minimalBet) {
        this.minimalBet = minimalBet;
    }

    public List<Card> getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getPlayers(int playerNumber) {
        return players.get(playerNumber-1);
    }

    public int getMainPot() {
        return mainPot;
    }

    public void addToMainPot(int mainPot) {
        this.mainPot += mainPot;

    }

    public int getSidePot() {
        return sidePot;
    }

    public int getBigBlind() {
        return bigBlind;
    }

    public int getAnteLevel() {
        return anteLevel;
    }
}
