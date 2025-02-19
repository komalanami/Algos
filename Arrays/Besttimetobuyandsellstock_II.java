package Arrays;

import java.util.Arrays;

public class Besttimetobuyandsellstock_II {
    //will result in TLE TC O(2^n) and SC O(N) -- recursive approach 
    public int maxProfit(int[] prices) {
        return f(0,1,prices);
    }

    public int f(int ind,int buy , int[] prices){
        if(ind == prices.length) return 0;
        int profit = 0;
        if(buy==1){
            profit = Math.max(-prices[ind]+f(ind+1,0,prices) ,
                               0+f(ind+1,1,prices) );
        }else{
            profit = Math.max(prices[ind]+f(ind+1,1,prices) ,
                               0+f(ind+1,0,prices) );
        }
        return profit;
    }
}
// <------------------------------------------------------------------->
//memoization approarch TC - O(n×2)=O(n) and SC - O(n) (dp array)+O(n) (recursion stack)=O(n)
class Solution{
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
        for (int i = 0; i < dp.length; i++) {
        Arrays.fill(dp[i], -1);
        }
        return f(0,1,prices,dp);
        
    }

    public int f(int ind,int buy , int[] prices,int[][] dp){
        if(ind == prices.length) return 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];
        int profit = 0;
        if(buy==1){
            profit = Math.max(-prices[ind]+f(ind+1,0,prices,dp) ,
                               0+f(ind+1,1,prices,dp) );
        }else{
            profit = Math.max(prices[ind]+f(ind+1,1,prices,dp) ,
                               0+f(ind+1,0,prices,dp) );
        }
        
        return dp[ind][buy] = profit;

    }

}
// <------------------------------------------------------------------->
//tabulation approach  TC O(N) and SC O(N)
class Solution {
    public int maxProfit(int[] prices) {
        return f(prices,prices.length);
        
    }
    public int f(int[] prices,int n){
        int dp[][] = new int[n+1][2];
        for (int i = 0; i < dp.length; i++) {
        Arrays.fill(dp[i], -1);
        }
        dp[n][0]=dp[n][1]=0;
        int profit = 0;
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + dp[ind + 1][0], -prices[ind] + dp[ind + 1][1]);
                }

                if (buy == 1) { // We can sell the stock
                    profit = Math.max(0 + dp[ind + 1][1], prices[ind] + dp[ind + 1][0]);
                }

                dp[ind][buy] = profit;
            }
        }
        return dp[0][0];

    }
}


//space optimization approach TC -O(n) and SC -	O(1)
class Solution {
    public int maxProfit(int[] prices) {
        return f(prices,prices.length);
        
    }

    public int f(int[] prices,int n){
        int[] ahead = new int[2];
        int[] cur = new int[2];

        ahead[0]=ahead[1]=0;
        int profit = 0;

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + ahead[0], -prices[ind] + ahead[1]);
                }

                if (buy == 1) { // We can sell the stock
                    profit = Math.max(0 + ahead[1], prices[ind] + ahead[0]);
                }
                cur[buy] = profit;
            }

            // Update the 'ahead' array with the current profit values
            System.arraycopy(cur, 0, ahead, 0, 2);
        }
        return cur[0];

    }    
}