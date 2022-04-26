package de.materna.candylord;

import java.util.List;

public class GameManager {
    public int gameRounds = 30;
    public int startCash = 2000;
    public int startDebt = 0;
    public int capacity = 100;
    public double bankInterest = 0.05;
    public double debtInterest = 0.1;
    public boolean continueGame = true;
    public double costsPerKilometer = 0.15;

    public String randomCity(){
        double random = Math.random();
        if ( random < 0.166 ) return CityENUM.HAMBURG.toString();
        if ( random < 0.333 ) return CityENUM.COLOGNE.toString();
        if ( random < 0.5 ) return CityENUM.BERLIN.toString();
        if ( random < 0.666 ) return CityENUM.MUNICH.toString();
        if ( random < 0.833 ) return CityENUM.FRANKFURT.toString();
        return CityENUM.STUTTGART.toString();
    }


}
