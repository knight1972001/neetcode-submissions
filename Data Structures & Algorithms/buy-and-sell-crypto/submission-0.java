class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2){
            return 0;
        }

        int maxProfit = 0, left = 0, right = left + 1;

        while(left < right && right < prices.length){
            if(prices[right] - prices[left] > 0){
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            }else if (prices[right] - prices[left] < 0){
                left = right;
            }
            right++;
        }
        return maxProfit;
    }
}
