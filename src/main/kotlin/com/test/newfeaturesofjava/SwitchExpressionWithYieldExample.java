package com.test.newfeaturesofjava;

public class SwitchExpressionWithYieldExample {
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args) {
        Day day = Day.WEDNESDAY;

        int dayNumber = switch (day) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> {
                System.out.println("Weekday");
                yield 1; // Yielding a value for weekdays
            }
            case SATURDAY, SUNDAY -> {
                System.out.println("Weekend");
                yield 2; // Yielding a value for weekends
            }
        };

        System.out.println("Day number: " + dayNumber);
    }
}

