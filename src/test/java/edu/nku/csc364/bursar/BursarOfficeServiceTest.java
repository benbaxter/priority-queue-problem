package edu.nku.csc364.bursar;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static edu.nku.csc364.bursar.EventType.NEW_REQUEST;
import static edu.nku.csc364.bursar.EventType.REQUEST_COMPLETED;
import static org.assertj.core.api.Assertions.assertThat;


public class BursarOfficeServiceTest {


    BursarOfficeService service;

    @Before
    public void setup() {
        service = new BursarOfficeService();
    }

    @Test
    public void happyPathExample() {
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("John", 3.75, ClassStatus.SENIOR)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Mark", 3.8, ClassStatus.FRESHMEN)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Shawn", 3.7, ClassStatus.JUNIOR)));
        service.receiveEvent(new Event<>(REQUEST_COMPLETED));
        service.receiveEvent(new Event<>(REQUEST_COMPLETED));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Sam", 3.85, ClassStatus.SENIOR)));
        service.receiveEvent(new Event<>(REQUEST_COMPLETED));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Ashley", 3.9, ClassStatus.SOPHOMORE)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Mary", 3.6, ClassStatus.FRESHMEN)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Andrew", 3.95, ClassStatus.JUNIOR)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Dan", 3.95, ClassStatus.SENIOR)));
        service.receiveEvent(new Event<>(REQUEST_COMPLETED));

        List<String> report = service.runReport();
        assertThat(report).isNotEmpty();
        assertThat(report).hasSize(4);
        assertThat(report).containsSequence("Andrew", "Ashley", "Mark", "Mary");
    }

    @Test
    public void antherTest() {

    }

}