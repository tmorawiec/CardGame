package cc.morawiec.apps;

import cc.morawiec.apps.Cards.Card;

import java.util.ArrayList;

public class Player {

    private String playerName;
    private ArrayList<Card> hand;
    private int stack;

    public Player(String playerName , int stack) {
        this.playerName = playerName;
        this.stack = stack;
        this.hand = new ArrayList<Card>();
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

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(Card card) {
        this.hand.add(card);
    }

}
