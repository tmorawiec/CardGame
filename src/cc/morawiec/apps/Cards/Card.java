package cc.morawiec.apps.Cards;

import java.awt.image.BufferedImage;

public class Card {
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

}
