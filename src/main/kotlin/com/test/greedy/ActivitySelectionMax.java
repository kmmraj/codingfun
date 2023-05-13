package com.test.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ActivitySelectionMax {

    static class Activity implements Comparable<Activity> {
        String name;
        int start;
        int end;

        public Activity(String name, int start, int end) {
            this.name = name;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity activity) {
            return this.end - activity.end;
        }
    }

    List<Activity> activityList;

    public ActivitySelectionMax(List<Activity> activityList) {
        this.activityList = activityList;
    }

    private static List<Activity> getMaxActivities(List<Activity> activityList) {
        PriorityQueue<Activity> activityPriorityQueue = new PriorityQueue<>();
        activityPriorityQueue.addAll(activityList);
        List<Activity> selectedActivities = new ArrayList<>();

        Activity prevActivity = null;
        while (!activityPriorityQueue.isEmpty()){
            Activity currentActivity = activityPriorityQueue.poll();
            if (((prevActivity == null) ? 0 : prevActivity.end) < currentActivity.start) {
                prevActivity = currentActivity;
                selectedActivities.add(currentActivity);
            }
            activityPriorityQueue.remove(currentActivity);
        }
        return selectedActivities;
    }

    public static void main(String[] args) {
        Activity activity1 = new Activity("A1", 0, 6);
        Activity activity2 = new Activity("A2", 3, 4);
        Activity activity3 = new Activity("A3", 1, 2);
        Activity activity4 = new Activity("A4", 5, 8);
        Activity activity5 = new Activity("A5", 5, 7);
        Activity activity6 = new Activity("A6", 8, 9);

        List<Activity> activityList = List.of(activity1, activity2, activity3, activity4, activity5, activity6);

        List<Activity> selectedActivityList = ActivitySelectionMax.getMaxActivities(activityList);

        selectedActivityList.forEach(activity -> System.out.println(activity.name + " ( " + activity.start + " , " + activity.end + " )"));
    }


}
