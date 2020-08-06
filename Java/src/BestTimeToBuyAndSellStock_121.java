class BestTimeToBuyAndSellStock_121 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        int sellIndex = prices.length - 1;

        for (int buyIndex = prices.length - 2; buyIndex >= 0; buyIndex--) {
            if (prices[sellIndex] - prices[buyIndex] > maxProfit) {
                maxProfit = prices[sellIndex] - prices[buyIndex];
            }
            if (prices[buyIndex] >= prices[sellIndex]) {
                sellIndex = buyIndex;
            }
        }

        return maxProfit;
    }
}
