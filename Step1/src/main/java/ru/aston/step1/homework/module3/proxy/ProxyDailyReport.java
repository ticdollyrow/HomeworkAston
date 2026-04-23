package ru.aston.step1.homework.module3.proxy;

import java.time.LocalDate;
import java.util.HashMap;


public class ProxyDailyReport implements Report{

    private DailyReport dailyReport;
    private static HashMap<LocalDate, String> cache = new HashMap<>();

    public ProxyDailyReport(DailyReport dailyReport) {
        this.dailyReport = dailyReport;
    }

    @Override
    public String prepareReport(LocalDate localDate) {
        String report = cache.getOrDefault(localDate, dailyReport.prepareReport(localDate));
        if(!cache.containsKey(localDate)){
            cache.put(localDate, report);
        }
        return report;
    }
}
