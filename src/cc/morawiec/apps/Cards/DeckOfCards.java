package cc.morawiec.apps.Cards;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class DeckOfCards {
    private List<Card> deck;

    /**
     * Constructor for making 52 pieces deck of cards with image
     */
    public DeckOfCards() throws IOException {

        deck = new ArrayList<>(); //empty deck


         // read big image with deck of cards
        BufferedImage obrazek = ImageIO.read(new File("deckimg.png"));
        BufferedImage tempObrazek;
        int subImgWidth = 62;
        int subImgHeight = 77;

         // making 52 pieces of card objects and adding it to Array: empty deck
         for (int i = 0; i < Suit.values().length; i++){
             for (int j=0; j < CardFigure.values().length; j++){
                     // cutting image
                     tempObrazek = obrazek.getSubimage(
                             j*subImgWidth + (j*11),
                             i*subImgHeight + (i*7),
                             subImgWidth,
                             subImgHeight
                     );
                     deck.add(new Card(CardFigure.values()[j],Suit.values()[i], tempObrazek));
             }
         }
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void printDeck(){
        for (Card aDeck : deck) {
            System.out.println(aDeck);
        }
    }

    public void shuffleDeck(){
        Collections.shuffle(deck);
    }


}
