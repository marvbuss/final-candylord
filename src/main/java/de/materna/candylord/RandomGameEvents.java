package de.materna.candylord;


class RandomGameEvents {
        private RandomGameEvents() {}
        static Event next() {
            double random = Math.random();
            if ( random < 0.5 ) return new NoopEvent();
            if ( random < 0.8 ) return new Gift();
            return new Mugging();
        }
}

