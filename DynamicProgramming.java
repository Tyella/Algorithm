package com.example.demo.dao;

public class DynamicProgramming {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] len = new int[m+1][n+1];
        int max = 0;
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if (matrix[i-1][j-1]=='1') {
                    len[i][j] = Math.min(len[i-1][j-1], Math.min(len[i-1][j], len[i][j-1])) + 1;;
                }
                max = Math.max(max, len[i][j]);
            }
        }
        return max*max;
    }

}
