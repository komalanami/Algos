package Arrays;

//TC O(N) and SC O(1)
public class Besttimetobuyandsellstock_I {
    public int maxProfit(int[] prices) {
        int mini = prices[0];
        int profit = 0;
        for(int i=0;i<prices.length;i++){
            int cost = prices[i]- mini;
            profit = Math.max(profit,cost);
            mini = Math.min(mini,prices[i]);
        }

        return profit;
    
    }
}
