package de.materna.candylord;

import java.util.Scanner;

public class CandyLordGame {
    GameManager currentGame = new GameManager();
    CityENUM cityENUM1 = CityENUM.HAMBURG;
    CityENUM cityENUM2 = CityENUM.COLOGNE;
    CityENUM cityENUM3 = CityENUM.BERLIN;
    CityENUM cityENUM4 = CityENUM.MUNICH;
    CityENUM cityENUM5 = CityENUM.FRANKFURT;
    CityENUM cityENUM6 = CityENUM.STUTTGART;
    private String randomCity(){
        double random = Math.random();
        if ( random < 0.166 ) return cityENUM1.toString();
        if ( random < 0.333 ) return cityENUM2.toString();
        if ( random < 0.5 ) return cityENUM3.toString();
        if ( random < 0.666 ) return cityENUM4.toString();
        if ( random < 0.833 ) return cityENUM5.toString();
        return cityENUM6.toString();
    }

    Player currentPlayer = new Player(currentGame.startCash, currentGame.startDebt, currentGame.capacity, randomCity());
    GameEconomy currentEconomy = new GameEconomy();

    public void startGame(){
            while(currentGame.continueGame){
                System.out.println("Round: " + currentGame.gameRounds);
                System.out.println("Current Location: " + currentPlayer.location);
                System.out.println("Current Cash: " + currentPlayer.cash + "€" +" Current Debt: " + currentPlayer.debt + "€");
                System.out.println("Current Capacity: " + currentPlayer.capacity);
                System.out.println("Current Amount " + currentPlayer.candy1.name + ": " + currentPlayer.candy1.quantity);
                System.out.println("Current Amount " + currentPlayer.candy1.name + ": " + currentPlayer.candy2.quantity);
                System.out.println("Current Amount " + currentPlayer.candy3.name + ": " + currentPlayer.candy3.quantity);
                System.out.println("Current Amount " + currentPlayer.candy4.name + ": " + currentPlayer.candy4.quantity);
                System.out.println("Current Amount " + currentPlayer.candy5.name + ": " + currentPlayer.candy5.quantity);
                System.out.println("Current Amount " + currentPlayer.candy6.name + ": " + currentPlayer.candy6.quantity);
                System.out.println("----------------------------------------");
                System.out.println("Price Candy1: " + currentEconomy.getPriceCandy1()+ "€");
                System.out.println("Price Candy2: " + currentEconomy.getPriceCandy2()+ "€");
                System.out.println("Price Candy3: " + currentEconomy.getPriceCandy3()+ "€");
                System.out.println("Price Candy4: " + currentEconomy.getPriceCandy4()+ "€");
                System.out.println("Price Candy5: " + currentEconomy.getPriceCandy5()+ "€");
                System.out.println("Price Candy6: " + currentEconomy.getPriceCandy6()+ "€");
                System.out.println("----------------------------------------");
                System.out.println("Price " + cityENUM1 + ": " + GameUtils.getTravelCost(currentPlayer.location, cityENUM1, currentGame) + "€");
                System.out.println("Price " + cityENUM2 + ": " + GameUtils.getTravelCost(currentPlayer.location, cityENUM2, currentGame) + "€");
                System.out.println("Price " + cityENUM3 + ": " + GameUtils.getTravelCost(currentPlayer.location, cityENUM3, currentGame) + "€");
                System.out.println("Price " + cityENUM4 + ": " + GameUtils.getTravelCost(currentPlayer.location, cityENUM4, currentGame) + "€");
                System.out.println("Price " + cityENUM5 + ": " + GameUtils.getTravelCost(currentPlayer.location, cityENUM5, currentGame) + "€");
                System.out.println("Price " + cityENUM6 + ": " + GameUtils.getTravelCost(currentPlayer.location, cityENUM6, currentGame) + "€");
                System.out.println("----------------------------------------");
                System.out.println("List of possible plans - Q=quit; B=buy; S=sell; J=travel; L=loan");
                if(currentPlayer.cash <= 0){
                    currentGame.continueGame = false;
                    System.out.println("You're out of money.");
                }
                if(currentGame.gameRounds <= 0){
                    currentGame.continueGame = false;
                    System.out.println("----------------------------------------");
                    System.out.println("Game is over. Time to draw a conclusion");
                    System.out.println("----------------------------------------");
                    System.out.println("You've reached: " + (currentPlayer.cash - currentPlayer.debt) + " cash" );
                }
                currentEconomy = new GameEconomy();
                nextAction();
                currentGame.gameRounds --;

            }

        };

