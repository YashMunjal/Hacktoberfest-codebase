//https://leetcode.com/problems/two-sum/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
       int [] ans  = new int[2]; // resultant array
       Map<Integer,Integer> map = new HashMap<>(); //for hashing 
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(target-nums[i]))
            {
                ans[0] = map.get(target-nums[i]);
                ans[1] = i;
                break;// solution found in O(n) time and space complexity
            }
            else
                map.put(nums[i],i);
        }
        return ans;
    }
}