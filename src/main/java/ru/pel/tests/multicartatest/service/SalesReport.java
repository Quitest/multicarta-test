package ru.pel.tests.multicartatest.service;

import java.util.List;

public interface SalesReport {
    List<String> getBestBuyer();

    List<String> getBestseller();

    List<String> getFavorite18yo();

    List<String> getPaymentsInLastWeek();
}
