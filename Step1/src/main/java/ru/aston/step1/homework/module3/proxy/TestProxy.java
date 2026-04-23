package ru.aston.step1.homework.module3.proxy;

import java.time.LocalDate;

public class TestProxy {

    static void main() {
        prepare(new ProxyDailyReport(new DailyReport()), LocalDate.now());
    }

    private static void prepare(Report report, LocalDate localDate){
        final String dailyReport = report.prepareReport(localDate);
        System.out.println(dailyReport);
    }
}
