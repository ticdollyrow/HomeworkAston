package ru.aston.step1.homework.module3.proxy;

import java.time.LocalDate;

public class DailyReport implements  Report{
    @Override
    public String prepareReport(LocalDate localDate) {

        return "Ежедневный отчет за " + localDate;
    }
}
