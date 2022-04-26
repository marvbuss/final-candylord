package de.materna.candylord;

class Mugging extends Event {
    @Override void process( Player player ) {
        System.out.println("----------------------------------------");
        System.out.println("Damn you were robbed");
        System.out.println("----------------------------------------");
        double random = Math.random();
        if ( random < 0.166 ) player.candies.get(0).setQuantity(0);
        if ( random < 0.333 ) player.candies.get(1).setQuantity(0);
        if ( random < 0.5 ) player.candies.get(2).setQuantity(0);
        if ( random < 0.666 ) player.candies.get(3).setQuantity(0);
        if ( random < 0.833 ) player.candies.get(4).setQuantity(0);
        player.candies.get(5).setQuantity(0);
    }
}
