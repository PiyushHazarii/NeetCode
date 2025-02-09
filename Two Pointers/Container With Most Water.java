// this is the optimal approach where we take two pointer
class Solution {
    public int maxArea(int[] height) {
        int left =0;
        int right = height.length-1;
        int maxArea =0;
        while(left < right)
        {
            int width = right - left;
            // int heightOfVerticalLines = Math.min(height[left],height[right]);
            // int area = width * heightOfVerticalLines;
            int area = width * Math.min(height[left],height[right]);
            maxArea = Math.max(maxArea,area);
            // jo chota hoga usko move krna hai
            if(height[left] < height[right])
            {
                left++;
            }
            else 
            {
                right--;
            }
            
        }
        return maxArea;
        
    }
}


// this is the brute force method in which TLE are occured
// O(n^2) time complexity se bana rahe hai eas liye same approach lagega 
// optimal mein bhi but sirf two pointer approach lagega


class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxArea=Integer.MIN_VALUE;
        for(int i=0; i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int width = j-i;
                int heights = Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea,(heights*width));
            }
        }
        return maxArea;
    }
}
