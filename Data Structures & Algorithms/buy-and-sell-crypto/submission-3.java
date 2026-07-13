class Solution {
    public int maxProfit(int[] prices) {
        int left = 0, right = 1; //left buy, right sell (right - left)
        int tempValue = 0;

        while(right < prices.length){
            if(prices[left] < prices[right]){
                tempValue = Math.max(tempValue, prices[right] - prices[left]);
            }else{
                left = right;
            }
            right++;
        }
        return tempValue;
    }
}
