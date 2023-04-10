/**
 * 402. Remove K Digits | Medium
 * https://leetcode.com/problems/remove-k-digits/

 * My Submission Performance
 * Runtime: 4 ms, faster than 86.62% of Java online submissions for Remove K Digits.
 * Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Remove K Digits.

 * Description
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 *
 * Note:
 *
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 *
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 *
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */

class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }
        int current = 0; char temp = 0;
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < num.length(); i++) {
            temp = num.charAt(i);
            while (current > 0 && sb.charAt(current - 1) > temp && k > 0) {
                sb.deleteCharAt(--current);
                k --;
            }
            sb.append(temp);
            current++;
        }

        while (k != 0) {
            sb.deleteCharAt(--current);
            k--;
        }

        int index = 0;
        while (sb.length() > index && sb.charAt(index) == '0') {
            index++;
        }
        if (index == sb.length())  return "0";
        return sb.substring(index, current);
        /**
         int answer = 0;
         int [] temp = new int[num.length()];
         for (int i = 0; i < num.length(); i++) {
         temp[i] = Integer.parseInt(String.valueOf(num.charAt(i)));
         }
         int digits = temp.length - k;


         for (int i = 1; i < temp.length; i++) {
         if (digits <= 0) {
         for (int j = i; j < temp.length; j++) {
         if (answer % 10 > temp[j]) {
         answer = (answer / 10) + temp[j];
         }
         }
         return Integer.toString(answer);
         }

         if (temp[i - 1] <= temp[i]) {
         answer = (answer * 10) + temp[i - 1];
         digits--;
         } else {
         k--;
         }
         System.out.println(digits + " " + answer);

         if (k == 0) {
         for (int j = i; j < temp.length; j++) {
         answer = (answer * 10) + temp[j];
         }
         return Integer.toString(answer);
         }
         }
         if (digits > 0) {
         for (int j = temp.length - digits; j < temp.length; j++) {
         answer = (answer * 10) + temp[j];
         }
         return Integer.toString(answer);
         }
         return Integer.toString(answer);
         **/
    }
}