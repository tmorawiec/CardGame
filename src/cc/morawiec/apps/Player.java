package cc.morawiec.apps;

import cc.morawiec.apps.Cards.Card;

public class Player {

    private static int numberOfplayers=0;
    private String playerName;
    private Card[] hand;

    public Player(String playerName) {
        this.playerName = playerName; //dodać kontrolę nazw
        this.hand = new Card[2];
        numberOfplayers++;
    }

    public static int getNumberOfplayers() {
        return numberOfplayers;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Card[] getHand() {
        return hand;
    }

    public void setHand(Card[] hand) {
        this.hand = hand;
    }
}
