package de.materna.candylord;

abstract class Event {
    String about;
    int duration;
    abstract void process( Player player );
}
