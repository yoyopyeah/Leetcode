import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Given an integer array nums, return true if any value appears at
// least twice in the array, and return false if every element is distinct.

public class Solution217 {
    // sort array and find duplicates
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    // using Hashmap
    public static boolean containsDuplicate2(int[] nums) {
        Map <Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) return true;
            map.put(nums[i], i);
        }
        return false;
    }

    // using Hashset
    public static boolean containsDuplicate3(int[] nums) {
        Set <Integer> distinct = new HashSet <Integer>();
        for(int num : nums) {
            if(distinct.contains(num)) {
                return true;
            }
            distinct.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 2};
        System.out.println(containsDuplicate(nums));
    }
}
