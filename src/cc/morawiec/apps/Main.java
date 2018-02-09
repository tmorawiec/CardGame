package cc.morawiec.apps;
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
        rozgrywka.getDeal().makeFlop();
        rozgrywka.getDeal().makeTurnOrRiver();
        rozgrywka.getDeal().makeTurnOrRiver();



        System.out.println(rozgrywka.getDeal().getPlayers().get(0).getHand());

        System.out.println(rozgrywka.getDeal().getPlayers());

        System.out.println("----");
        System.out.println(CheckHand.check(rozgrywka.getDeal().getPlayers().get(0).getHand(),rozgrywka.getDeal().getBoard()));





    }
    }



