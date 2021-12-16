public class Solution210 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        for (int i = 0 ; i < prerequisites.length; i++) {
            for (int j = 0; j < ans.length; j++) {
                if (ans[j] == prerequisites[i][1]) {
                    break;
                }
            }
        }
        return ans;
    }
    
    public static int[] insertElement(int[] array, int index, int ele) {
        int[] result = new int[array.length + 1];
        boolean flag = false;
        for (int i = 0; i < result.length; i++) {
            if (flag) {
                result[i] = array[i - 1];
            } else {
                if (i == index) {
                    flag = true;
                    result[i] = ele;
                } else {
                    result[i] = array[i];
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] test = {1,2,4,5};
        System.out.println(insertElement(test, 2, 3));
    }
}