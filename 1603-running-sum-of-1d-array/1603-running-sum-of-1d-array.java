class Solution {
    public int[] runningSum(int[] nums) {
        int n=nums.length;
        int pf[]=new int[n];
        pf[0]=nums[0];
        for(int i=1;i<n;i++){
            pf[i]=nums[i]+pf[i-1];

        }
        return pf;
        
    }
}