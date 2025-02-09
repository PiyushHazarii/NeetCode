class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left =0;
        int right = n-1;
        String lowerCase = s.toLowerCase();
        while(left < right){
           while(left < right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;
           while(left < right && !Character.isLetterOrDigit(s.charAt(right)))
                right--;
           if(lowerCase.charAt(left) != lowerCase.charAt(right))
                return false;
           left++;
           right--;
        }
        return true;
    }
}