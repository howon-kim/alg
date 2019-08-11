/****************************************************************************
1122. Relative Sort Array | Easy
https://leetcode.com/problems/relative-sort-array/

* My Submission Performance
Runtime: 3 ms, faster than 41.30% of Java online submissions for Relative Sort Array.
Memory Usage: 36.2 MB, less than 100.00% of Java online submissions for Relative Sort Array.

* Description
Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  
Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.

Example 1:

Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]
 
Constraints:

arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
Each arr2[i] is distinct.
Each arr2[i] is in arr1.
****************************************************************************/

import java.util.Hashtable;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Hashtable<Integer, Integer> temp = new Hashtable<>();
        ArrayList<Integer> temp2 = new ArrayList<>();
        int[] answer = new int[arr1.length]; 
        for (int a1 : arr1) {
            if (temp.containsKey(a1)) {
                temp.put(a1, temp.get(a1) + 1);
            } else {
                temp.put(a1, 1);
            }
            temp2.add(a1);
        }
        int index = 0;
        for (int a2 : arr2) {
            if (temp.containsKey(a2)) {
                for (int i = 0; i < temp.get(a2); i++) {
                    answer[index++] = a2;
                    temp2.remove(new Integer(a2));
                }
                temp.remove(a2);
            }
        }
        Collections.sort(temp2);
        for (int a3 : temp2) {
            answer[index++] = a3;
        }
        
        return answer;
    }
}