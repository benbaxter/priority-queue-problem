package edu.nku.csc364.bursar;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

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
        assertThat(report).containsSequence("Andrew", "Ashley", "Mark", "Mary");
    }

    @Test
    public void test1() {
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
        service.receiveEvent(new Event<>(REQUEST_COMPLETED));
        service.receiveEvent(new Event<>(REQUEST_COMPLETED));
        service.receiveEvent(new Event<>(REQUEST_COMPLETED));
        service.receiveEvent(new Event<>(REQUEST_COMPLETED));
        service.receiveEvent(new Event<>(REQUEST_COMPLETED));
        service.receiveEvent(new Event<>(REQUEST_COMPLETED));
        service.receiveEvent(new Event<>(REQUEST_COMPLETED));

        List<String> report = service.runReport();
        assertThat(report).isNotEmpty();
        assertThat(report).containsSequence("EMPTY");
    }

    @Test
    public void test2() {
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("John", 3.75, ClassStatus.SENIOR)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Mark", 3.8, ClassStatus.FRESHMEN)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Shawn", 3.7, ClassStatus.JUNIOR)));
        service.receiveEvent(new Event<>(REQUEST_COMPLETED));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Sam", 3.85, ClassStatus.SOPHOMORE)));
        service.receiveEvent(new Event<>(REQUEST_COMPLETED));

        List<String> report = service.runReport();
        assertThat(report).isNotEmpty();
        assertThat(report).containsSequence("Sam", "Mark");
    }

    @Test
    public void test3() {
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("John", 3.75, ClassStatus.SENIOR)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Mark", 3.8, ClassStatus.SENIOR)));
        service.receiveEvent(new Event<>(REQUEST_COMPLETED));

        List<String> report = service.runReport();
        assertThat(report).isNotEmpty();
        assertThat(report).containsSequence("John");
    }

    @Test
    public void test4() {
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("John", 3.8, ClassStatus.SENIOR)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Mark", 3.8, ClassStatus.SENIOR)));
        service.receiveEvent(new Event<>(REQUEST_COMPLETED));

        List<String> report = service.runReport();
        assertThat(report).isNotEmpty();
        assertThat(report).containsSequence("Mark");
    }

    @Test
    public void test5() {
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Zach", 3.8, ClassStatus.FRESHMEN)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Xander", 3.9, ClassStatus.FRESHMEN)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("John", 3.8, ClassStatus.SENIOR)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Mark", 3.8, ClassStatus.SENIOR)));
        service.receiveEvent(new Event<>(REQUEST_COMPLETED));

        List<String> report = service.runReport();
        assertThat(report).isNotEmpty();
        assertThat(report).containsSequence("Mark", "Xander", "Zach");
    }

    @Test
    public void test6() {
        final int load = 1_000_000;
        IntStream.range(0, load)
                .forEach(i -> {
                    double gpa = (Math.random() * 4);
                    service.receiveEvent(new Event<>(NEW_REQUEST,
                            new Student(String.valueOf(i), gpa, ClassStatus.SENIOR)));
                });

        List<String> report = service.runReport();
        assertThat(report).isNotEmpty();
        assertThat(report).hasSize(load);
    }

}