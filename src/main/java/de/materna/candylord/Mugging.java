package de.materna.candylord;

class Mugging extends Event {
    @Override void process( Player player ) {
        System.out.println("----------------------------------------");
        System.out.println("Damn you were robbed");
        System.out.println("----------------------------------------");
        double random = Math.random();
        if ( random < 0.166 ) player.candy1.setQuantity(0);
        if ( random < 0.333 ) player.candy2.setQuantity(0);
        if ( random < 0.5 ) player.candy3.setQuantity(0);
        if ( random < 0.666 ) player.candy4.setQuantity(0);
        if ( random < 0.833 ) player.candy5.setQuantity(0);
        player.candy6.setQuantity(0);
    }
}
