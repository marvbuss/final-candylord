package de.materna.candylord;

public class Candy {
        String name;
        int quantity;

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public void setQuantity(int quantity) {
                this.quantity = quantity;
        }

        public int getQuantity() {
                return quantity;
        }

        public Candy(String name, int quantity){
                this.name = name;
                this.quantity = quantity;
        }
}
