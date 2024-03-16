package com.test.linklist;
//https://leetcode.com/problems/sliding-window-maximum/description/

import java.util.*;

/**
 * 239. Sliding Window Maximum
 * Hard
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
public class SlidingWindowMaximumWithQueueMax {
    class MaxQueue {
        private Queue<Integer> entries;
        private Deque<Integer> maxValue;

        MaxQueue() {
            entries = new LinkedList<>();
            maxValue = new LinkedList<>();
        }

        void enque(Integer x) {
            entries.add(x);
            while (!maxValue.isEmpty()) {
                if (maxValue.getLast() >= x) {
                    break;
                }
                maxValue.removeLast();
            }
            maxValue.addLast(x);

        }

        Integer deque() {
            Integer result = entries.remove();
            if (result == maxValue.getFirst()) {
                maxValue.removeFirst();
            }
            return result;
        }

        Integer max() {
            return maxValue.getFirst();
        }

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        MaxQueue maxQ = new MaxQueue();
        int rdx = 0;

        for (int idx = 0; idx < nums.length; idx++) {
            maxQ.enque(nums[idx]);
            if (idx >= k - 1) {
                result[rdx++] = maxQ.max();
                maxQ.deque();
            }
        }
        return result;
    }

}
