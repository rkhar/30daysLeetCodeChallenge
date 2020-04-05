import java.util.*;

public class SingleNumber {
    /**
     * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
     * <p>
     * Note:
     * <p>
     * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     * <p>
     * Example 1:
     * <p>
     * Input: [2,2,1]
     * Output: 1
     * Example 2:
     * <p>
     * Input: [4,1,2,1,2]
     * Output: 4
     */

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 2, 1};
        int[] arr2 = new int[]{4, 1, 2, 1, 2};

        System.out.println(singleNumber1(arr1));
        System.out.println(singleNumber1(arr2));

        System.out.println(singleNumber2(arr1));
        System.out.println(singleNumber2(arr2));

        System.out.println(singleNumber3(arr1));
        System.out.println(singleNumber3(arr2));

        System.out.println(singleNumber4(arr1));
        System.out.println(singleNumber4(arr2));
    }

    /**
     * Approach 1: List operation
     * Algorithm
     * <p>
     * 1. Iterate over all the elements in nums
     * 2. If some number in nums is new to array, append it
     * 3. If some number is already in the array, remove it
     */

    /**
     * Complexity Analysis
     * <p>
     * Time complexity : O(n^2). We iterate through nums, taking O(n) time.
     * We search the whole list to find whether there is duplicate number, taking O(n) time.
     * Because search is in the for loop, so we have to multiply both time complexities which is O(n^2).
     * <p>
     * Space complexity : O(n). We need a list of size n to contain elements in nums.
     */

    public static int singleNumber1(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int value : nums) {
            if (!list.contains(value)) {
                list.add(value);
            } else list.remove(new Integer(value));
        }

        return list.get(0);
    }

    /**
     * Approach 2: Hash Table
     * Algorithm
     * <p>
     * We use hash table to avoid the O(n) time required for searching the elements.
     * <p>
     * Iterate through all elements in nums and set up key/value pair.
     * Return the element which appeared only once.
     */

    /**
     * Complexity Analysis
     * <p>
     * Time complexity : O(n*1)=O(n). Time complexity of for loop is O(n).
     * Time complexity of hash table(dictionary in python) operation pop is O(1).
     * <p>
     * Space complexity : O(n). The space required by table hash_table is equal to the number of elements in nums.
     */

    public static int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int value : nums)
            map.put(value, map.getOrDefault(value, 0) + 1);

        for (int value : nums) {
            if (map.get(value) == 1)
                return value;
        }

        return 0;
    }

    /**
     * Concept
     *
     * 2 * (a + b + c) - (a + a + b + b + c) = c
     */

    /**
     * Complexity Analysis
     * <p>
     * Time complexity : O(n + n) = O(n). sum will call next to iterate through nums.
     * We can see it as sum(list(i, for i in nums)) which means the time complexity is O(n)
     * because of the number of elements(n) in nums.
     * <p>
     * Space complexity : O(n+n)=O(n). set needs space for the elements in nums
     */

    public static int singleNumber3(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int sumOfSet = 0, sumOfNums = 0;

        for (int value : nums) {
            set.add(value);
            sumOfNums += value;
        }

        for (int value : set)
            sumOfSet += value;

        return 2 * sumOfSet - sumOfNums;
    }

    /**
     *Concept
     *
     * If we take XOR of zero and some bit, it will return that bit
     * a ^ 0 = a
     * If we take XOR of two same bits, it will return 0
     * a ^ a = 0
     * a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b
     * So we can XOR all bits together to find the unique number.
     */

    /**
     * Complexity Analysis
     * <p>
     * Time complexity : O(n). We only iterate through nums, so the time complexity is the number of elements in nums.
     * <p>
     * Space complexity : O(1).
     */
    public static int singleNumber4(int[] nums) {
        int result = 0;

        for (int value : nums)
            result ^= value;

        return result;
    }
}
