class Solution {
    public int maxProfit(int[] prices) {
        int tempValue = 0;

        int left = 0, right = 1;

        while(right < prices.length){ // Left buy, right sell
            if(prices[right] - prices[left] >= 0){
                tempValue = Math.max(tempValue, prices[right] - prices[left]);
                right++;
            }else{
                left = right;
            }
        }

        return tempValue;
    }
}
