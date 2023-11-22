package com.test.newfeaturesofjava;

import java.util.EnumSet;

// Sample enum representing days of the week
enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

public class EnumSetExample {
    public static void main(String[] args) {
        // Creating an EnumSet with some initial elements
        EnumSet<Day> weekend = EnumSet.of(Day.SATURDAY, Day.SUNDAY);

        // Adding an additional day to the set
        weekend.add(Day.FRIDAY);

        System.out.println("Weekend days: " + weekend);

        // Creating an EnumSet with all days of the week
        EnumSet<Day> allDays = EnumSet.allOf(Day.class);

        System.out.println("All days of the week: " + allDays);

        // Creating an EnumSet with no elements
        EnumSet<Day> emptySet = EnumSet.noneOf(Day.class);

        System.out.println("Empty set: " + emptySet);

        // Creating an EnumSet with a range of elements
        EnumSet<Day> weekdays = EnumSet.range(Day.MONDAY, Day.FRIDAY);

        System.out.println("Weekdays: " + weekdays);
    }
}

