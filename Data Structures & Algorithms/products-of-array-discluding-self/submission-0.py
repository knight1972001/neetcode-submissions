class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        res = [1] * (len(nums))
        prefix = 1
        
        for i in range(len(nums)):
            res[i] = prefix
            prefix *= nums[i]

        postfix = 1
        for i in range(len(nums) -1, -1, -1):
            res[i] *= postfix
            postfix *= nums[i]

        return res



# 1 2 3 4

# i = 0 \/ res[0] = 1 \/ prefix = 1 * num[0] = 1
# i = 1 \/ res[1] = 1 \/ prefix = 1 * num[1] = 2
# i = 2 \/ res[2] = 2 \/ prefix = 2 * num[2] = 6
# i = 3 \/ res[3] = 6 \/ prefix = 6 * num[3] = 24

# postfix = 1 \/ 3 -> -1 
# 3 \/ res[3] = 6 * 1 = 6 \/ postfix = 1 * num[3] = 4
# 2 \/ res[2] = 2 * 4 = 8 \/ postfix = 4 * num[2] = 12
# 1 \/ res[1] = 1 * 12 = 12 \/ postfix = 12 * num[1] = 24
# 0 \/ res[0] = 1 * 24 = 24 \/ postfix = 24 * num[0] = 24