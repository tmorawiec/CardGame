package cc.morawiec.apps.Poker;

import cc.morawiec.apps.Player;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Gameplay in commandline
 */
public class Gameplay {

    private TableSettings gameplay;
    private Scanner in;
    private int queue;
    private int playersInGame = 0;
    private int playersInGameStack = 0;

    public Gameplay() throws IOException {

        in = new Scanner(System.in);
        System.out.println("Welcome in POKER ROOM \nHow many players?");
        int players = in.nextInt();
        System.out.println("Buy-in:");
        int buyin = in.nextInt();
        /*
        System.out.println("Do you want addons?");
        boolean addons = in.nextBoolean();
        System.out.println("Do you want rebuys?");
        boolean rebuys = in.nextBoolean();
        */
        System.out.println("Great! Let's play!");

        gameplay = new TableSettings(buyin,true,true);
        gameplay.makePlayers(players);


    }

    public void gameStats(Player aPlayer){
        int toCall = gameplay.getDeal().getMinimalBet()-aPlayer.getAddedToPot();
        System.out.println("----------------");
        System.out.println("AVG Stack: " + gameplay.getAvgStack());
        System.out.println("Main Pot: " + gameplay.getDeal().getMainPot());
        System.out.println("Level info: " + gameplay.getLevel());
        System.out.println("Players: " + gameplay.getSeats().size());
        System.out.println("Minimal to call: " + toCall);
        System.out.println("Najwiekszy zaklad: " + gameplay.getDeal().getMinimalBet());
        System.out.println("Gracze w licytacji: " + getPlayersInGame());
        System.out.println("Stack w puli grających nie foldowanych: " + getPlayersInGameStack());
        System.out.println("----------------");
    }

    public void playersStat(){
        for (int i = 0; i < gameplay.getSeats().size(); i++) {
            System.out.println(
                    gameplay.getDeal().getPlayers(i+1).getPlayerName() +
                            gameplay.getDeal().getPlayers(i+1).getHand() +
                            gameplay.getDeal().getPlayers(i+1).getStack() +
                            gameplay.getDeal().getPlayers(i+1).isFolded()
            );

        }
    }

    public void bidding(){
        petlado:
        do{
        for (int i = 0; i < gameplay.getDeal().getPlayers().size(); i++) {
            if (!gameplay.getDeal().getPlayers().get(i).isFolded()) { // sprawdza czy nie foldowal

                if ((queue > 0) && (gameplay.getDeal().getMinimalBet() - gameplay.getDeal().getPlayers().get(i).getAddedToPot() == 0)) {
                   break petlado;
                 }

                setPlayersInGame();
                playersStat();
                gameStats(gameplay.getDeal().getPlayers().get(i));

                System.out.println(
                        gameplay.getDeal().getPlayers().get(i).getPlayerName() +
                                "// 1 - call, 2 - rise, default - fold"
                );

                int input = in.nextInt();
                switch (input) {
                    case 1:
                        Betting.call(gameplay.getDeal().getPlayers().get(i), gameplay.getDeal());
                        break;
                    case 2:
                        System.out.println("How many coins?");
                        int rise = in.nextInt();
                        Betting.rise(gameplay.getDeal().getPlayers().get(i), gameplay.getDeal(), rise);
                        break;
                    default: //fold
                        System.out.println("player " + gameplay.getDeal().getPlayers().get(i).getPlayerName() + " folded");
                        gameplay.getDeal().getPlayers().get(i).setFolded(true);
                        //Betting.fold(gameplay.getDeal().getPlayers().get(i), gameplay.getDeal());
                        //i--;

                }
            }
        }
        queue++;
    } while (getPlayersInGameStack()/getPlayersInGame() != gameplay.getDeal().getMinimalBet());
    }

    public void setPlayersInGame(){
        //licznik graczy w grze
        playersInGame = 0;
        playersInGameStack = 0;
        for (int i = 0; i < gameplay.getDeal().getPlayers().size(); i++) {
            if (!gameplay.getDeal().getPlayers().get(i).isFolded())
                playersInGame++;
                playersInGameStack += gameplay.getDeal().getPlayers().get(i).getAddedToPot();
        }
    }

    public int getPlayersInGame() {
        return playersInGame;
    }

    public int getPlayersInGameStack() {
        return playersInGameStack;
    }

    public void play() throws IOException {

            gameplay.dealIt(); //nowe rozdanie
            gameplay.getDeal().dealingCards();



                bidding();



        // while ((gameplay.getDeal().getMainPot()/gameplay.getDeal().getPlayers().size()) != (gameplay.getDeal().getMinimalBet()+gameplay.getDeal().getAnteLevel()))
        gameplay.getDeal().makeFlop();
        System.out.println(gameplay.getDeal().getBoard());


    }


}
