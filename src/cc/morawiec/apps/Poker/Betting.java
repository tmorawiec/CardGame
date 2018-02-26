package cc.morawiec.apps.Poker;

import cc.morawiec.apps.Player;

public final class Betting {

    private Betting() {}

    /**
     * Zagranie za wszystkie żetony
     * @param player
     * @param actualDeal
     */
    public static void allIn(Player player, Deal actualDeal){
        actualDeal.addToMainPot(player.subtractAndReturnStack(player.getStack()));
        if (actualDeal.getMinimalBet() < player.getStack())
        actualDeal.setMinimalBet(player.getStack());

    }

    /**
     * dodanie żetonu do puli
     * @param player
     * @param actualDeal
     * @param rise
     */
    public static void bet(Player player, Deal actualDeal, int rise){
        if ((rise > actualDeal.getMinimalBet()) && (rise % actualDeal.getBigBlind() == 0))
            actualDeal.addToMainPot(player.subtractAndReturnStack(rise));
            actualDeal.setMinimalBet(rise);
            player.setAddedToPot(rise);
    }

    /**
     * zewiększenie poprzedniego podbicia
     * @param player
     * @param actualDeal
     * @param rise
     */
    public static void rise(Player player, Deal actualDeal, int rise){
        if (player.getStack() >= rise && ((rise > actualDeal.getMinimalBet()) && (rise % actualDeal.getBigBlind() == 0))){
            actualDeal.addToMainPot(player.subtractAndReturnStack(rise));
            actualDeal.setMinimalBet(rise+player.getAddedToPot());
            player.setAddedToPot(rise);
        }
            else System.out.println("nieprawidłowe podbicie");
    }

    /**
     * sprawdzenie za tyle ile wyniosło podbicie albo check
     * @param player
     * @param actualDeal
     */
    public static void call(Player player, Deal actualDeal){
        actualDeal.addToMainPot(player.subtractAndReturnStack(actualDeal.getMinimalBet()-player.getAddedToPot()));
        player.setAddedToPot(actualDeal.getMinimalBet()-player.getAddedToPot());
    }

    /**
     * poddanie licytacji
     */
    public static void fold(Player player, Deal actualDeal){
        actualDeal.getPlayers().remove(player);
    }
}
