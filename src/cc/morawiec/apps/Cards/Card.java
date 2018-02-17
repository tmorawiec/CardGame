package cc.morawiec.apps.Cards;

import java.awt.image.BufferedImage;
import java.util.Comparator;

public class Card implements Comparable<Card>{
    private CardFigure figura;
    private Suit kolor;
    private BufferedImage cardImage;

    /**
     * The constructor for the Card class
     * @param cardImage = a bufferedImage that represents the card
     */
    public Card(CardFigure figura, Suit kolor, BufferedImage cardImage) {
        this.figura = figura;
        this.kolor = kolor;
        this.cardImage = cardImage;
    }

    @Override
    public String toString() {
        return this.getFigura() +" of "+ this.getKolor();
    }

    public BufferedImage getCardImage() {
        return cardImage;
    }

    public CardFigure getFigura() {
        return figura;
    }

    public Suit getKolor() {
        return kolor;
    }
    public int getVal() {
        return figura.getCardValue();
    }

    /**
     * Nadpisana metoda porównująca 2 karty wykorzystywana w sortowaniu wg wartosci karty
     * @param o karta do której chcemy porównywać
     * @return 0 jeśli są takie same, wartości minusowe jeśli ...
     */

    @Override
    public int compareTo(Card o) {
        return o.figura.getCardValue() - this.figura.getCardValue();
    }


    public static Comparator<Card> suitComparator = new Comparator<Card>() {
        @Override
        public int compare(Card c1, Card c2) {
            return (int) (c1.getKolor().compareTo(c2.getKolor()));
        }
    };

    public static Comparator<Card> figureComparator = new Comparator<Card>() {
        @Override
        public int compare(Card c1, Card c2) {
            return (Integer.compare(c2.getVal(), c1.getVal()));
        }
    };


}
