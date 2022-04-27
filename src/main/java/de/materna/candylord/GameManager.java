package de.materna.candylord;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    List<Price> prices = new ArrayList<>();
    public int gameRounds;
    public int startCash;
    public int startDebt;
    public int playerCapacity;
    public double bankInterest;
    public double debtInterest;
    public boolean continueGame;
    public double costsPerKilometer;

    public GameManager(int gameRounds, int startCash, int startDebt, int playerCapacity, double bankInterest, double debtInterest, boolean continueGame, double costsPerKilometer) {
        this.gameRounds = gameRounds;
        this.startCash = startCash;
        this.startDebt = startDebt;
        this.playerCapacity = playerCapacity;
        this.bankInterest = bankInterest;
        this.debtInterest = debtInterest;
        this.continueGame = continueGame;
        this.costsPerKilometer = costsPerKilometer;
        createEconomy();
    }

    public String randomCity(){
        double random = Math.random();
        if ( random < 0.166 ) return CityENUM.HAMBURG.toString();
        if ( random < 0.333 ) return CityENUM.COLOGNE.toString();
        if ( random < 0.5 ) return CityENUM.BERLIN.toString();
        if ( random < 0.666 ) return CityENUM.MUNICH.toString();
        if ( random < 0.833 ) return CityENUM.FRANKFURT.toString();
        return CityENUM.STUTTGART.toString();
    }

    public void createEconomy(){
        prices.add(new Price(15000, 30000, "Candy1"));
        prices.add(new Price(5000, 14000, "Candy2"));
        prices.add(new Price(1000, 4500, "Candy3"));
        prices.add(new Price(300, 900, "Candy4"));
        prices.add(new Price(70, 250, "Candy5"));
        prices.add(new Price(10, 60, "Candy6"));
    }
}
