package ru.aston.step1.homework.module3.chainOfResponsibility;

public class Bakery extends Merchant{
    @Override
    public void sell(Ware ware) {
        if( Ware.BREAD.equals(ware)){
            System.out.println("Bakery " + ware);
        }else
            forward(ware);
    }
}
