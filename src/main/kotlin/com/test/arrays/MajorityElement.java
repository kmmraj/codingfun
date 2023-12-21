package com.test.arrays;
// https://leetcode.com/problems/majority-element/
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class MajorityElement {

    class Solution {
        public int majorityElement(int[] nums) {

            Map<Integer, Integer> valueMap = new TreeMap();
            for(int index=0; index<nums.length; index++){
                if(valueMap.containsKey(nums[index])){
                    int value = valueMap.get(nums[index]) + 1;
                    valueMap.put(nums[index],value);
                } else {
                    valueMap.put(nums[index],1);
                }
            }

            TreeMap<Integer, Integer> sortedMap = (TreeMap<Integer, Integer>) valueSort(valueMap);
            return sortedMap.firstKey();

        }

        static <K, V extends Comparable<V>> Map<K, V> valueSort(final Map<K, V> map)
        {
            // Static Method with return type Map and
            // extending comparator class which compares values
            // associated with two keys
            // return comparison results of values of
            // two keys
            Comparator<K> valueComparator = (k1, k2) -> {
                int comp = map.get(k2).compareTo( map.get(k1));
                if (comp == 0)
                    return 1;
                else
                    return comp;
            };

            // SortedMap created using the comparator
            Map<K, V> sorted = new TreeMap<>(valueComparator);

            sorted.putAll(map);

            return sorted;
        }
    }

    // Moore's Voting Algorithm
    public int majorityElement(int[] nums) {

        int candidate =nums[0], count = 1;

        for(int index = 1; index< nums.length; index++){
            if(count == 0) {
                candidate = nums[index];
            }
            if(candidate == nums[index]){
                count++;
            } else{
                count--;
            }


        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println("The value should be 2 and the actual value is: " + new MajorityElement().new Solution().majorityElement(new int[]{2,2,1,1,1,2,2}));
        System.out.println("The value should be 3 and the actual value is: " + new MajorityElement().new Solution().majorityElement(new int[]{3,2,3}));

        System.out.println("The value should be 2 and the actual value is: " + new MajorityElement().majorityElement(new int[]{2,2,1,1,1,2,2}));
        System.out.println("The value should be 3 and the actual value is: " + new MajorityElement().majorityElement(new int[]{3,2,3}));
    }


}
