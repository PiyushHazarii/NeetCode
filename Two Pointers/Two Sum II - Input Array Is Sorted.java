class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0;
        int right = n-1;
        while(left < right){
            int adddition = numbers[left] + numbers[right];
            if(left < right && adddition  > target)
                right--;
            else if(left < right && adddition < target)
                left++;
            else
               return new int[]{left+1,right+1};
        }
        return new int[0];
         
    }
}



// here is the same approach like two sum  just we have to return the 
// numbers + 1.
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

                HashMap<Integer , Integer> map = new HashMap<>();

                for(int i=0;i<n;i++)
                {
                    int remaining = target - numbers[i];

                    if(map.containsKey(remaining))
                    {
                        return new int[]{map.get(remaining)+1,i+1};
                    }
                    
                    map.put(numbers[i],i);
                }
                return new int[]{};
    }
}