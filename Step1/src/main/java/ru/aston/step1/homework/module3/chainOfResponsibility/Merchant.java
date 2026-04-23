package ru.aston.step1.homework.module3.chainOfResponsibility;

public abstract class Merchant {
    private Merchant next;

    public void setNext(Merchant next) {
        if (this.next == null)
            this.next = next;
        else
            this.next.setNext(next);
    }

    public abstract void sell(Ware ware);

    public void forward(Ware ware){
        if(next!= null)
            next.sell(ware);
    }
}
