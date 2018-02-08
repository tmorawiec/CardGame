package cc.morawiec.apps.Poker;

import cc.morawiec.apps.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa symuluje stół pokerowy
 */
public class TableSettings {

    final private int buyin;        //kwota wejścia do gry
    private boolean addon;          //czy odowiązują addony
    private boolean rebuy;          //czy obowiązują rebuy'e
    private int level;              //runda
    private List<Player> seats;     //miejsca przy stole
    private int seatsLimit;         //limit miejsc
    private Deal deal;              //rozdanie

    public TableSettings(int buyin, boolean addon, boolean rebuy) {
        this.buyin = buyin;
        this.addon = addon;
        this.rebuy = rebuy;
        this.level = 1;
        this.seatsLimit = 10;
        this.seats = new ArrayList<Player>();
    }

    public void dealIt() throws IOException {
        Deal noweRozdanie = new Deal(seats);
        this.deal = noweRozdanie;
    }

    public Deal getDeal() {
        return this.deal;
    }

    /**
     * Tworzy ArrayList z rządaną ilością graczy dodaje automatycznie nazwy graczy
     * @param howManyPlayers ilość graczy
     */
    public void makePlayers(int howManyPlayers){
        if ((howManyPlayers>=2)&&(howManyPlayers<=this.seatsLimit)){
            for (int i=0; i<howManyPlayers ; i++){
                String name = "Gracz "+(Integer.toString(i+1));
                Player nowygracz = new Player(name,this.buyin);
                this.seats.add(nowygracz);
            }
        }
    }

    /**
     * Dodaje nowego gracza do stołu sprawdza czy nie przekroczono limitu miejsc
     * @param newPlayer nowy gracz
     */
    public void addNewPlayer(Player newPlayer) {
        if (seats.size()<seatsLimit){
            seats.add(newPlayer);
        }
    }

    public List<Player> getSeats() {
        return seats;
    }

    public int getLevel() {
        return level;
    }

    public void nextLevel() {
        this.level += 1;
    }


    /**
     * Wylicza średni stack przy stole
     * @return średni stack przy stole
     */
    public int getAvgStack(){
        int sumStack = 0;
        for (int i = 0; i < seats.size(); i++) {
            sumStack += seats.get(0).getStack();
        }
        int avgStack = sumStack/seats.size();
        return avgStack;
    }


}