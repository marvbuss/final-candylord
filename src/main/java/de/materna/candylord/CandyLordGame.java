package de.materna.candylord;

import java.util.Scanner;

public class CandyLordGame {
    GameManager currentGame = new GameManager(30, 2000, 0, 100, 0.05, 0.1, true, 0.15);
    Player currentPlayer = new Player(currentGame.startCash, currentGame.startDebt, currentGame.playerCapacity, currentGame.randomCity());
    CityENUM cityENUM1 = CityENUM.HAMBURG;
    CityENUM cityENUM2 = CityENUM.COLOGNE;
    CityENUM cityENUM3 = CityENUM.BERLIN;
    CityENUM cityENUM4 = CityENUM.MUNICH;
    CityENUM cityENUM5 = CityENUM.FRANKFURT;
    CityENUM cityENUM6 = CityENUM.STUTTGART;

    public void startGame(){
            while(currentGame.continueGame){
                System.out.println("Round: " + currentGame.gameRounds);
                System.out.println("Current Location: " + currentPlayer.location);
                System.out.println("Current Cash: " + currentPlayer.cash + "€" +" Current Debt: " + currentPlayer.debt + "€");
                System.out.println("Current Capacity: " + currentPlayer.capacity);
                for(Candy candy : currentPlayer.candies){
                    System.out.println("Current Amount " + candy.getName() + ": " + candy.getQuantity());
                }
                System.out.println("----------------------------------------");
                for(Price price : currentGame.prices){
                    System.out.println("Current Price " + price.getName() + ": " + price.getCurrentPrice() + "€");
                }
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
                nextAction();
                for(Price price : currentGame.prices){
                    price.shufflePrice();
                }
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
            case 1 -> currentPlayer.buyCandy(currentPlayer.candies.get(0), currentGame.prices.get(0).getCurrentPrice());
            case 2 -> currentPlayer.buyCandy(currentPlayer.candies.get(1), currentGame.prices.get(1).getCurrentPrice());
            case 3 -> currentPlayer.buyCandy(currentPlayer.candies.get(2), currentGame.prices.get(2).getCurrentPrice());
            case 4 -> currentPlayer.buyCandy(currentPlayer.candies.get(3), currentGame.prices.get(3).getCurrentPrice());
            case 5 -> currentPlayer.buyCandy(currentPlayer.candies.get(4), currentGame.prices.get(4).getCurrentPrice());
            case 6 -> currentPlayer.buyCandy(currentPlayer.candies.get(5), currentGame.prices.get(5).getCurrentPrice());
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
            case 1 -> currentPlayer.sellCandy(currentPlayer.candies.get(0), currentGame.prices.get(0).getCurrentPrice());
            case 2 -> currentPlayer.sellCandy(currentPlayer.candies.get(1), currentGame.prices.get(1).getCurrentPrice());
            case 3 -> currentPlayer.sellCandy(currentPlayer.candies.get(2), currentGame.prices.get(2).getCurrentPrice());
            case 4 -> currentPlayer.sellCandy(currentPlayer.candies.get(3), currentGame.prices.get(3).getCurrentPrice());
            case 5 -> currentPlayer.sellCandy(currentPlayer.candies.get(4), currentGame.prices.get(4).getCurrentPrice());
            case 6 -> currentPlayer.sellCandy(currentPlayer.candies.get(5), currentGame.prices.get(5).getCurrentPrice());
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





