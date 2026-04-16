package ru.aston.step1.homework;

import java.math.BigDecimal;
import java.util.Objects;

//Реализовать свой иммутабельный класс, который будет внутри себя содержать поле с изменяемым классом.
public final class Employee {
    final private String name;
    final private String surname;
    final private BigDecimal salary;
    final private BankAccount bankAccount;

    public Employee(String name, String surname, BigDecimal salary, BankAccount bankAccount) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.bankAccount = new BankAccount(bankAccount.getName(), bankAccount.getCard());
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public String getSurname() {
        return surname;
    }

    public BankAccount getBankAccount() {
        return new BankAccount(bankAccount.getName(), bankAccount.getCard());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(salary, employee.salary) && Objects.equals(bankAccount, employee.bankAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, salary, bankAccount);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", bankAccount=" + bankAccount +
                '}';
    }
}

class BankAccount{
    private String name;
    private String card;

    public BankAccount(String name, String card) {
        this.name = name;
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public String getCard() {
        return card;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCard(String card) {
        this.card = card;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(name, that.name) && Objects.equals(card, that.card);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, card);
    }
}


record EmplRecord(String firstName, String lastName, BigDecimal salary, BankAccount bankAccount){};

