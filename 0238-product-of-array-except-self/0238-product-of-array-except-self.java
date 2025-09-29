class Solution {
    public int[] productExceptSelf(int[] A) {
        int pf[] = new int[A.length];
        int sf[] = new int[A.length];
        int ans[] = new int[A.length];
        pf[0]=A[0];
        for(int i=1;i<A.length;i++){
            pf[i]=pf[i-1]*A[i];
        }
        sf[A.length-1]=A[A.length-1];
        for(int i=A.length-2;i>=0;i--){
            sf[i]=sf[i+1]*A[i];
        }
        int l=1;
        int r=1;
        for(int i=0;i<A.length;i++){
            if(i==0){
                l=1;
            }
            else{
                l=pf[i-1];
            }
            if(i==A.length-1){
                r=1;
            }
            else{
                r=sf[i+1];
            }
             ans[i]=l*r;
        }
        return ans;
        }
       
    }