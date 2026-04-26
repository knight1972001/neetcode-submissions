class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        temp_map = {}
        # init empty array with 26 length.
        freq = [[] for i in range(len(nums)+1)]
        count = 0

        # count and set into map
        for i in nums:
            if i not in temp_map:
                temp_map[i] = 1
            else:
                temp_map[i] += 1
        
        # for each count (since ccount will be 1,2,3,4), we set array of number. for example. at 2nd (index 1)
        # it will show all number appear 1. for example [5,3,5,4].. so here. [3,4] appear 1 time
        # so at 2nd (index 1) --> [[],[3,4],[5]]
        for num, count in temp_map.items():
            freq[count].append(num)
        
        res = []

        # so here. we are running from the end of array -> 0. 
        # it will take only the desc. so for example array length is 10. 
        # it will show all number appear 10th time (if any). -> to 0
        # in case, like above [3,4]. it will insert each. and check if length exceed k
        # other it will return.
        for i in range(len(freq)-1, 0, -1):
            for num in freq[i]:
                res.append(num)
                if len(res) == k:
                    return res
        return res