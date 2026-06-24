class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int left = i + 1, right = nums.length - 1;
            while (left < right){
                if (nums[left] + nums[right] + nums[i] == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    right--;
                    left++;
                    while (left < right && nums[left] == nums[left-1]){
                        left++;
                    }
                }else{
                    if (nums[left] + nums[right] + nums[i] > 0){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
