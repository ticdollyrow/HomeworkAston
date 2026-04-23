package ru.aston.step1.homework.module3.chainOfResponsibility;

public class FarmShop extends Merchant{
    @Override
    public void sell(Ware ware) {
        if(ware.equals(Ware.MILK) || ware.equals(Ware.CHEESE)){
            System.out.println("FarmShop " + ware);
        }
        else{
            forward(ware);
        }
    }
}
