import java.util.Arrays;

class Solution {
    public static boolean CircularArray (int[] nums) {
        int size = nums.length;
        for (int i = 0; i <size; i++) {
            int slow = i, fast = i;
            boolean forward = nums[i] >= 0;
            while(true) {
                slow = nextStop(slow, nums[slow], size);
                if(isnotCircular(nums, forward, slow))
                    break;
                fast = nextStop (fast, nums[fast], size);
                if (isnotCircular(nums, forward, fast))
                    break;
                fast = nextStop (fast, nums[fast], size);
                if (isnotCircular(nums, forward, fast))
                    break;
                if (slow == fast)
                    return true;
            }
        }
        return false;
    }
    public static int nextStop(int pointer, int value, int size) {
        int result = (pointer + value) % size;
        if (result < 0)
            return result += size;
        return result;
    }
    public static boolean isnotCircular(int [] nums, boolean preDirection, int pointer) {
        boolean currDirection = nums[pointer] >= 0;
        if (currDirection != preDirection || nums[pointer] % nums.length == 0)
            return true;
        return false;
    }
    public static void main(String[] args) {
        int[][] input = {
                {-2, -3, -9},
                {-5, -4, -3, -2, -1},
                {-1, -2, -3, -4, -5},
                {2, 1, -1, -2},
                {-1, -2, -3, -4, -5, 6},
                {1, 2, -3, 3, 4, 7, 1},
                {2, 2, 2, 7, 2, -1, 2, -1, -1}
        };

        for (int i = 0; i < input.length; i++) {
            System.out.println((i + 1) + ".\tCircular array = " + Arrays.toString(input[i]) + "\n");
            boolean result = CircularArray(input[i]);
            System.out.println("\tFound Loop = " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}