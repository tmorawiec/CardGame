package cc.morawiec.apps;

import cc.morawiec.apps.Cards.Card;

public class Player {

    private String playerName;
    private Card[] hand;
    private int stack;

    public Player(String playerName , int stack) {
        this.playerName = playerName;
        this.stack = stack;
        this.hand = new Card[2];
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getStack() {
        return stack;
    }

    public void setStack(int stack) {
        this.stack = stack;
    }

    public Card[] getHand() {
        return hand;
    }

    public void setFirstCard(Card firstCard){
        this.hand[0] = firstCard;
    }
    public void setSecondCard(Card secondCard){
        this.hand[1] = secondCard;
    }


}
