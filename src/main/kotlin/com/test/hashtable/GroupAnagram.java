package com.test.hashtable;
// https://leetcode.com/problems/group-anagrams/

/**
 * 49. Group Anagrams
 * Medium
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 *
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */

import java.util.*;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mapOfSortedChars = new HashMap<>();
        for (int idx = 0; idx < strs.length; idx++) {
            char[] charArray = strs[idx].toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            mapOfSortedChars.computeIfAbsent(sortedString, key -> new ArrayList<>());
            mapOfSortedChars.get(sortedString).add(strs[idx]);
        }

        Set<Map.Entry<String, List<String>>> sortedCharsEntrySet = mapOfSortedChars.entrySet();
        List<List<String>> result= new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : sortedCharsEntrySet){
            result.add(entry.getValue());
        }

        return result;
    }

    public static void main(String[] args) {
        GroupAnagram groupAnagram = new GroupAnagram();
        System.out.println("groupAnagram.groupAnagrams(new String[]{\"eat\",\"tea\",\"tan\",\"ate\",\"nat\",\"bat\"}) = "
                + groupAnagram.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println("groupAnagram.groupAnagrams(new String[]{\"\"}) = " + groupAnagram.groupAnagrams(new String[]{""}));
        System.out.println("groupAnagram.groupAnagrams(new String[]{\"a\"}) = " + groupAnagram.groupAnagrams(new String[]{"a"}));
    }
}