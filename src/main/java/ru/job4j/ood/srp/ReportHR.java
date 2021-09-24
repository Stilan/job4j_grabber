package ru.job4j.ood.srp;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReportHR implements Report{
    private Store store;

    public ReportHR(Store store) {
        this.store = store;
    }
    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        text.append(System.lineSeparator());
        List<Employee> sortSalary = store.findBy(filter);
        sortSalary.sort(comparator);
        for (Employee employee : sortSalary) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
    Comparator<Employee> comparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return (int) (o2.getSalary() - o1.getSalary());
        }
    };

}
