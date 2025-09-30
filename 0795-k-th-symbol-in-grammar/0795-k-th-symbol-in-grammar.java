class Solution {
    public int kthGrammar(int a, int b) {
        if(a==1){
            return 0;
        }
        int ans=kthGrammar(a-1,(b+1)/2);
        if(b%2==0){
            return 1-ans;
        }
        return ans;
        
    }
}