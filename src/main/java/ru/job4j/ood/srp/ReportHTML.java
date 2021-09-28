package ru.job4j.ood.srp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.function.Predicate;

public class ReportHTML implements Report {

    private Store store;

    public ReportHTML(Store store) {
        this.store = store;
    }
    @Override
    public String generate(Predicate<Employee> filter)  {
        StringBuilder xml = new StringBuilder();
        JAXBContext context = null;
        Employees employees = new Employees();
        employees.setEmployees(store.findBy(filter));
        try {
            context = JAXBContext.newInstance(Employees.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                try (StringWriter writer = new StringWriter()) {
                    marshaller.marshal(employees, writer);
                    xml.append(writer.getBuffer().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xml.toString();
    }
}
