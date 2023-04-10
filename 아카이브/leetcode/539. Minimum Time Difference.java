/*
539. Minimum Time Difference | Medium
https://leetcode.com/problems/minimum-time-difference/


Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.
Example 1:

Input: ["23:59","00:00"]
Output: 1
Note:

The number of time points in the given list is at least 2 and won't exceed 20000.
The input time is legal and ranges from 00:00 to 23:59.


Runtime: 1 ms, faster than 100.00% of Java online submissions for Minimum Time Difference.
Memory Usage: 38.9 MB, less than 60.00% of Java online submissions for Minimum Time Difference.
Efficiency: O(24 * 60) = O(1)
*/

class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean [] array = new boolean[24 * 60];
        for (String point: timePoints) {
            int hour = Integer.parseInt(point.substring(0, 2));
            int min = Integer.parseInt(point.substring(3, 5));
            if (array[hour * 60 + min]) return 0;
            array[hour * 60 + min] = true;
        }
        
        int min = 1441; 
        int first = 1441;
        int prev = -1441; 
        for (int i = 0; i < array.length; i++) {
            if (array[i]) {
                if (first == 1441) {
                    first = i;
                }
                min = Math.min(min, i - prev);
                prev = i;
            } 
        }
        
        if (24 * 60 - prev + first < min) {
            min = 24 * 60 - prev + first;
        }
        
        return min;
            
        /** Priority Queue : O(log(N))
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int min = Integer.MAX_VALUE;
        int first = Integer.MAX_VALUE;
        int prev = 0; int last = 0;
        while(!pq.isEmpty()) {
            if (first == Integer.MAX_VALUE) {
                first = prev = pq.poll();
            }  else {
                last = pq.poll();
                if (last - prev < min) {
                    min = last - prev;
                }
                prev = last;
            }
        }
        
        if ((24 * 60 - last) + first < min) {
            min = (24 * 60 - last) + first;
        }

        return min;
        **/
    }
}