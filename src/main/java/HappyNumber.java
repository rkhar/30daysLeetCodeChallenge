import java.util.*;

/**
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example:
 * <p>
 * Input: 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */

public class HappyNumber {

    public static void main(String[] args) {
        int number = 19;

        System.out.println(happyNumber1(number));

        System.out.println(happyNumber2(number));
    }

    public static boolean happyNumber1(int num) {
        HashSet<Integer> set = new HashSet<>();

        while (set.add(num)) {
            int squareSum = 0;
            while (num > 0) {
                int remain = num % 10;
                squareSum += remain * remain;
                num /= 10;
            }
            if (squareSum == 1)
                return true;
            else num = squareSum;
        }

        return false;
    }

    static int digitSquareSum(int n) {
        int sum = 0, tmp;
        while (n > 0) {
            tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }

    static boolean happyNumber2(int n) {
        int slow, fast;
        slow = fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
            if(fast == 1) return true;
        } while(slow != fast);
        return false;
    }
}
