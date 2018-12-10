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


    //由于当前最小路径和只由上一层相邻的两个数确定，若a[i][j]的值表示为a[0][0]到a[i][j]的最小路径和。那么它可表示为：
    //     a[i][j] += min(a[i-1][j],a[i-1][j-1]);
    //需要处理j=0 and j=i（第一列和最后一列）
    //
    //方法二：从下往上
    //a[i][j] += min(a[i+1][j],a[i+1][j+1]);
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0) {
            return 0;
        }
        int dp[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (i == n - 1) {
                    dp[j] = triangle.get(i).get(j); //dp[j]用于表示最小路径和
                } else {
                    //找到两个最小的值，将他们相加并赋值
                    dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
                }
            }
        }
        return dp[0];
    }


    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + list.get(j);
            }
        }
        return dp[0];
    }


}