    private void nextAction(){
        Scanner scan = new Scanner(System.in);
        String input = scan.next();

        switch (input.toLowerCase()) {
            case "q" -> quitAction();
            case "b" -> buyAction();
            case "s" -> sellAction();
            case "j" -> moveAction();
            case "l" -> System.out.println("Spieler möchte Cash leihen");
            default -> System.out.println("Bitte mache eine reguläre Eingabe");
        }

    };

    void quitAction(){
        System.exit(0);
    }

    void buyAction(){
        System.out.println("Which candy you wanna buy?");
        System.out.println("Press (1) Candy1");
        System.out.println("Press (2) Candy2");
        System.out.println("Press (3) Candy3");
        System.out.println("Press (4) Candy4");
        System.out.println("Press (5) Candy5");
        System.out.println("Press (6) Candy6");
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();


        switch (input) {
            case 1 -> currentPlayer.buyCandy(currentPlayer.candy1, currentEconomy.getPriceCandy1());
            case 2 -> currentPlayer.buyCandy(currentPlayer.candy2, currentEconomy.getPriceCandy2());
            case 3 -> currentPlayer.buyCandy(currentPlayer.candy3, currentEconomy.getPriceCandy3());
            case 4 -> currentPlayer.buyCandy(currentPlayer.candy4, currentEconomy.getPriceCandy4());
            case 5 -> currentPlayer.buyCandy(currentPlayer.candy5, currentEconomy.getPriceCandy5());
            case 6 -> currentPlayer.buyCandy(currentPlayer.candy6, currentEconomy.getPriceCandy6());
            default -> {
                break;
            }
        }
    }

    void sellAction(){
        System.out.println("Which candy you wanna sell?");
        System.out.println("Press (1) Candy1");
        System.out.println("Press (2) Candy2");
        System.out.println("Press (3) Candy3");
        System.out.println("Press (4) Candy4");
        System.out.println("Press (5) Candy5");
        System.out.println("Press (6) Candy6");
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        switch (input) {
            case 1 -> currentPlayer.sellCandy(currentPlayer.candy1, currentEconomy.getPriceCandy1());
            case 2 -> currentPlayer.sellCandy(currentPlayer.candy2, currentEconomy.getPriceCandy2());
            case 3 -> currentPlayer.sellCandy(currentPlayer.candy3, currentEconomy.getPriceCandy3());
            case 4 -> currentPlayer.sellCandy(currentPlayer.candy4, currentEconomy.getPriceCandy4());
            case 5 -> currentPlayer.sellCandy(currentPlayer.candy5, currentEconomy.getPriceCandy5());
            case 6 -> currentPlayer.sellCandy(currentPlayer.candy6, currentEconomy.getPriceCandy6());
            default -> {
                break;
            }
        }
    }

    void moveAction(){
        System.out.println("Where you wanna move?");
        System.out.println("Press (1) " + cityENUM1);
        System.out.println("Press (2) " + cityENUM2);
        System.out.println("Press (3) " + cityENUM3);
        System.out.println("Press (4) " + cityENUM4);
        System.out.println("Press (5) " + cityENUM5);
        System.out.println("Press (6) " + cityENUM6);
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        switch (input) {
            case 1 -> currentPlayer.moveTo(cityENUM1.toString(), GameUtils.getTravelCost(currentPlayer.location, cityENUM1, currentGame));
            case 2 -> currentPlayer.moveTo(cityENUM2.toString(), GameUtils.getTravelCost(currentPlayer.location, cityENUM2, currentGame));
            case 3 -> currentPlayer.moveTo(cityENUM3.toString(), GameUtils.getTravelCost(currentPlayer.location, cityENUM3, currentGame));
            case 4 -> currentPlayer.moveTo(cityENUM4.toString(), GameUtils.getTravelCost(currentPlayer.location, cityENUM4, currentGame));
            case 5 -> currentPlayer.moveTo(cityENUM5.toString(), GameUtils.getTravelCost(currentPlayer.location, cityENUM5, currentGame));
            case 6 -> currentPlayer.moveTo(cityENUM6.toString(), GameUtils.getTravelCost(currentPlayer.location, cityENUM6, currentGame));
            default -> {
                break;
            }
        }
    }
}





