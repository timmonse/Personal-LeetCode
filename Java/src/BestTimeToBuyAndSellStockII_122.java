class BestTimeToBuyAndSellStockII_122 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int sell = prices.length-1;
        int buy = prices.length-1;

        for (int i = prices.length - 1; i >= 0; --i) {
            if (prices[i] > prices[buy]) {
                if (sell > buy) {
                    profit += prices[sell] - prices[buy];
                }
                sell = i;
                buy = i;
            } else if (prices[i] < prices[buy]) {
                buy = i;
            }
        }

        if (sell > buy) {
            profit += prices[sell] - prices[buy];
        }

        return profit;
    }
}
