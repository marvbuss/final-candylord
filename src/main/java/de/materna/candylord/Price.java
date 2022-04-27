package de.materna.candylord;

public class Price {
    private String name;
    private double minPrice;
    private double maxPrice;
    private double priceRange;
    private double currentPrice;

    Price(double minPrice, double maxPrice, String name) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.priceRange = maxPrice - minPrice + 1;
        this.name = name;
        shufflePrice();
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public double getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(double priceRange) {
        this.priceRange = priceRange;
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
