package com.example.demo.dao;

public class DynamicProgramming {

    //最大正方形
    //动态规划
    //递推公式为len[i][j]=min{len[i]j-1],len[i-1][j],len[i-1][j-1]}+1
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] len = new int[m + 1][n + 1];
        //最大边长
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    //len[i][j]来记录以点i,j为右下角的，值全为1的矩阵的最大边长
                    //len[i][j]的值与len[i-1][j-1],len[i][j-1],len[i-1][j]的值有关
                    //若这三个有一个为0，则len[i][j]必为0
                    len[i][j] = Math.min(len[i - 1][j - 1], Math.min(len[i - 1][j], len[i][j - 1])) + 1;
                }
                max = Math.max(max, len[i][j]);
            }
        }
        return max * max;
    }
    

}
