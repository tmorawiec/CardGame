package cc.morawiec.apps;
import cc.morawiec.apps.Poker.TableSettings;

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

        Deal nowaGra = new Deal();
        System.out.println("Ilość graczy: " + nowaGra.getPlayers().length);
        nowaGra.dealingCards(); //rozdaje karty każdemu graczowi

        System.out.println("---Karty gracza 1:");
        System.out.println(nowaGra.getPlayers()[0].getHand());
        System.out.println("-------");

        System.out.println("------po flopie");
        nowaGra.makeFlop();
        nowaGra.getBoard();

        System.out.println("------po turnie:");
        nowaGra.makeTurnOrRiver();
        nowaGra.getBoard();

        System.out.println("------po riverze");
        nowaGra.makeTurnOrRiver();
        nowaGra.getBoard();

        System.out.println("---Karty gracza 1:");
        System.out.println(nowaGra.getPlayers()[0].getHand().get(0));
        System.out.println(nowaGra.getPlayers()[0].getHand().get(1));
        */

        System.out.println("-------");
        System.out.println("tworzę obiekt stół:");

        TableSettings rozgrywka = new TableSettings(5000,false,false);
        rozgrywka.makePlayers(5);
        rozgrywka.dealIt();
        System.out.println("Sredni stack na stole: " + rozgrywka.getAvgStack());

        System.out.println(rozgrywka.getSeats().get(0).getPlayerName()); //imie gracza na poziomie całej gry
        System.out.println(rozgrywka.getSeats().get(0));                 //nazwa obiektu gracza



        rozgrywka.dealIt();
        rozgrywka.getDeal().dealingCards();
        rozgrywka.getDeal().makeFlop();
        rozgrywka.getDeal().makeTurnOrRiver();
        rozgrywka.getDeal().makeTurnOrRiver();

        System.out.println(rozgrywka.getDeal().getBoard());

        System.out.println(rozgrywka.getDeal().getPlayers().get(0).getHand());

        System.out.println(rozgrywka.getDeal().getPlayers());





    }
    }



