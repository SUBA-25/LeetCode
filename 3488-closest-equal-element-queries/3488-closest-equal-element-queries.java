// Optimal Solution using binary Search
class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        /*
            <----- Key Idea ----->
            1.  Store all the values corresponding to index of queries in HashMap from nums.
            2.  Store like this: [<number at Index>, <array of all index>]
            3.  Run a loop to select ith query from queries.
            4.  store queryIndex and find list corresponding to that key.
            5.  If listSize is == 1, 
                -   It means only one element is present, so need to check for other just add "-1" according to question
            6.  If listSize > 1
                -   It means more than 1 element is present.
                -   Sort the array and find the queryIndex in list using binarySearch.
                -   Carefully check left and right index (because their is a possibility that queryIndex is 0th index, so it can cause error).
                -   Find Value at left and right Index in our list.
                -   Find diffrence btw
                        a.  diffLeft = "queryIndex & Left Index Value"
                        b.  circularDiffLeft = "numsLen - diffLeft"
                        c.  diffRight = "queryIndex & right Index Value" 
                        d.  circularDiffRight = "numsLen - diffRight"  
                -   Find minimum of all of the above.
                -   Add minDiffValue to res.
            7.  At the end just return res.  

            Note: Make sure u have to sort all the index values corresponding to each keys outside the main loop, otherwise time complexity will be n^2 logn and it will show TLE. 
        */
        int numsLen = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < numsLen; i++){
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);

            map.put(nums[i], list);
        }

        int queriesLen = queries.length;
        List<Integer> res = new ArrayList<>();

        for(List<Integer> list : map.values()){
            Collections.sort(list);
        }

        for(int i = 0; i < queriesLen; i++){
            int queryIndex = queries[i];
            int key = nums[queryIndex];

            List<Integer> list = map.get(key);
            int listSize = list.size();

            if(listSize == 1){
                res.add(-1);
                continue;
            }
            
            int minDiff = Integer.MAX_VALUE;
            // Collections.sort(list); // Here if i add this it will show TLE because, Time complexity = n^2 logn.

            int queryIndex_Position_InList = Collections.binarySearch(list, queryIndex);
            int queryIndex_LeftIndex = (queryIndex_Position_InList - 1 + listSize) % listSize;
            int queryIndex_RighttIndex = (queryIndex_Position_InList + 1) % listSize;

            int leftQueryIndex_Value = list.get(queryIndex_LeftIndex);
            int rightQueryIndex_Value = list.get(queryIndex_RighttIndex);

            int leftDiff = Math.abs(leftQueryIndex_Value - queryIndex);
            int leftDiffCircular = numsLen - leftDiff;

            int rightDiff = Math.abs(rightQueryIndex_Value - queryIndex);
            int rightDiffCircular = numsLen - rightDiff;

            int diff = Math.min(
                            Math.min(leftDiff, leftDiffCircular),
                            Math.min(rightDiff, rightDiffCircular)
                        );

            minDiff = Math.min(minDiff, diff);
            res.add(minDiff);

        }

        return res;
    }
}