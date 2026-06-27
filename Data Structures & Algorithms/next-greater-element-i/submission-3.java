class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // convert nums1 into map
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++){
            map.put(nums1[i], i);
        }

        // create stack, record all -> pop, peek, create filled Arr result
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);

        for (int num : nums2){
            while (!stack.isEmpty() && num > stack.peek()){
                int index = map.get(stack.pop());
                result[index] = num;
            }
            if (map.containsKey(num)){
                stack.push(num);
            }
        }
        return result;
    }
}