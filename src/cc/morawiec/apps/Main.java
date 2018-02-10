package cc.morawiec.apps;
import cc.morawiec.apps.Cards.Card;
import cc.morawiec.apps.Poker.CheckHand;
import cc.morawiec.apps.Poker.TableSettings;

import java.io.IOException;

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











    }
    }



