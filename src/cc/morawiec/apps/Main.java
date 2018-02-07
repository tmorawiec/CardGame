package cc.morawiec.apps;
import cc.morawiec.apps.Cards.DeckOfCards;
import cc.morawiec.apps.Poker.PokerDeck;
import cc.morawiec.apps.Poker.Table;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException
    {
        // tworzenie obiektu talia i wylistowanie kart
        /*
        System.out.println("---------nowa talia pokerowa-----------");
        PokerDeck talia2 = new PokerDeck();
        talia2.printDeck();
        System.out.println("--------talia pokerowa potasowana--------------");
        talia2.shuffleDeck();
        talia2.printDeck();
        System.out.println("---------------------------------");
        talia2.makeQueue();
        talia2.getOneCard();
        talia2.getOneCard();
        */
        Table nowaGra = new Table();
        nowaGra.dealing2Cards(); //rozdaje po dwie karty każdemu graczowi
        nowaGra.makeFlop();
        nowaGra.makeTurn();
        nowaGra.makeRiver();
        System.out.println("----");
        nowaGra.getLista();


    }
    }



