package edu.nku.csc364.kangaroo;

public class KangooHopCalculator {


    /**
     *
     * Return the number of hops it takes for two
     * kangaroos to land on the same space. It must
     * take the smae number of hops, otherwise return
     * -1. It will return -1 if they never meet. For
     * all other cases, -1 will be returned.
     *
     * @param x1 starting position for for kangaroo 1
     * @param v1 velocity for kangaroo 1
     * @param x2 starting position for for kangaroo 2
     * @param v2 velocity for kangaroo 2
     * @return The number of hops for the kangaroos to meet.
     *             -1 if they do not meet or do not meet in the
     *             same number of hope
     */
    public int willMeetAtSameTime(int x1, int v1, int x2, int v2) {

        if ( (x2 > x1 && v2 > v1) || (x1 > x2 && v1 > v2) ) {
            return -1;
        }
        /*
            x1 + j * v1 = x2 + j * v2
            j*v1 - j*v2 = x2 - x1
            j(v1-v2)=x2-x1
            j=(x2-x1)/(v1-v2)
        */
        if( v1 == v2 && x1 == x2 ) {
            return 0;
        } else if (v1==v2 && x1 != x2) {
            return -1;
        } else {
            final int x = Math.abs(x2 - x1);
            final int v = Math.abs(v1 - v2);
            if ( x % v == 0 ) {
                return x / v;
            }
        }

        return -1;
    }

}
