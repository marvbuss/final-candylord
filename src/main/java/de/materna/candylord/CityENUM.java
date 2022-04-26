package de.materna.candylord;

public enum CityENUM {
    HAMBURG(53.55034, 10.00065), COLOGNE(50.93836, 6.95997), BERLIN(52.51704, 13.38886), MUNICH(48.13711, 11.57538), FRANKFURT(50.11064, 8.68209), STUTTGART(48.77845, 9.18001);

    double lat;
    double lon;

    CityENUM(double lat, double lon)
    {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}
