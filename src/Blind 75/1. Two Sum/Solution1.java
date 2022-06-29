import java.util.HashMap;

/* 
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
*/

public class Solution1 {
    // two for loops
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    // hashmap
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (hash.containsKey(diff)) {
                return new int[] {i, hash.get(diff)};
            }
            hash.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(twoSum1(nums, target));
    }
}
