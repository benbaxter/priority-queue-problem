package edu.nku.csc364.kangaroo;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class KangooHopCalculatorTest {

    KangooHopCalculator calculator;

    @Before
    public void setup() {
        calculator = new KangooHopCalculator();
    }

    @Test
    public void happyPath_willMeet() {
        int numOfHops = calculator.willMeetAtSameTime(0, 3, 4, 2);
        assertThat(numOfHops).isEqualTo(4);
    }

    @Test
    public void happyPath_willMeetNotMeet() {
        int numOfHops = calculator.willMeetAtSameTime(0, 2, 5, 3);
        assertThat(numOfHops).isEqualTo(-1);
    }


}