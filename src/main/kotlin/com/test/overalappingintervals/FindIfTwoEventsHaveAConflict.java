package com.test.overalappingintervals;

import java.time.LocalTime;
import java.util.PriorityQueue;

// https://leetcode.com/problems/determine-if-two-events-have-conflict/
public class FindIfTwoEventsHaveAConflict {
    public boolean haveConflict(String[] event1, String[] event2) {

        PriorityQueue<LocalTime[]> timePriorityQueue = new PriorityQueue<>(event1.length + event2.length,
                (one, two) -> one[0].compareTo(two[1]));
        for (int idx = 0; idx + 1 < event1.length; idx = idx + 2) {
            if (event1[idx] != null && event1[idx + 1] != null)
                timePriorityQueue.add(new LocalTime[]{LocalTime.parse(event1[idx]), LocalTime.parse(event1[idx + 1])});
        }

        for (int idx = 0; idx + 1 < event1.length; idx = idx + 2) {
            if (event2[idx] != null && event2[idx + 1] != null)
                timePriorityQueue.add(new LocalTime[]{LocalTime.parse(event2[idx]), LocalTime.parse(event2[idx + 1])});
        }

        LocalTime[] prev = !timePriorityQueue.isEmpty() ? timePriorityQueue.poll() : null;
        while (!timePriorityQueue.isEmpty()) {
            LocalTime[] current = timePriorityQueue.poll();
            if (prev != null && ( prev[1].isAfter(current[0]) || prev[1].equals(current[0]) )) {
                return true;
            } else {
                prev = current;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        //Example 1:
        //
        //Input: event1 = ["01:15","02:00"], event2 = ["02:00","03:00"]
        //Output: true
        //Explanation: The two events intersect at time 2:00.
        //Example 2:
        //
        //Input: event1 = ["01:00","02:00"], event2 = ["01:20","03:00"]
        //Output: true
        //Explanation: The two events intersect starting from 01:20 to 02:00.
        //Example 3:
        //
        //Input: event1 = ["10:00","11:00"], event2 = ["14:00","15:00"]
        //Output: false
        //Explanation: The two events do not intersect.

        String[] event1 = new String[]{"01:15", "02:00"};
        String[] event2 = new String[]{"02:00", "03:00"};

        boolean isConflicting = new FindIfTwoEventsHaveAConflict().haveConflict(event1, event2);
        System.out.println("Is conflicting: " + isConflicting);

        event1 = new String[]{"01:00", "02:00"};
        event2 = new String[]{"01:20", "03:00"};

        isConflicting = new FindIfTwoEventsHaveAConflict().haveConflict(event1, event2);
        System.out.println("Is conflicting: " + isConflicting);

        event1 = new String[]{"10:00", "11:00"};
        event2 = new String[]{"14:00", "15:00"};

        isConflicting = new FindIfTwoEventsHaveAConflict().haveConflict(event1, event2);
        System.out.println("Is conflicting: " + isConflicting);

    }
}
