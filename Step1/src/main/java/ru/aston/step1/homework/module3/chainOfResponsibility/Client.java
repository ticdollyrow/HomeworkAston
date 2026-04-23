package ru.aston.step1.homework.module3.chainOfResponsibility;

public class Client {
    static void main() {
        final Bakery bakery = new Bakery();
        final FarmShop farmShop = new FarmShop();
        bakery.setNext(farmShop);
        bakery.sell(Ware.MILK);
        bakery.sell(Ware.BREAD);

    }
}
