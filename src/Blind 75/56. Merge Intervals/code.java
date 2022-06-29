import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

// package Blind 75.56. Merge Intervals;

public class code {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> result =  new ArrayList<int[]>();

        int[] prev = intervals[0];
        int start = prev[0];
        int end = prev[1];
        for (int i = 1; i < intervals.length; i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];
            if (s <= end) {
                end = Math.max(e, end);
            } else {
                result.add(new int[] {start, end});
                start = s;
                end = e;
            }
        }
        result.add(new int[] {start, end});
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,4},{0,2},{3,5}};
        int[][] result = merge(intervals);
        System.out.println(Arrays.deepToString(result));
    }
}
