package de.materna.candylord;

import java.util.Scanner;

public class CandyLordGame {
    GameConfiguration currentGame = new GameConfiguration(30, 2000, 0, 100, 0.05, 0.1,0.15);
    Player currentPlayer = new Player(currentGame.getStartCash(), currentGame.getStartDebt(), currentGame.getPlayerCapacity(), currentGame.randomCity());
    String guiSeparator = "----------------------------------------";
    String noValidInputMessage = "Please make a valid choice";

    public void startGame(){
            while(currentGame.isContinueGame()){
                System.out.println(guiSeparator);
                System.out.println("Round: " + currentGame.getGameRounds());
                System.out.println("Current Location: " + currentPlayer.location);
                System.out.println("Current Cash: " + currentPlayer.cash + "€" +" Current Debt: " + currentPlayer.debt + "€");
                System.out.println("Current Capacity: " + currentPlayer.capacity);
                for(Candy candy : currentPlayer.candies){
                    System.out.println("Current Amount of " + candy.getName() + ": " + candy.getQuantity());
                }
                System.out.println(guiSeparator);
                for(Price price : currentGame.prices){
                    System.out.println("Current Price of " + price.getName() + ": " + price.getCurrentPrice() + "€");
                }
                System.out.println(guiSeparator);
                for(CityENUM city: CityENUM.values()){
                    System.out.println("Travel Costs for " + city + ": " + GameUtils.getTravelCost(currentPlayer.location, city, currentGame) + "€");
                }
                System.out.println(guiSeparator);
                System.out.println("List of possible plans - Q=quit; B=buy; S=sell; J=travel");
                if(currentPlayer.cash <= 0){
                    currentGame.setContinueGame(false);
                    System.out.println("You're out of money.");
                }
                if(currentGame.getGameRounds() <= 0){
                    currentGame.setContinueGame(false);
                    System.out.println(guiSeparator);
                    System.out.println("Game is over. Time to draw a conclusion");
                    System.out.println(guiSeparator);
                    System.out.println("You've reached: " + (currentPlayer.cash - currentPlayer.debt) + " cash" );
                }
                nextAction();
                for(Price price : currentGame.prices){
                    price.shufflePrice();
                }
                currentGame.setGameRounds((currentGame.getGameRounds() - 1));

            }
    }

    private void nextAction(){
        Scanner scan = new Scanner(System.in);
        String input = scan.next();

        switch (input.toLowerCase()) {
            case "q" -> quitAction();
            case "b" -> buyAction();
            case "s" -> sellAction();
            case "j" -> moveAction();
            default -> {
                System.out.println(noValidInputMessage);
                nextAction();
            }
        }

    }

    void quitAction(){
        System.exit(0);
    }

    void buyAction(){
        System.out.println("Which candy you wanna buy?");
        for(Candy candy : currentPlayer.candies){
            System.out.println("Press " + (currentPlayer.candies.indexOf(candy) + 1) + " for " + candy.getName());
        }
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
                System.out.println(noValidInputMessage);
                buyAction();}
            }
    }


    void sellAction(){
        System.out.println("Which candy you wanna sell?");
        for(Candy candy : currentPlayer.candies){
            System.out.println("Press " + (currentPlayer.candies.indexOf(candy) + 1) + " for " + candy.getName());
        }
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
                System.out.println(noValidInputMessage);
                sellAction();}
        }
    }

    void moveAction(){
        System.out.println("Where you wanna move?");
        for(CityENUM city: CityENUM.values()){
            System.out.println("Press " + (city.ordinal() + 1) + " for " + city);
        }
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        switch (input) {
            case 1 -> currentPlayer.moveTo(CityENUM.HAMBURG.toString(), GameUtils.getTravelCost(currentPlayer.location, CityENUM.HAMBURG, currentGame));
            case 2 -> currentPlayer.moveTo(CityENUM.COLOGNE.toString(), GameUtils.getTravelCost(currentPlayer.location, CityENUM.STUTTGART, currentGame));
            case 3 -> currentPlayer.moveTo(CityENUM.BERLIN.toString(), GameUtils.getTravelCost(currentPlayer.location, CityENUM.BERLIN, currentGame));
            case 4 -> currentPlayer.moveTo(CityENUM.MUNICH.toString(), GameUtils.getTravelCost(currentPlayer.location, CityENUM.COLOGNE, currentGame));
            case 5 -> currentPlayer.moveTo(CityENUM.FRANKFURT.toString(), GameUtils.getTravelCost(currentPlayer.location, CityENUM.FRANKFURT, currentGame));
            case 6 -> currentPlayer.moveTo(CityENUM.STUTTGART.toString(), GameUtils.getTravelCost(currentPlayer.location, CityENUM.STUTTGART, currentGame));
            default -> moveAction();
        }
    }
}





