class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        filter = set()

        for i in nums:
            if i in filter:
                return True
            else:
                filter.add(i)
    
        return False