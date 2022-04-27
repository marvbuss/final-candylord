package de.materna.candylord;

public class Price {
    private final String name;
    private final double minPrice;
    private final double priceRange;
    private double currentPrice;

    Price(double minPrice, double maxPrice, String name) {
        this.minPrice = minPrice;
        this.priceRange = maxPrice - minPrice + 1;
        this.name = name;
        shufflePrice();
    }

    public String getName() {
        return name;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public double getPriceRange() {
        return priceRange;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void shufflePrice() {
        double shuffledPrice = Math.round(( (Math.random() * getPriceRange()) + getMinPrice()) * 100.0) / 100.0;
        setCurrentPrice(shuffledPrice);
    }
}
