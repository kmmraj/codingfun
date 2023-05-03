package com.test.arrays;

import java.util.*;

public class TaskAssignment {

    public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        // Write your code here.
        HashMap<Integer,ArrayList<Integer>> taskIndexMap = createTaskIndex(tasks);
        tasks.sort(Comparator.naturalOrder());
        int idx = 0;
        int jdx = tasks.size()-1;
        ArrayList<ArrayList<Integer>> taskSets = new ArrayList<ArrayList<Integer>>();
        while (idx<jdx){
            int taskOne = taskIndexMap.get(tasks.get(idx)).get(0);
            taskIndexMap.get(tasks.get(idx)).remove(0);
            int taskTwo = taskIndexMap.get(tasks.get(jdx)).get(0);
            taskIndexMap.get(tasks.get(jdx)).remove(0);
           ArrayList<Integer> set = new ArrayList<Integer>(Arrays.asList(taskOne,taskTwo));
           taskSets.add(set);
           idx++;
           jdx--;
        }
        return taskSets;
    }

    private HashMap<Integer, ArrayList<Integer>> createTaskIndex(ArrayList<Integer> tasks) {

        HashMap<Integer,ArrayList<Integer>> taskIndexMap = new HashMap<>();
        for (int idx = 0; idx < tasks.size(); idx++) {
            if(taskIndexMap.containsKey(tasks.get(idx))){
                ArrayList<Integer> taskList = taskIndexMap.get(tasks.get(idx));
                taskList.add(idx);
                taskIndexMap.put(tasks.get(idx),taskList);
            } else {
                taskIndexMap.put(tasks.get(idx),new ArrayList<Integer>(Arrays.asList(idx)));
            }
        }
        return taskIndexMap;
    }

    public static void main(String[] args) {
        TestCase1();
    }

    public static void TestCase1() {
        int k = 3;
        ArrayList<Integer> tasks = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 3, 1, 4));
        ArrayList<ArrayList<Integer>> expected = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subarr = new ArrayList<Integer>(Arrays.asList(4, 2));
        ArrayList<Integer> subarr2 = new ArrayList<Integer>(Arrays.asList(0, 5));
        ArrayList<Integer> subarr3 = new ArrayList<Integer>(Arrays.asList(3, 1));
        expected.add(subarr);
        expected.add(subarr2);
        expected.add(subarr3);
        ArrayList<ArrayList<Integer>> actual = new TaskAssignment().taskAssignment(k, tasks);
        System.out.println(expected.equals(actual));
    }
}
