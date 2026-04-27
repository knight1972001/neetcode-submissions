class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        # arr -> set (unique)
        num_set = set(nums)
        longest = 0

        # check if num - 1 in not in set == it means this number is smallest. we can start checking number greater
        # if num - 1 in set, it means this number is not smallest. we can start with it later.
        for num in num_set:
            if (num-1) not in num_set:
                length = 1
                while (num+length) in num_set:
                    length += 1
                longest = max(length, longest)
        
        return longest


        # checking greater number by that num + length must be in the set.

        # compare longest and current length. get the max
        