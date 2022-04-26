package de.materna.candylord;

public class GameEconomy {
    double minPriceCandy1 = 15000, maxPriceCandy1= 30000;
    double rangeCandy1 = maxPriceCandy1 - minPriceCandy1 + 1;
    double minPriceCandy2 = 5000, maxPriceCandy2= 14000;
    double rangeCandy2 = maxPriceCandy2 - minPriceCandy2 + 1;
    double minPriceCandy3 = 1000, maxPriceCandy3= 4500;
    double rangeCandy3 = maxPriceCandy3 - minPriceCandy3 + 1;
    double minPriceCandy4 = 300, maxPriceCandy4= 900;
    double rangeCandy4 = maxPriceCandy4 - minPriceCandy4 + 1;
    double minPriceCandy5 = 70, maxPriceCandy5= 250;
    double rangeCandy5 = maxPriceCandy5 - minPriceCandy5 + 1;
    double minPriceCandy6 = 10, maxPriceCandy6= 60;
    double rangeCandy6 = maxPriceCandy6 - minPriceCandy6 + 1;

    double priceCandy1, priceCandy2, priceCandy3, priceCandy4, priceCandy5, priceCandy6;

    public GameEconomy(){
        createEconomy();
    }

    public void createEconomy() {
        double randPriceCandy1 = Math.round(( (Math.random() * rangeCandy1) + minPriceCandy1) * 100.0) / 100.0;
        double randPriceCandy2 = Math.round(( (Math.random() * rangeCandy2) + minPriceCandy2) * 100.0) / 100.0;
        double randPriceCandy3 = Math.round(( (Math.random() * rangeCandy3) + minPriceCandy3) * 100.0) / 100.0;
        double randPriceCandy4 = Math.round(( (Math.random() * rangeCandy4) + minPriceCandy4) * 100.0) / 100.0;
        double randPriceCandy5 = Math.round(( (Math.random() * rangeCandy5) + minPriceCandy5) * 100.0) / 100.0;
        double randPriceCandy6 = Math.round(( (Math.random() * rangeCandy6) + minPriceCandy6) * 100.0) / 100.0;

        setPriceCandy1(randPriceCandy1);
        setPriceCandy2(randPriceCandy2);
        setPriceCandy3(randPriceCandy3);
        setPriceCandy4(randPriceCandy4);
        setPriceCandy5(randPriceCandy5);
        setPriceCandy6(randPriceCandy6);

    }

    public double getPriceCandy1() {
        return priceCandy1;
    }

    public void setPriceCandy1(double priceCandy1) {
        this.priceCandy1 = priceCandy1;
    }

    public double getPriceCandy2() {
        return priceCandy2;
    }

    public void setPriceCandy2(double priceCandy2) {
        this.priceCandy2 = priceCandy2;
    }

    public double getPriceCandy3() {
        return priceCandy3;
    }

    public void setPriceCandy3(double priceCandy3) {
        this.priceCandy3 = priceCandy3;
    }

    public double getPriceCandy4() {
        return priceCandy4;
    }

    public void setPriceCandy4(double priceCandy4) {
        this.priceCandy4 = priceCandy4;
    }

    public double getPriceCandy5() {
        return priceCandy5;
    }

    public void setPriceCandy5(double priceCandy5) {
        this.priceCandy5 = priceCandy5;
    }

    public double getPriceCandy6() {
        return priceCandy6;
    }

    public void setPriceCandy6(double priceCandy6) {
        this.priceCandy6 = priceCandy6;
    }

}
