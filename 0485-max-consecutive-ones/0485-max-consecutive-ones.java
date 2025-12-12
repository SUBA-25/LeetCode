class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int one=0;
        int max=0;

        for(int i:nums ){
            if(i==1){
                one++;
                max=Math.max(one,max);
            }else{
                
                one=0;
            }
        }
        return max;
        
    }
}