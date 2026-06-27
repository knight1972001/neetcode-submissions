class Solution {
    public boolean isPalindrome(int x) {
        char[] chArr = Integer.toString(x).toCharArray();

        int left = 0, right = chArr.length - 1;

        while (left < right){
            if(chArr[left] != chArr[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}