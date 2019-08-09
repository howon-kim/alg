/**
 * 42. Trapping Rain Water | Hard
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * My Submission Performance
 * Runtime: 3 ms, faster than 19.13% of Java online submissions for Trapping Rain Water.
 * Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Trapping Rain Water.
 *
 * Description
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 *
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */

class Solution {
    public int trap(int[] height) {

        /* Minimum Height is Three */
        if (height.length < 3) return 0;

        Queue <Integer> water = new LinkedList<>();
        int total = 0; int high = 0;

        /* From Left Approach */
        for (int h : height) {
            if (water.isEmpty() && h == 0) {}
            else {
                if (water.isEmpty()) {
                    high = h;
                    water.add(h);
                } else if (high > h) {
                    water.add(h);
                } else {
                    while (!water.isEmpty()) {
                        total += (high - water.poll());
                    }
                    high = h;
                    water.add(h);
                }
            }
        }

        /* From Right Approach */
        Stack <Integer> water2 = new Stack<>();
        while (!water.isEmpty()) {
            water2.add(water.poll());
        }
        high = water2.pop();
        int temp = 0;
        while (!water2.isEmpty()) {
            if (water2.peek() <= high) {
                temp += (high - water2.pop());
            }  else {
                high = water2.pop();
            }
        }
        return temp + total;
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] height = stringToIntegerArray(line);

            int ret = new Solution().trap(height);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}