class Solution {
    public int longestConsecutive(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);
        int count =0;
        int longest =0;
        int lastSmallest = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(nums[i]-1 == lastSmallest)
            {
                count+=1;
                lastSmallest = nums[i];
            }
            else if(nums[i] != lastSmallest)
            {
                count = 1;
                lastSmallest = nums[i];
            }
            longest = Math.max(longest,count);
        }
        return longest;
    }
}