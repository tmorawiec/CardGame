package cc.morawiec.apps.Cards;

/**
 * Lista z wartościami kart
 */
public enum CardFigure
{
    TWO(2,"2"),
    THREE(3,"3"),
    FOUR(4,"4"),
    FIVE(5,"5"),
    SIX(6,"6"),
    SEVEN(7,"7"),
    EIGHT(8,"8"),
    NINE(9,"9"),
    TEN(10,"10"),
    JACK(11,"J"),
    QUEEN(12,"Q"),
    KING(13,"K"),
    ACE(14,"A");

    private int cardValue;
    private String shortName;

    CardFigure (int value, String s)
    {
        this.cardValue = value;
        this.shortName = s;
    }

    public int getCardValue() {
        return cardValue;
    }

    public String getShortName() {
        return shortName;
    }
}
