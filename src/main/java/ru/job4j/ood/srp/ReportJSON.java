package ru.job4j.ood.srp;

import com.google.gson.GsonBuilder;
import java.util.function.Predicate;

public class ReportJSON implements Report {

    private Store store;

    public ReportJSON(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        var json = new GsonBuilder().create();
        for (Employee employee : store.findBy(filter)) {
            text.append(json.toJson(employee));
        }
        return text.toString();
    }
}
