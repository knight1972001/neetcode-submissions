class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
      
        for i in range(len(nums)):
            if ((target - nums[i]) in nums) and i != nums.index(target - nums[i]):
                return sorted([i, nums.index(target - nums[i])])
        
        return [0,0]