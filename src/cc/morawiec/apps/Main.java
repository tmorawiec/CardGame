package cc.morawiec.apps;
import cc.morawiec.apps.Cards.DeckOfCards;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException
    {



        // tworzenie obiektu talia i wylistowanie kart
        DeckOfCards talia = new DeckOfCards();

        talia.shuffleDeck();
        talia.getDeck();
        talia.printDeck();











    }
    }



