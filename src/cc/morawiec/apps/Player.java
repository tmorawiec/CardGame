package cc.morawiec.apps;

import cc.morawiec.apps.Cards.Card;
import cc.morawiec.apps.Poker.HandRank;

import java.util.ArrayList;

public class Player {

    private String playerName;
    private ArrayList<Card> hand;
    private HandRank handName;
    private int stack;
    private boolean addon;
    private boolean rebuy;

    public Player(String playerName , int stack, boolean addon, boolean rebuy) {
        this.playerName = playerName;
        this.handName = null;
        this.stack = stack;
        this.addon = addon;
        this.rebuy = rebuy;
        this.hand = new ArrayList<Card>();
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getStack() {
        return stack;
    }

    public void addToStack(int stack) {
        this.stack += stack;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(Card card) {
        this.hand.add(card);
        //if (hand.size()>1){
        //    setHandName(x);
        //}
    }

    //ustawia i pobiera typ układu na ręce
    public HandRank getHandName() {
        return handName;
    }

    public void setHandName(HandRank handName) {
        this.handName = handName;
    }
}
