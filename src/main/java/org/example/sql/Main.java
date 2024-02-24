package org.example.sql;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        DatabaseQueryService databaseQueryService = new DatabaseQueryService();
        Map<Integer, Integer> map = new HashMap<>();
        databaseQueryService.findProjectPrices()
                .forEach(projectPricesPrinter ->
                        map.put(projectPricesPrinter.getProjectId(), projectPricesPrinter.getPrice()));
        System.out.println(map);
    }
}
