package com.test.collectionexamples;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class BinarySearchExample {

    public static void main(String[] args) {
        // Example of creating a Collection of Strings and search it using binary search
        // This is a very simple example of using binary search
        // The collection must be sorted before using binary search

        // Create a collection of Strings
        String[] names = {"Adam", "Bob", "Dave", "Fred", "Joe", "Zack"};

        // Sort the collection
        // java.util.Arrays.sort(names);

        // Search the collection for "Joe"
        int index = java.util.Arrays.binarySearch(names, "Joe");

        // Print the index of the search item
        System.out.println("Joe is at index " + index);

        // Another example of using binary search
        // Create a collection of Integers
        Integer[] numbers = {1, 3, 5, 7, 9, 11};

        // Search the collection for 7
        index = java.util.Arrays.binarySearch(numbers, 7);

        // Print the index of the search item
        System.out.println("7 is at index " + index);

        // For non matching entries, binary search returns a negative number
        // The negative number is the index of the first element that is larger than the search item
        // For example, if we search for 8 in the numbers collection, binary search returns -5
        // This means that 8 should be inserted at index 4 == -(index-1) to keep the collection sorted
        // The index returned by binary search is -5
        index = java.util.Arrays.binarySearch(numbers, 8);

        System.out.println("8 is at index " + (-index - 1));

        // Another example of using binary search using a custom comparator

        // Create a collection of Strings
        String[] names2 = {"Adam", "Bob", "Dave", "Fred", "Joe", "Zack"};

        // Sort the collection using a custom comparator
        java.util.Arrays.sort(names2, new java.util.Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // Reverse the comparison
                return s2.compareTo(s1);
            }
        });

        // Search the collection for "Joe"
        //  index = Collections.binarySearch(Arrays.stream(names2).toList(), "Joe", Comparator.reverseOrder());

        index = Arrays.binarySearch(names2, "Joe", Comparator.reverseOrder());

        // Print the index of the search item
        System.out.println("Joe is at index " + index);

        // Another example of using binary search on a collection of custom objects

        class Person {
            private String name;
            private int age;

            public Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            public String getName() {
                return name;
            }

            public int getAge() {
                return age;
            }
        }

        // Create a collection of custom objects
        Person[] people = {new Person("Adam", 23),
                new Person("Bob", 27),
                new Person("Dave", 51),
                new Person("Fred", 19),
                new Person("Joe", 17),
                new Person("Zack", 31)};

        // Sort the collection using a custom comparator
        java.util.Arrays.sort(people, new java.util.Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                // Reverse the comparison
                return Integer.compare(p2.getAge(), p1.getAge());
            }
        });

        // Search the collection for "Joe"
        index = java.util.Arrays.binarySearch(people, new Person("Joe", 17), new java.util.Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                // Reverse the comparison
                return Integer.compare(p2.getAge(), p1.getAge());
            }
        });

        // Print the index of the search item
        System.out.println("Joe is at index " + index);

    }
}
