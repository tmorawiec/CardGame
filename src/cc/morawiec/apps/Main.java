package cc.morawiec.apps;
import cc.morawiec.apps.Cards.Card;
import cc.morawiec.apps.Cards.DeckOfCards;
import cc.morawiec.apps.Poker.CheckHand;
import cc.morawiec.apps.Poker.TableSettings;

import java.io.IOException;
import java.util.ArrayList;

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
        System.out.println(CheckHand.join(rozgrywka.getDeal().getPlayers().get(0).getHand(),rozgrywka.getDeal().getBoard()));
        rozgrywka.getDeal().makeFlop();
        System.out.println(CheckHand.join(rozgrywka.getDeal().getPlayers().get(0).getHand(),rozgrywka.getDeal().getBoard()));
        rozgrywka.getDeal().makeTurnOrRiver();
        System.out.println(CheckHand.join(rozgrywka.getDeal().getPlayers().get(0).getHand(),rozgrywka.getDeal().getBoard()));
        rozgrywka.getDeal().makeTurnOrRiver();
        System.out.println(CheckHand.join(rozgrywka.getDeal().getPlayers().get(0).getHand(),rozgrywka.getDeal().getBoard()));
        System.out.println("test sortowania");



        ArrayList<Card> reka0 = CheckHand.join(rozgrywka.getDeal().getPlayers().get(0).getHand(),rozgrywka.getDeal().getBoard());
        ArrayList<Card> reka1 = CheckHand.join(rozgrywka.getDeal().getPlayers().get(1).getHand(),rozgrywka.getDeal().getBoard());
        ArrayList<Card> reka2 = CheckHand.join(rozgrywka.getDeal().getPlayers().get(2).getHand(),rozgrywka.getDeal().getBoard());
        ArrayList<Card> reka3 = CheckHand.join(rozgrywka.getDeal().getPlayers().get(3).getHand(),rozgrywka.getDeal().getBoard());
        ArrayList<Card> reka4 = CheckHand.join(rozgrywka.getDeal().getPlayers().get(4).getHand(),rozgrywka.getDeal().getBoard());



        System.out.println("----------");

        System.out.println("Lista rąk");
        System.out.println(reka0);
        System.out.println(reka1);
        System.out.println(reka2);
        System.out.println(reka3);
        System.out.println(reka4);
        System.out.println("Test układu:");
        System.out.println(rozgrywka.handPower(reka0));
        System.out.println(rozgrywka.handPower(reka1));
        System.out.println(rozgrywka.handPower(reka2));
        System.out.println(rozgrywka.handPower(reka3));
        System.out.println(rozgrywka.handPower(reka4));
        System.out.println("Lista rąk");
        System.out.println(reka0);
        System.out.println(reka1);
        System.out.println(reka2);
        System.out.println(reka3);
        System.out.println(reka4);


        //testowanie sprawdzania układów
        ArrayList<Card> nowareka = new ArrayList<>();
        DeckOfCards taliaprobna = new DeckOfCards();


        Card s1 = taliaprobna.getDeck().get(12);
        Card s2 = taliaprobna.getDeck().get(11);
        Card s3 = taliaprobna.getDeck().get(10);
        Card s4 = taliaprobna.getDeck().get(9);
        Card s5 = taliaprobna.getDeck().get(8);
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
        System.out.println("test strita");
        System.out.println(CheckHand.isPoker(nowareka));

        /*
        System.out.println(CheckHand.isStraight(reka));
        System.out.println("-------");
        System.out.println("sztuczna: " + CheckHand.isOnePair(nowareka));
        System.out.println("losowa: " + CheckHand.isOnePair(reka));

        if (nowareka.get(nowareka.size()-1).getVal() == 2){
            System.out.println("dwojka");
        }
        System.out.println("----");
        System.out.println("test trojki losowa: " + CheckHand.isThreeOfKind(reka));
        System.out.println("test trojki sztuczna: " + CheckHand.isThreeOfKind(nowareka));
        System.out.println("----");
        System.out.println("test karety losowa: " + CheckHand.isQuads(reka));
        System.out.println("test karety sztuczna: " + CheckHand.isQuads(nowareka));
        System.out.println("----");
        System.out.println("test fula losowa: " + CheckHand.isFullhouse(reka));
        System.out.println("test fula sztuczna: " + CheckHand.isFullhouse(nowareka));


*/









    }
    }



