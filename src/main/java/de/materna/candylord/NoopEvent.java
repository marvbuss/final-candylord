package de.materna.candylord;

class NoopEvent extends Event {
    @Override void process( Player player ) {
        System.out.println("----------------------------------------");
        System.out.println("This was a smooth trip");
        System.out.println("----------------------------------------");
    }
}
