class Solution {
    public String longestCommonPrefix(String[] strs) {
        String pre=strs[0];
        for(int i=1;i<strs.length;i++){
            while(!strs[i].startsWith(pre)){
                pre=pre.substring(0,pre.length()-1);
                if(pre.length()==0) return "";
            }
        }
        return pre;
        // if (strs == null || strs.length == 0) return "";
        
        // String pref = strs[0];
        // int prefLen = pref.length();

        // for (int i = 1; i < strs.length; i++) {
        //     String s = strs[i];
        //     while (prefLen > s.length() || !pref.equals(s.substring(0, prefLen))) {
        //         prefLen--;
        //         if (prefLen == 0) {
        //             return "";
        //         }
        //         pref = pref.substring(0, prefLen);
        //     }
        // }

        // return pref;        
    }
}






















