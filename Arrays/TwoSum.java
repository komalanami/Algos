package Arrays;
import java.util.HashMap;

public class TwoSum {

    //brute force o(n2) approach 
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for(int i=0;i<nums.length; i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i] + nums[j] == target)
                {
                    arr[0]=i;
                    arr[1]=j;
                    return arr;
                }   
            }
                
        }  
        
        return null;
    }

    //optimized approach using hashmap to store difference and index O(n)-TC and SC O(N) -wrost 
    //case in case have to traverse whole array 
    public int[] twosum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i}; // Found the pair
            }
            
            map.put(nums[i], i); // Store the current number and its index
        }
        
        return new int[]{}; // Return empty array if no solution exists
    }
}
