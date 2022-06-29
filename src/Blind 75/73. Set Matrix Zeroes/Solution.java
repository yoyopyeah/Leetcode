import java.util.ArrayList;
import java.util.List;

// package Blind 75.73. Set Matrix Zeroes;

/* 
https://leetcode.com/problems/set-matrix-zeroes/
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.
You must do it in place.
*/ 

public class Solution {
    public void setZeroes1(int[][] matrix) {
        List<Integer> xs = new ArrayList<Integer>();
        List<Integer> ys = new ArrayList<Integer>();

        // find the zeros
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    xs.add(i);
                    ys.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (xs.contains(i) || ys.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }


    // O(1)
    private int rowLen;
    private int colLen;
    private int change;
    public void setZeroes(int[][] matrix) {
        rowLen = matrix.length;
        colLen = matrix[0].length;
        boolean rowAffect = false;
        boolean colAffect = false;

        for (int i=0;i<rowLen;i++){
            for (int j=0;j<colLen;j++){
                if (matrix[i][j] == 0){

                    if (i==0) rowAffect = true;
                    if (j==0) colAffect = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        

       for (int i=1;i<rowLen;i++){
            for (int j=1;j<colLen;j++){
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        

        if (rowAffect){
            cleanRow(0,matrix);
        }
        

        if (colAffect){
            cleanCol(0,matrix);
        }
        
    }
    
    private void cleanRow(int row,int[][] matrix){
        for (int j=0;j<colLen;j++){
                matrix[row][j] = 0;
        }
    }
    
    private void cleanCol(int col, int[][] matrix){
        for (int i=0;i<rowLen;i++){
             matrix[i][col] = 0;
        }
    }
}
