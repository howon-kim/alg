/*********************************************************************************
167. Two Sum II - Input array is sorted | Easy
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

* My Submission Performance
Runtime: 0 ms, faster than 100.00% of Java online submissions for Two Sum II - Input array is sorted.
Memory Usage: 37.8 MB, less than 99.25% of Java online submissions for Two Sum II - Input array is sorted.

* Description
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.

Example:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
*********************************************************************************/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0; int right = numbers.length - 1;
        while (left != right) {
            int total = numbers[left] + numbers[right];
            //long total = numbers[left] + numbers[right] // Runtime +1ms
            if (total == target) {
                return new int[]{left+1, right+1};
            } else if (total < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
        
        /* When there is more than one pair *
        int index1 = 0; int index2 = 1;
        int [] answer = new int[numbers.length];
        while (index1 != numbers.length) {
            while (index2 != numbers.length) {
                if (numbers[index1] + numbers[index2] == target) {
                    answer[index1] = 1;
                    answer[index2] = 1;
                } else if (numbers[index1] + numbers[index2] > target) {
                    break;
                }
                index2++;
            }
            index2 = ++index1 + 1;
        }
        int temp = 0;
        int index = 0;
        while (temp != answer.length) {
            if (answer[temp] == 1) {
                answer[index] = temp + 1;
                index++;
            }
            temp++;
        }
        return Arrays.copyOfRange(answer, 0, index);
        */
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] numbers = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);
            
            int[] ret = new Solution().twoSum(numbers, target);
            
            String out = integerArrayToString(ret);
            
            System.out.print(out);
        }
    }
}
