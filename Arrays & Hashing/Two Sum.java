class Solution {
    public int[] twoSum(int[] nums, int target) {
         // BRUTE FORCE METHOD 

        // int n = nums.length;
        // int result[] = new int[2];
        // for(int i=0;i<n-1;i++)
        // {
        //     for(int j=i+1;j<n;j++)
        //     {
        //         if(nums[i] + nums[j] == target)
        //         {
        //             result[0] = i;
        //             result[1] = j; ￼
        //         }
        //     }
        // return result; 





        // HashMap the efficient way


        int n = nums.length;

        HashMap<Integer , Integer> map = new HashMap<>();

        for(int i=0;i<n;i++)
        {
            int remaining = target - nums[i];

            if(map.containsKey(remaining))
            {
                return new int[]{map.get(remaining),i};
            }
            
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}