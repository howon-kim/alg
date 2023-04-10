/**
1394. Find Lucky Integer in an Array | Easy
https://leetcode.com/problems/find-lucky-integer-in-an-array/


Given an array of integers arr, a lucky integer is an integer which has a frequency in the array equal to its value.

Return a lucky integer in the array. If there are multiple lucky integers return the largest of them. If there is no lucky integer return -1.

 

Example 1:

Input: arr = [2,2,3,4]
Output: 2
Explanation: The only lucky number in the array is 2 because frequency[2] == 2.
Example 2:

Input: arr = [1,2,2,3,3,3]
Output: 3
Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.
Example 3:

Input: arr = [2,2,2,3,3]
Output: -1
Explanation: There are no lucky numbers in the array.
Example 4:

Input: arr = [5]
Output: -1
Example 5:

Input: arr = [7,7,7,7,7,7,7]
Output: 7
 

Constraints:

1 <= arr.length <= 500
1 <= arr[i] <= 500
 */

class Solution {
    public int findLucky(int[] arr) {
        int[] temp = new int[500];
        PriorityQueue<Integer> num = new PriorityQueue<>();
        
        for(int ar: arr) {
            temp[ar]++;
            num.add(-ar);
        }
        
        while(!num.isEmpty()) {
            int curr = -num.poll();
            if (temp[curr] == curr) {
                return curr;
            }
        }
        
        return -1;
        
        
        /** HashMap Version 
        Runtime: 8 ms, faster than 22.91% of Java online submissions for Find Lucky Integer in an Array.
        Memory Usage: 40.9 MB, less than 100.00% of Java online submissions for Find Lucky Integer in an Array.

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num: arr) {
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            } else {
                hashMap.put(num, hashMap.get(num) + 1);
            }
        }
        
        int ans = -1;
        for (Map.Entry<Integer, Integer> entry: hashMap.entrySet()) {
            if (entry.getKey() == entry.getValue()) {
                if (ans < entry.getKey()) {
                    ans = entry.getKey();
                }
            }
        }
        
        return ans;
        **/
    }
}