package ru.job4j.ood.srp;

import java.util.function.Predicate;

public class ReportHTML implements Report {

    private Store store;

    public ReportHTML(Store store) {
        this.store = store;
    }
    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<?xml version= 1.1 encoding = UTF-8 ?>");
        text.append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
             text.append("<name> ").append(employee.getName()).append(" <name/>");
             text.append(System.lineSeparator());
             text.append("<hired> ").append(employee.getHired()).append(" <hired/>");
             text.append(System.lineSeparator());
             text.append("<fired> ").append(employee.getFired()).append(" <fired/>");
             text.append(System.lineSeparator());
             text.append("<salary> ").append(employee.getSalary()).append(" <salary/>");

        }
        return text.toString();
    }
}
