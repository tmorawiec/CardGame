package cc.morawiec.apps;
import cc.morawiec.apps.Cards.Card;
import cc.morawiec.apps.Cards.DeckOfCards;
import cc.morawiec.apps.Poker.CheckHand;
import cc.morawiec.apps.Poker.TableSettings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException
    {

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
        System.out.println(rozgrywka.getDeal().getPlayers().get(0).getHand());
        System.out.println(CheckHand.join(rozgrywka.getDeal().getPlayers().get(0).getHand(),rozgrywka.getDeal().getBoard()));
        rozgrywka.getDeal().makeFlop();
        System.out.println(CheckHand.join(rozgrywka.getDeal().getPlayers().get(0).getHand(),rozgrywka.getDeal().getBoard()));
        rozgrywka.getDeal().makeTurnOrRiver();
        System.out.println(CheckHand.join(rozgrywka.getDeal().getPlayers().get(0).getHand(),rozgrywka.getDeal().getBoard()));
        rozgrywka.getDeal().makeTurnOrRiver();
        System.out.println(CheckHand.join(rozgrywka.getDeal().getPlayers().get(0).getHand(),rozgrywka.getDeal().getBoard()));
        System.out.println(CheckHand.join(rozgrywka.getDeal().getPlayers().get(1).getHand(),rozgrywka.getDeal().getBoard()));
        //porównanie 2 kart
        Card karta1 = rozgrywka.getDeal().getPlayers().get(0).getHand().get(0);
        Card karta2 = rozgrywka.getDeal().getPlayers().get(1).getHand().get(0);
        System.out.println(karta1.compareTo(karta2));
        //test sortowania
        ArrayList<Card> reka = CheckHand.join(rozgrywka.getDeal().getPlayers().get(1).getHand(),rozgrywka.getDeal().getBoard());
        Collections.sort(reka);
        System.out.println(reka); //działa :)

        //testowanie sprawdzania układów
        ArrayList<Card> nowareka = new ArrayList<>();
        DeckOfCards taliaprobna = new DeckOfCards();


        Card s1 = taliaprobna.getDeck().get(2);
        Card s2 = taliaprobna.getDeck().get(0);
        Card s3 = taliaprobna.getDeck().get(26);
        Card s4 = taliaprobna.getDeck().get(13);
        Card s5 = taliaprobna.getDeck().get(1);
        Card s6 = taliaprobna.getDeck().get(1);
        Card s7 = taliaprobna.getDeck().get(0);

        nowareka.add(0,s1);
        nowareka.add(1,s2);
        nowareka.add(2,s3);
        nowareka.add(3,s4);
        nowareka.add(4,s5);
        nowareka.add(5,s6);
        nowareka.add(6,s7);

        System.out.println(nowareka);

        ///
        System.out.println(CheckHand.is_straight(nowareka));
        System.out.println(CheckHand.is_straight(reka));
        System.out.println("-------");
        System.out.println("sztuczna: " + CheckHand.isOnePair(nowareka));
        System.out.println("losowa: " + CheckHand.isOnePair(reka));

        if (nowareka.get(nowareka.size()-1).getVal() == 2){
            System.out.println("dwojka");
        }
        System.out.println("----");
        System.out.println("test trojki sztuczna: " + CheckHand.isThreeOfKind(reka));
        System.out.println("test trojki sztuczna: " + CheckHand.isThreeOfKind(nowareka));













    }
    }



