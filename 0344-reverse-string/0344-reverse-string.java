class Solution {
    public void reverseString(char[] s) {
        String st=new String(s);
        int in=0;
      
        for(int i=st.length()-1;i>=0;i--){
            s[in]=st.charAt(i);
            in++;
            
        }
        
    }
}