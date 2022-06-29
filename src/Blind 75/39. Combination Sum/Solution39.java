import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution39 {
    /*
    Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

    The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

    It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
    */

    // backtracking, also refer to:
    // 78. Subsets : https://leetcode.com/problems/subsets/
    // 90. Subsets II : https://leetcode.com/problems/subsets-ii/
    // 46. Permutations : https://leetcode.com/problems/permutations/
    // Permutations II (contains duplicates) : https://leetcode.com/problems/permutations-ii/
    // Combination Sum : https://leetcode.com/problems/combination-sum/
    // Combination Sum II (can't reuse same element) : https://leetcode.com/problems/combination-sum-ii/
    // Palindrome Partitioning : https://leetcode.com/problems/palindrome-partitioning/

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int sum = 7;
        List<List<Integer>> combination = combinationSum(nums, sum);
        System.out.print(combination);
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }
    
    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{ 
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}