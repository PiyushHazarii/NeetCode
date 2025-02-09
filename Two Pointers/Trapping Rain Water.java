class Solution {
    public int []getLeftMax(int height[],int n)
    {
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for(int i=1; i<n; i++)
        {
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        } 
        return leftMax;       
    }
    public int []getRightMax(int height[] , int n)
    {
        int rightMax[] = new int[n];
        rightMax[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--)
        {
            rightMax[i] = Math.max(height[i],rightMax[i+1]);
        }
        return rightMax;
    }
    public int trap(int[] height) {

        int n = height.length;
        if(n==0)
        return 0;

        int leftMax[] = getLeftMax(height,n);
        int rightMAX[] = getRightMax(height,n);

        int sum =0;
        for(int i=0;i<n;i++)
        {
            sum += Math.min(leftMax[i] , rightMAX[i]) -height[i];
        }

        return sum;
    }
}