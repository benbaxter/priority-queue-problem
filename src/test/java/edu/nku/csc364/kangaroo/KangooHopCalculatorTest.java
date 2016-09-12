package edu.nku.csc364.kangaroo;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


public class KangooHopCalculatorTest {

    KangooHopCalculator calculator;

    @Before
    public void setup() {
        calculator = new KangooHopCalculator();
    }

    @Test
    public void happyPath_willMeet() {
        int numOfHops = calculator.willMeetAtSameTime(0, 3, 4, 2);
        assertThat(numOfHops, is(equalTo(4)));
    }

    @Test
    public void happyPath_willMeetNotMeet() {
        int numOfHops = calculator.willMeetAtSameTime(0, 2, 5, 3);
        assertNotMeet(numOfHops);
    }

    @Test
    public void test1() {
        int numOfHops = calculator.willMeetAtSameTime(0, 2, 5, 3);
        assertNotMeet(numOfHops);
    }

    @Test
    public void test2() {
        int numOfHops = calculator.willMeetAtSameTime(14, 4, 98, 2);
        assertThat(numOfHops, is(equalTo(42)));
    }

    @Test
    public void test3() {
        int numOfHops = calculator.willMeetAtSameTime(21, 6, 47, 3);
        assertNotMeet(numOfHops);
    }

    @Test
    public void test4() {
        int numOfHops = calculator.willMeetAtSameTime(28, 8, 96, 2);
        assertNotMeet(numOfHops);
    }

    @Test
    public void test5() {
        int numOfHops = calculator.willMeetAtSameTime(35, 1, 45, 3);
        assertNotMeet(numOfHops);
    }

    @Test
    public void test6() {
        int numOfHops = calculator.willMeetAtSameTime(42, 3, 94, 2);
        assertThat(numOfHops, is(equalTo(52)));
    }

    @Test
    public void test7() {
        int numOfHops = calculator.willMeetAtSameTime(43, 5, 49, 3);
        assertThat(numOfHops, is(equalTo(3)));
    }

    @Test
    public void test8() {
        int numOfHops = calculator.willMeetAtSameTime(45, 7, 56, 2);
        assertNotMeet(numOfHops);
    }

    @Test
    public void test9() {
        int numOfHops = calculator.willMeetAtSameTime(45, 7, 56, 2);
        assertNotMeet(numOfHops);
    }

    @Test
    public void test10() {
        int numOfHops = calculator.willMeetAtSameTime(45, 7, 56, 2);
        assertNotMeet(numOfHops);
    }

    @Test
    public void test11() {
        int numOfHops = calculator.willMeetAtSameTime(4523, 8092, 9419, 8076);
        assertThat(numOfHops, is(equalTo(306)));
    }

    @Test
    public void test12() {
        int numOfHops = calculator.willMeetAtSameTime(6644, 5868, 8349, 3477);
        assertNotMeet(numOfHops);
    }

    @Test
    public void test13() {
        int numOfHops = calculator.willMeetAtSameTime(112, 9563, 8625, 244);
        assertNotMeet(numOfHops);
    }

    @Test
    public void test14() {
        int numOfHops = calculator.willMeetAtSameTime(1408, 6689, 6730, 4028);
        assertThat(numOfHops, is(equalTo(2)));
    }

    @Test
    public void test15() {
        int numOfHops = calculator.willMeetAtSameTime(4181, 3976, 6312, 988);
        assertNotMeet(numOfHops);
    }

    @Test
    public void test16() {
        int numOfHops = calculator.willMeetAtSameTime(240, 575, 9179, 9986);
        assertNotMeet(numOfHops);
    }

    @Test
    public void test17() {
        int numOfHops = calculator.willMeetAtSameTime(55, 8223, 5803, 6509);
        assertNotMeet(numOfHops);
    }

    @Test
    public void test18() {
        int numOfHops = calculator.willMeetAtSameTime(2564, 5393, 5121, 2836);
        assertThat(numOfHops, is(equalTo(1)));
    }

    @Test
    public void test19() {
        int numOfHops = calculator.willMeetAtSameTime(288, 9679, 9653, 99);
        assertNotMeet(numOfHops);
    }

    @Test
    public void test20() {
        int numOfHops = calculator.willMeetAtSameTime(2932, 7030, 9106, 4840);
        assertNotMeet(numOfHops);
    }

    @Test
    public void test21() {
        int numOfHops = calculator.willMeetAtSameTime(4602, 8519, 7585, 8362);
        assertThat(numOfHops, is(equalTo(19)));
    }

    @Test
    public void test22() {
        int numOfHops = calculator.willMeetAtSameTime(23, 9867, 9814, 5861);
        assertNotMeet(numOfHops);
    }

    @Test
    public void test23() {
        int numOfHops = calculator.willMeetAtSameTime(1817, 9931, 8417, 190);
        assertNotMeet(numOfHops);
    }

    @Test
    public void test24() {
        int numOfHops = calculator.willMeetAtSameTime(3585, 7317, 6994, 9610);
        assertNotMeet(numOfHops);
    }

    @Test
    public void test25() {
        int numOfHops = calculator.willMeetAtSameTime(1113, 612, 1331, 610);
        assertThat(numOfHops, is(equalTo(109)));
    }

    @Test
    public void test26() {
        int numOfHops = calculator.willMeetAtSameTime(2081, 8403, 9107, 8400);
        assertThat(numOfHops, is(equalTo(2342)));
    }

    @Test
    public void test27() {
        int numOfHops = calculator.willMeetAtSameTime(1928, 4306, 5763, 4301);
        assertThat(numOfHops, is(equalTo(767)));
    }

    @Test
    public void test28() {
        int numOfHops = calculator.willMeetAtSameTime(7271, 2211, 7915, 2050);
        assertThat(numOfHops, is(equalTo(4)));
    }

    @Test
    public void test29() {
        int numOfHops = calculator.willMeetAtSameTime(1571, 4240, 9023, 4234);
        assertThat(numOfHops, is(equalTo(1242)));
    }

    private void assertNotMeet(int numOfHops) {
        assertThat(numOfHops, is(equalTo(-1)));
    }
}