package ru.job4j.srp;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.ood.srp.Employee;
import ru.job4j.ood.srp.MemStore;
import ru.job4j.ood.srp.Report;
import ru.job4j.ood.srp.ReportHTML;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ReportHTMLTest {
    @Ignore
    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportHTML(store);
        StringBuilder expect = new StringBuilder();
        expect.append("<?xml version= 1.1 encoding = UTF-8 ?>");
        expect.append(System.lineSeparator());
        expect.append("<name> ").append(worker.getName()).append(" <name/>");
        expect.append(System.lineSeparator());
        expect.append("<hired> ").append(worker.getHired()).append(" <hired/>");
        expect.append(System.lineSeparator());
        expect.append("<fired> ").append(worker.getFired()).append(" <fired/>");
        expect.append(System.lineSeparator());
        expect.append("<salary> ").append(worker.getSalary()).append(" <salary/>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}
