package cc.morawiec.apps;
import cc.morawiec.apps.Cards.Card;
import cc.morawiec.apps.Cards.DeckOfCards;
import cc.morawiec.apps.Poker.Betting;
import cc.morawiec.apps.Poker.CheckHand;
import cc.morawiec.apps.Poker.Gameplay;
import cc.morawiec.apps.Poker.TableSettings;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException
    {
        Gameplay game = new Gameplay();
        game.play();

        /*
        System.out.println("-------");
        System.out.println("tworzę obiekt stół:");

        TableSettings rozgrywka = new TableSettings(5000,false,false);
        rozgrywka.makePlayers(5);

        System.out.println("Sredni stack na stole: " + rozgrywka.getAvgStack());

        System.out.println(rozgrywka.getSeats().get(0).getPlayerName()); //imie gracza na poziomie całej gry
        System.out.println(rozgrywka.getSeats().get(0));                 //nazwa obiektu gracza



        rozgrywka.dealIt(); //tworzy rozdanie
        System.out.println(rozgrywka.getDeal().getPlayers().get(0).getStack());
        System.out.println(rozgrywka.getDeal().getMainPot());


        rozgrywka.getDeal().dealingCards();
        System.out.println("stack gracza 1 po rozdaniu: " + rozgrywka.getDeal().getPlayers().get(0).getStack());
        System.out.println("stack gracza 2 po rozdaniu: " + rozgrywka.getDeal().getPlayers().get(1).getStack());
        System.out.println("stack gracza 3 po rozdaniu: " + rozgrywka.getDeal().getPlayers().get(2).getStack());
        System.out.println("stack gracza 4 po rozdaniu: " + rozgrywka.getDeal().getPlayers().get(3).getStack());
        System.out.println("stack gracza 5 po rozdaniu: " + rozgrywka.getDeal().getPlayers().get(4).getStack());

        System.out.println("Pot: " + rozgrywka.getDeal().getMainPot());

        //////////
        Betting.rise(rozgrywka.getDeal().getPlayers(3),rozgrywka.getDeal(),600);
        System.out.println("po podbiciu:");
        System.out.println("stack gracza 3: " + rozgrywka.getDeal().getPlayers(3).getStack());
        System.out.println("Pot: " + rozgrywka.getDeal().getMainPot());
        System.out.println(rozgrywka.getDeal().getPlayers(3).getAddedToPot());
        System.out.println("--------------");
///////

        Betting.call(rozgrywka.getDeal().getPlayers(3),rozgrywka.getDeal());
        System.out.println("po callu:");
        System.out.println("stack gracza 3: " + rozgrywka.getDeal().getPlayers(3).getStack());
        System.out.println("Pot: " + rozgrywka.getDeal().getMainPot());
        System.out.println(rozgrywka.getDeal().getPlayers(3).getAddedToPot());
        System.out.println("--------------");

        Betting.call(rozgrywka.getDeal().getPlayers(4),rozgrywka.getDeal());
        System.out.println("po callu:");
        System.out.println("stack gracza 4: " + rozgrywka.getDeal().getPlayers(4).getStack());
        System.out.println("Pot: " + rozgrywka.getDeal().getMainPot());
        System.out.println(rozgrywka.getDeal().getPlayers(4).getAddedToPot());
        System.out.println("--------------");

        Betting.call(rozgrywka.getDeal().getPlayers(5),rozgrywka.getDeal());
        System.out.println("po callu:");
        System.out.println("stack gracza 5: " + rozgrywka.getDeal().getPlayers(5).getStack());
        System.out.println("Pot: " + rozgrywka.getDeal().getMainPot());
        System.out.println(rozgrywka.getDeal().getPlayers(5).getAddedToPot());
        System.out.println("--------------");

        Betting.call(rozgrywka.getDeal().getPlayers(1),rozgrywka.getDeal());
        System.out.println("po callu:");
        System.out.println("stack gracza 1: " + rozgrywka.getDeal().getPlayers(1).getStack());
        System.out.println("Pot: " + rozgrywka.getDeal().getMainPot());
        System.out.println(rozgrywka.getDeal().getPlayers(1).getAddedToPot());
        System.out.println("--------------");

        Betting.call(rozgrywka.getDeal().getPlayers(2),rozgrywka.getDeal());
        System.out.println("po callu:");
        System.out.println("stack gracza 2: " + rozgrywka.getDeal().getPlayers(2).getStack());
        System.out.println("Pot: " + rozgrywka.getDeal().getMainPot());
        System.out.println(rozgrywka.getDeal().getPlayers(2).getAddedToPot());
        System.out.println("--------------");



        System.out.println(rozgrywka.getDeal().getPlayers().get(0).getHandPower());
        System.out.println(CheckHand.join(rozgrywka.getDeal().getPlayers().get(0).getHand(),rozgrywka.getDeal().getBoard()));
        rozgrywka.getDeal().makeFlop();
        System.out.println(rozgrywka.getDeal().getPlayers().get(0).getHandPower());
        System.out.println(CheckHand.join(rozgrywka.getDeal().getPlayers().get(0).getHand(),rozgrywka.getDeal().getBoard()));
        rozgrywka.getDeal().makeTurnOrRiver();
        System.out.println(rozgrywka.getDeal().getPlayers().get(0).getHandPower());
        System.out.println(CheckHand.join(rozgrywka.getDeal().getPlayers().get(0).getHand(),rozgrywka.getDeal().getBoard()));
        rozgrywka.getDeal().makeTurnOrRiver();
        System.out.println(rozgrywka.getDeal().getPlayers().get(0).getHandPower());
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

        System.out.println(CheckHand.handPower(reka0));
        System.out.println(CheckHand.handPower(reka1));
        System.out.println(CheckHand.handPower(reka2));
        System.out.println(CheckHand.handPower(reka3));
        System.out.println(CheckHand.handPower(reka4));
        System.out.println("Lista rąk");
        System.out.println(reka0);
        System.out.println(reka1);
        System.out.println(reka2);
        System.out.println(reka3);
        System.out.println(reka4);


        //testowanie sprawdzania układów
        ArrayList<Card> nowareka = new ArrayList<>();
        DeckOfCards taliaprobna = new DeckOfCards();


        Card s1 = taliaprobna.getDeck().get(38);
        Card s2 = taliaprobna.getDeck().get(31);
        Card s3 = taliaprobna.getDeck().get(18);
        Card s4 = taliaprobna.getDeck().get(34);
        Card s5 = taliaprobna.getDeck().get(35);
        Card s6 = taliaprobna.getDeck().get(36);
        Card s7 = taliaprobna.getDeck().get(37);

        nowareka.add(0,s1);
        nowareka.add(1,s2);
        nowareka.add(2,s3);
        nowareka.add(3,s4);
        nowareka.add(4,s5);
        nowareka.add(5,s6);
        nowareka.add(6,s7);

        System.out.println("test PokeraKrólewskego:");
        System.out.println(nowareka);

        ///
        System.out.println("po teście");
        System.out.println(CheckHand.isRoyalFlush(nowareka));
        System.out.println(nowareka);

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



