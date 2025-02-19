package Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//three sum with TC O(n2) 

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();

        Arrays.sort(nums);
        for(int i=0;i<nums.length -2;i++){
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            addPairWithTargetSum(nums, -nums[i], i+1, triplets);
        }

        return triplets;
    }


    public static void addPairWithTargetSum(int[] a, int targetSum , int left ,List<List<Integer>> triplets ){
        int right = a.length - 1;
        while(left<right){
            int sum = a[left] + a[right];
            if(sum == targetSum) {
                triplets.add(Arrays.asList(-targetSum, a[left], a[right]));
                left++;
                right--;

                while(left < right && a[left] == a[left-1]) {
                    left++;
                }
                while(left < right && a[right] == a[right+1]) {
                    right--;
                }
            } else if(sum < targetSum) {
                left++;
            } else {
                right--;
            }
        }
    }
}
