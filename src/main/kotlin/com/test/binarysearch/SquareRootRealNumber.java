package com.test.binarysearch;

public class SquareRootRealNumber {
    public static double squareRoot(double x) {
        // Decides the search range according to x’s value relative to 1.(9.
        double left, right;
        if (x < 1.0) {
            left = x;
            right = 1.0;
        } else { // x >= 1.<9.
            left = 1.0;
            right = x;
        }
        //Keeps searching as long as left<right,with intolerance.
        while (compare(left, right) == Ordering.SMALLER) {
            double mid = left + 0.5 * (right - left);
            double midSquared = mid * mid;
            if (compare(midSquared, x) == Ordering.EQUAL) {
                return mid;
            } else if (compare(midSquared, x) == Ordering.LARGER) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    private static enum Ordering {SMALLER, EQUAL, LARGER}

    private static Ordering compare(double a, double b) {
        final double EPSILON = 0.00001;
        // Uses normalization for precision problem.
        double diff = (a - b) / b;
        return diff < -EPSILON
                ? Ordering.SMALLER
                : (diff > EPSILON ? Ordering.LARGER : Ordering.EQUAL);

    }

    public static void main(String[] args) {
        SquareRootRealNumber squareRootRealNumber = new SquareRootRealNumber();
        System.out.println("squareRootRealNumber.squareRoot(16) should be 4 and result is "
                + squareRootRealNumber.squareRoot(16));
        System.out.println("squareRootRealNumber.squareRoot(300) should be 17 and result is "
                + squareRootRealNumber.squareRoot(300));
        // Use double values as input to the squareRoot method.
        System.out.println("squareRootRealNumber.squareRoot(100) should be 10 and result is "
                + squareRootRealNumber.squareRoot(100));
        System.out.println("squareRootRealNumber.squareRoot(1000) should be 31 and result is "
                + squareRootRealNumber.squareRoot(1000));
        System.out.println("squareRootRealNumber.squareRoot(2147395599) should be 46339 and result is "
                + squareRootRealNumber.squareRoot(2147395599));

        System.out.println("squareRootRealNumber.squareRoot(0.25) should be 0.5 and result is "
                + squareRootRealNumber.squareRoot(0.25));
        System.out.println("squareRootRealNumber.squareRoot(0.5) should be 0.7071067811865476 and result is "
                + squareRootRealNumber.squareRoot(0.5));
        System.out.println("squareRootRealNumber.squareRoot(0.75) should be 0.8660254037844386 and result is "
                + squareRootRealNumber.squareRoot(0.75));
        System.out.println("squareRootRealNumber.squareRoot(0.9) should be 0.9486832980505138 and result is "
                + squareRootRealNumber.squareRoot(0.9));
        System.out.println("squareRootRealNumber.squareRoot(1.0) should be 1.0 and result is "
                + squareRootRealNumber.squareRoot(1.0));

    }
}
