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
        System.out.println("Ilość graczy: " + nowaGra.getGracze().length);
        nowaGra.dealingCards(); //rozdaje karty każdemu graczowi

        System.out.println("---Karty gracza 1:");
        System.out.println(nowaGra.getGracze()[0].getHand().get(0));
        System.out.println(nowaGra.getGracze()[0].getHand().get(1));
        System.out.println("-------");

        System.out.println("------po flopie");
        nowaGra.makeFlop();
        nowaGra.getLista();

        System.out.println("------po turnie:");
        nowaGra.makeTurnOrRiver();
        nowaGra.getLista();

        System.out.println("------po riverze");
        nowaGra.makeTurnOrRiver();
        nowaGra.getLista();

        System.out.println("---Karty gracza 1:");
        System.out.println(nowaGra.getGracze()[0].getHand().get(0));
        System.out.println(nowaGra.getGracze()[0].getHand().get(1));

        System.out.println("-------");


    }
    }



