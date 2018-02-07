package cc.morawiec.apps.Poker;

/**
 * Lista układów pokerowych
 */
public enum HandRank {
    HIGH_CARD (1),
    ONE_PAIR (2),
    TWO_PAIR (3),
    THREE_OF_KIND (4),
    STRAIGHT (5),
    FLUSH (6),
    FULL_HOUSE (7),
    QUADS (8),
    POKER (9),
    ROYAL_FLUSH (10);

    private int handValue;

    private HandRank (int value)
    {
        this.handValue = value;
    }

    public int getCardValue() {
        return handValue;
    }
}
