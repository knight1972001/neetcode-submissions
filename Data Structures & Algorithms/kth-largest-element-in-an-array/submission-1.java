class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    
    public int quickSelect(int[] nums, int left, int right, int k){
        int p = left;
        int pivot = nums[right];

        for (int i = left; i < right; i++){
            if (nums[i] <= pivot){
                swap(nums, i, p);
                p++;
            }
        }

        swap(nums, p, right); // p=4, k=length-3= 4 

        if (p < k){
            return quickSelect(nums, p+1, right, k);
        }else if (p > k){
            return quickSelect(nums, left, p-1, k);
        }else{
            return nums[p];
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
