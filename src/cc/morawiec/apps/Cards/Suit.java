package cc.morawiec.apps.Cards;

/**
 * Lista z kolorami kart
 */
public enum Suit {
    SPADES('\u2660'),
    HEARTS('\u2665'),
    DIAMONDS('\u2666'),
    CLUBS('\u2663');


    private char cardSymbol;

    Suit (char symbol)
    {
        this.cardSymbol = symbol;
    }

    public char getSymbol() {
        return cardSymbol;
    }
}
