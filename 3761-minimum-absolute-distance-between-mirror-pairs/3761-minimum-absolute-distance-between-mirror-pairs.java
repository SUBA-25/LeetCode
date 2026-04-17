class Solution {
    public int minMirrorPairDistance(int[] nums) {
        // We'll keep the smallest distance found so far.
        // Start with a very large value (like infinity).
        int minDist = Integer.MAX_VALUE;
        
        // This map stores: reversed number -> its earliest index.
        // Why? When we later meet a number that equals this reversed value,
        // we know a mirror pair exists.
        Map<Integer, Integer> map = new HashMap<>();
        
        // i is the current index while iterating.
        int i = 0;
        
        // Walk through the array from left to right.
        for (int n : nums) {
            // Check: have we seen a number whose reverse equals the current number n?
            // Because if some previous number x had reverse(x) == n, then (index_of_x, i) is a mirror pair.
            if (map.containsKey(n)) {
                // Found a mirror pair. Update the minimum distance.
                // Since we traverse left to right, i is always greater than the stored index,
                // so i - map.get(n) is positive and equals the absolute distance.
                minDist = Math.min(minDist, i - map.get(n));
            }
            
            // Now compute the reverse of the current number.
            int rev = reverse(n);
            // Store this reverse value with the current index.
            // Future numbers equal to rev will find this entry and form a pair.
            map.put(rev, i);
            
            // Move to the next index.
            i++;
        }
        
        // If minDist never got updated, return -1. Otherwise return the found distance.
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
    
    // Helper function: reverse the digits of an integer.
    // Example: reverse(120) = 21 (leading zero is dropped automatically).
    private static int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }
}