package edu.nku.csc364.bursar;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

import static edu.nku.csc364.bursar.EventType.NEW_REQUEST;
import static edu.nku.csc364.bursar.EventType.REQUEST_COMPLETED;
import static org.assertj.core.api.Assertions.assertThat;


public class BursarOfficeJavaServiceTest {

    BursarOfficeJavaService service;

    @Before
    public void setup() {
        service = new BursarOfficeJavaService();
    }

    @Test
    public void happyPathExample() {
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("John", 3.75, 2)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Mark", 3.8, 3)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Shawn", 3.7, 4)));
        service.receiveEvent(new Event<>(REQUEST_COMPLETED));
        service.receiveEvent(new Event<>(REQUEST_COMPLETED));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Sam", 3.85, 5)));
        service.receiveEvent(new Event<>(REQUEST_COMPLETED));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Ashley", 3.9, 6)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Mary", 3.6, 7)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Andrew", 3.95, 8)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Dan", 3.95, 9)));
        service.receiveEvent(new Event<>(REQUEST_COMPLETED));

        List<String> report = service.runReport();
        assertThat(report).isNotEmpty();
        assertThat(report).containsSequence("Dan", "Ashley", "Shawn", "Mary");
    }

    @Test
    public void test1() {
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("John", 3.75, 1)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Mark", 3.8, 2)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Shawn", 3.7, 3)));
        service.receiveEvent(new Event<>(REQUEST_COMPLETED));
        service.receiveEvent(new Event<>(REQUEST_COMPLETED));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Sam", 3.85, 4)));
        service.receiveEvent(new Event<>(REQUEST_COMPLETED));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Ashley", 3.9, 5)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Mary", 3.6, 6)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Andrew", 3.95, 7)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Dan", 3.95, 8)));
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
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("John", 3.8, 1)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("John", 3.8, 2)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Shawn", 3.8, 3)));
        service.receiveEvent(new Event<>(REQUEST_COMPLETED));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Sam", 3.8, 4)));
        service.receiveEvent(new Event<>(REQUEST_COMPLETED));

        List<String> report = service.runReport();
        assertThat(report).isNotEmpty();
        assertThat(report).containsSequence("Sam", "Shawn");
    }

    @Test
    public void test3() {
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("John", 3.8, 1)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("John", 3.8, 2)));
        service.receiveEvent(new Event<>(REQUEST_COMPLETED));

        List<String> report = service.runReport();
        assertThat(report).isNotEmpty();
        assertThat(report).containsSequence("John");
    }

    @Test
    public void test4() {
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("John", 3.7, 1)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Mark", 3.8, 2)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Mark", 3.9, 3)));
        service.receiveEvent(new Event<>(REQUEST_COMPLETED));

        List<String> report = service.runReport();
        assertThat(report).isNotEmpty();
        assertThat(report).containsSequence("Mark", "John");
    }

    @Test
    public void test5() {
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Zach", 3.8, 1)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Xander", 3.9, 2)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("John", 3.8, 3)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("John", 3.8, 4)));
        service.receiveEvent(new Event<>(NEW_REQUEST, new Student("Mark", 3.8, 5)));
        service.receiveEvent(new Event<>(REQUEST_COMPLETED));

        List<String> report = service.runReport();
        assertThat(report).isNotEmpty();
        assertThat(report).containsSequence("John", "John", "Mark", "Zach");
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