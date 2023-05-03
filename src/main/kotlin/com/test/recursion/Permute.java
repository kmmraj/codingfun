package com.test.recursion;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class Permute {

    public List<List<Integer>> permute(int[] nums) {

        List<Integer> workingList = new ArrayList<>();
        List<List<Integer>> answerList = new ArrayList<>();
        solveItRecursively(nums,workingList,answerList);
        return answerList;
    }

    private void solveItRecursively(int[] nums, List<Integer> workingList, List<List<Integer>> answerList) {
        // BC
        if(nums.length == workingList.size()){
            answerList.add(new ArrayList<>(workingList));
            return;
        }

        //Choice Decision + Hypothesis

        for (int idx = 0; idx < nums.length; idx++) {

            if(workingList.contains(nums[idx]))
                continue;

            workingList.add(nums[idx]);
            solveItRecursively(nums,workingList,answerList);
            workingList.remove(workingList.size()-1);
        }

    }


    public List<List<Integer>> permuteUniqueUsingHM(int[] nums) {

        List<Integer> workingList = new ArrayList<>();
        List<List<Integer>> answerList = new ArrayList<>();
        HashMap<Integer,Integer> countMap = new HashMap<>();
        for (int idx = 0; idx < nums.length; idx++) {
            if(countMap.containsKey(nums[idx])){
                int count = countMap.get(nums[idx]);
                countMap.put(nums[idx],count+1);
            } else {
                countMap.put(nums[idx],1);
            }
        }
        solveItRecursivelyUniqueUsingHM(nums,workingList,answerList,countMap);
        return answerList;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<Integer> workingList = new ArrayList<>();
        List<List<Integer>> answerList = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        solveItRecursivelyUnique(nums,workingList,answerList,visited);
        return answerList;
    }

    private void solveItRecursivelyUniqueUsingHM(int[] nums,
                                          List<Integer> workingList,
                                          List<List<Integer>> answerList,
                                          HashMap<Integer,Integer> countMap) {
        // BC
        if(workingList.size() == nums.length){
            if(!answerList.contains(workingList)){
                answerList.add(new ArrayList<>(workingList));
            }
            return;
        }

        for (int idx = 0; idx < nums.length; idx++) {
            if(checkUniqueness(workingList,nums[idx],countMap))
                continue;
            workingList.add(nums[idx]);

            solveItRecursivelyUniqueUsingHM(nums,workingList,answerList,countMap);
            // Back tracking
            workingList.remove(workingList.size()-1);
        }
    }


    private void solveItRecursivelyUnique(int[] nums,
                                          List<Integer> workingList,
                                          List<List<Integer>> answerList,
                                          boolean[] visited) {
        // BC
        if(workingList.size() == nums.length){
            if(!answerList.contains(workingList)) {
                answerList.add(new ArrayList<>(workingList));
            }
            return;
        }

        for (int idx = 0; idx < nums.length; idx++) {
            if(visited[idx])
                continue;

            workingList.add(nums[idx]);
            visited[idx] = true;

            solveItRecursivelyUnique(nums,workingList,answerList,visited);

            // Back tracking
            workingList.remove(workingList.size()-1);
            visited[idx] = false;
        }
    }

    private boolean checkUniqueness(List<Integer> workingList, int num, HashMap<Integer, Integer> countMap) {
        Integer neededCount = countMap.get(num);
        long existingCount = workingList.stream().filter(it -> it == num).count();
        return neededCount == existingCount;
    }


    public static void main(String[] args) {

        Permute permute = new Permute();
        int[] nums = {1,2,3};
        System.out.println(permute.permute(nums));

        int[] nums1 = {1,2,1,1,1,2,3,1};
        Instant start = Instant.now();
        System.out.println(permute.permuteUnique(nums1));
        Instant end = Instant.now();
        Duration duration = Duration.between(start,end);
        System.out.println("Time taken using boolean: "+ duration.toMillis());

        start = Instant.now();
        System.out.println(permute.permuteUniqueUsingHM(nums1));
        end = Instant.now();
        duration = Duration.between(start,end);
        System.out.println("Time taken using HM: "+ duration.toMillis());
    }
}
