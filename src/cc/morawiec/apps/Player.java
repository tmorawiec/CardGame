package cc.morawiec.apps;

import cc.morawiec.apps.Cards.Card;
import cc.morawiec.apps.Poker.HandRank;

import java.util.ArrayList;

public class Player {

    private String playerName;
    private ArrayList<Card> hand;
    private HandRank handPower;
    private int addedToPot;
    private int kicker;
    private int stack;
    private boolean addon;
    private boolean rebuy;

    public Player(String playerName , int stack, boolean addon, boolean rebuy) {
        this.playerName = playerName;
        this.handPower = null;
        this.kicker = 0;
        this.addedToPot = 0;
        this.stack = stack;
        this.addon = addon;
        this.rebuy = rebuy;
        this.hand = new ArrayList<>();
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getStack() {
        return stack;
    }

    public void addStack(int stack) {
        this.stack += stack;
    }

    public int subtractAndReturnStack(int stack) {
        this.stack -= stack;
        return stack;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(Card card) {
        this.hand.add(card);
    }

    //ustawia i pobiera typ układu na ręce
    public HandRank getHandPower() {
        return handPower;
    }

    public void setHandPower(HandRank handPower) {
        this.handPower = handPower;
    }

    public int getAddedToPot() {
        return addedToPot;
    }

    public void setAddedToPot(int addedToPot) {
        this.addedToPot += addedToPot;
    }
}
