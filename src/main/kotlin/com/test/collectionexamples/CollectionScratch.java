package com.test.collectionexamples;

import java.util.ArrayList;
import java.util.List;

public class CollectionScratch {

    public static void main(String[] args) {
        // Example of Collection fill method
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add(null);
        list.add("e");
        System.out.println(list);
        java.util.Collections.fill(list, "z");
        System.out.println(list);

        // Example of Collection copy method
        List<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        list2.add("c");
        list2.add("d");
        list2.add("e");
        System.out.println(list2);
        java.util.Collections.copy(list, list2);
        System.out.println(list2);

        // Example of Collection min method

        System.out.println(java.util.Collections.min(list));

        // Example of Collection max method

        System.out.println(java.util.Collections.max(list));

        // Example of Collection reverse method

        java.util.Collections.reverse(list);
        System.out.println(list);

        // Example of Collection rotate method
        java.util.Collections.reverse(list);
        System.out.println(list);

        java.util.Collections.rotate(list, 2);
        System.out.println(list);

        // Example of Collection shuffle method

        java.util.Collections.shuffle(list);
        System.out.println(list);

        // Example of Collection sort method

        java.util.Collections.sort(list);
        System.out.println(list);

        // Example of Collection swap method

        java.util.Collections.swap(list, 0, 2);
        System.out.println(list);

        // Example of Collection frequency method

        System.out.println(java.util.Collections.frequency(list, "z"));

        // Example of Collection disjoint method

        System.out.println(java.util.Collections.disjoint(list, list2));

        // Example of Arrays asList method

        String[] names = {"Adam", "Bob", "Dave", "Fred", "Joe", "Zack"};
        List<String> namesList = java.util.Arrays.asList(names);
        System.out.println(namesList);

        // Another example of Arrays asList method

        List<String> namesList2 = java.util.Arrays.asList("Adam", "Bob", "Dave", "Fred", "Joe", "Zack");
        System.out.println(namesList2);
        // This list is mutable - partially
        namesList2.set(0, "John");
        System.out.println(namesList2);
        // This will throw an exception
       try {
           namesList2.add("John");
       }catch (UnsupportedOperationException exception){
              System.out.println("Exception thrown " + exception);
       }

         // Example of Arrays copyOf method
        String[] names2 = {"Adam", "Bob", "Dave", "Fred", "Joe", "Zack"};
        String[] names3 = java.util.Arrays.copyOf(names2, 3);
        System.out.println(java.util.Arrays.toString(names3));



    }
}
