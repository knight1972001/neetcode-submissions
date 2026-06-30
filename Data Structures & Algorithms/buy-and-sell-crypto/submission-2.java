class Solution {
    public int maxProfit(int[] prices) {
        int left = 0, right = left + 1;
        int tempValue = 0;

        while (right < prices.length && left < right){
            if (prices[right] - prices[left] > 0){
                tempValue = Math.max(tempValue, prices[right] - prices[left]);
            }else{
                left = right;
            }
            right++;
        }

        return tempValue;
    }
}
