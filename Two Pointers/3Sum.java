class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[left], nums[right]));

                    // if there are duplicate element like -1 , -1 are there in 
                    // first example
                    while(left < right && nums[left] == nums[left+1]) 
                        left++;

                    // same from the right
                    while(left < right && nums[right] == nums[right -1])
                        right--;
                    left++;
                    right--;
                }
                // agar sum zero se chota hua to left ko bhadayenge 
                // a/g to Binary search
                else if(sum < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return ans;
    }
}
