/**
1109. Corporate Flight Bookings | Medium
https://leetcode.com/problems/corporate-flight-bookings/ 


There are n flights, and they are labeled from 1 to n.

We have a list of flight bookings.  The i-th booking bookings[i] = [i, j, k] means that we booked k seats from flights labeled i to j inclusive.

Return an array answer of length n, representing the number of seats booked on each flight in order of their label.

 

Example 1:

Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
Output: [10,55,45,25,25]
 

Constraints:

1 <= bookings.length <= 20000
1 <= bookings[i][0] <= bookings[i][1] <= n <= 20000
1 <= bookings[i][2] <= 10000


Runtime: 2 ms, faster than 100.00% of Java online submissions for Corporate Flight Bookings.
Memory Usage: 55 MB, less than 100.00% of Java online submissions for Corporate Flight Bookings.
O(n)
 */

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] seats = new int[n];
        for (int[] booking : bookings) {
            seats[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                seats[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            seats[i] = seats[i - 1] + seats[i];
        }
    
        return seats;
    }
}

