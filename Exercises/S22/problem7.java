import java.util.*;

public class problem7 {
    public static LinkedList<Integer> negativeIns(int[] nums) {
        LinkedList<Integer> neg = new LinkedList<Integer>();
        if (nums == null) {
            return neg;
        } else {
            if (nums[0] < 0) {
                neg.add(nums[0]);
                int[] copy = Arrays.copyOfRange(nums, 1, nums.length);
                neg = negativeIns(copy);
            } else {
                int[] copy = Arrays.copyOfRange(nums, 1, nums.length);
                neg = negativeIns(copy);
            }
        }
        return neg;
    }

    public static void main(String[] args) {
        int[] nums = {-7, 3, -12, -7, 4};
//        LinkedList<Integer> ans = negativeIns(nums);
//        ListIterator<Integer> iter = ans.listIterator();
//
//        while (iter.hasNext()) {
//            int i = iter.next();
//            System.out.println(i);
//        }
        int count = 88;
        System.out.println((char)(count + 48));
    }

}