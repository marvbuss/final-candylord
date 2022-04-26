package de.materna.candylord;
import java.util.concurrent.ThreadLocalRandom;

class Gift extends Event {
    @Override void process( Player player ) {
        System.out.println("----------------------------------------");
        System.out.println("You're lucky and get a gift from a fan");
        System.out.println("----------------------------------------");
        double random = Math.random();
        if ( random < 0.166 ) player.candy1.quantity += ThreadLocalRandom.current().nextInt( 1, 10 );
        if ( random < 0.333 ) player.candy2.quantity += ThreadLocalRandom.current().nextInt( 1, 10 );
        if ( random < 0.5 ) player.candy3.quantity += ThreadLocalRandom.current().nextInt( 1, 10 );
        if ( random < 0.666 ) player.candy4.quantity += ThreadLocalRandom.current().nextInt( 1, 10 );
        if ( random < 0.833 ) player.candy5.quantity += ThreadLocalRandom.current().nextInt( 1, 10 );
        player.candy6.quantity += ThreadLocalRandom.current().nextInt( 1, 10 );
    }
}
