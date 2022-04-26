package de.materna.candylord;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Player {
    List<Candy> candies = new ArrayList<>();
    String location;
    int capacity;
    double cash;
    double debt;

    public Player(int cash, int debt, int capacity, String location){
        this.capacity = capacity;
        this.cash = cash;
        this.debt = debt;
        this.location = location;

        candies.add(new Candy("Candy1", 0));
        candies.add(new Candy("Candy2", 0));
        candies.add(new Candy("Candy3", 0));
        candies.add(new Candy("Candy4", 0));
        candies.add(new Candy("Candy5", 0));
        candies.add(new Candy("Candy6", 0));
    }

    public Player getPlayer() {
        return this;
    }

    public int getCapacity() {
        return capacity;
    }

    void moveTo( String cityName, double price) {
        if ( location.equalsIgnoreCase( cityName ) ) {
            System.out.println( "You're already there" );
            return;
        } else if (price > getPlayer().cash){
            System.out.println( "You can't afford to travel" );
        }
        RandomGameEvents.next().process( this );
        getPlayer().cash -= price;
        location = cityName;
    }

    void buyCandy(Candy candy, double price){
        System.out.println("How many do you wanna buy");
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        if(getPlayer().getCapacity() - input >= 0) {
            if(getPlayer().cash >= input * price){
                getPlayer().cash -= input * price;
                candy.quantity += input;
                capacity -= input;
            } else System.out.println("You don't have enough money");

        }
        else System.out.println("You've reached your maximum capacity");


    }

    void sellCandy(Candy candy, double price){
        System.out.println("How many do you wanna sell");
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        if(candy.getQuantity() - input >= 0) {
            getPlayer().cash += input * price;
            candy.quantity -= input;
            capacity += input;
        }
        else System.out.println("You don't have that much to sell");

    }
}
