package com.test.arrays;
// https://leetcode.com/problems/jump-game/
public class CanReachEnd {

    public boolean canReachEnd(int[] nums) {
        int maxReach = 0;
        for(int idx=0; idx<nums.length; idx++){
//            if(idx>maxReach){ // if current index is greater than maxReach then we can't reach end
//                // Example: [3,2,0,0,2,0,1] if idx=4 then maxReach=3 and we can't reach end
//                return false;
//            }
            maxReach = Math.max(maxReach, idx+nums[idx]);
        }
        return maxReach>=nums.length-1;
    }

    public static void main(String[] args) {
        CanReachEnd canReachEnd = new CanReachEnd();
      //  System.out.println("Can reach end of [3,3,1,0,2,0,1] is true and result is " + canReachEnd.canReachEnd(new int[]{3, 3, 1, 0, 2, 0, 1}));
        System.out.println("Can reach end of [3,2,0,0,2,0,1] is false and result is " + canReachEnd.canReachEnd(new int[]{3, 2, 0, 0, 2, 0, 1}));
      //  System.out.println("Can reach end of [2,4,1,1,0,2,3] is true and result is " + canReachEnd.canReachEnd(new int[]{2, 4, 1, 1, 0, 2, 3}));
    }
}
