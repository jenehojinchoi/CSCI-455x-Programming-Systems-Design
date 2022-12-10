public class F19Problem1 {
    // max: Computes the maximum value in array nums
    // PRE: nums.length >= 1
    public static int max(int[] nums) {
        return maxR(nums, 1, nums[0]);
    }

    // maxR (tail-recursive helper function for max)
    // Computes the maximum value of maxSoFar and the sub-array of nums in
    // positions startLoc through nums.length-1
    // PRE: nums.length >= 1
    private static int maxR(int[] nums, int startLoc, int maxSoFar) {
        if (startLoc == nums.length) {
            return maxSoFar;
        }
        if (nums[startLoc] > maxSoFar) {
            return maxR(nums, startLoc + 1, nums[startLoc]);
        }
        return maxR(nums, startLoc + 1, maxSoFar);
    }

    public static void main(String[] args) {
        int[] arr = {1, 10, 100};
        System.out.println(max(arr));
    }
}