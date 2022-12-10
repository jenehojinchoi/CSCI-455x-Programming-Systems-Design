public class S22Problem5 {
    public static int search(int[] nums, int target) {
        return searchR(nums, 0, target);
    }
    private static int searchR(int[] nums, int start, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums[start] == target) {
            return start;
        }
        return searchR(nums, start+1, target);
    }

    public static void main(String[] args) {
        int[] nums = {5};
        int target = 3;
        int ans = search(nums, target);
        System.out.println(ans);
    }
}