class Solution {
    public void sortColors(int[] nums) {
        int left = 0, i = 0, right = nums.length - 1;

        while (i <= right) {
            if (nums[i] == 0){
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                left++;
            }else if (nums[i] == 2){
                int temp = nums[right];
                nums[right] = nums[i];
                nums[i] = temp;
                right--;
                i--;
            }
            i++;
        }
    }
}