/****************************************************
703. Kth Largest Element in a Stream | Easy
https://leetcode.com/problems/kth-largest-element-in-a-stream/

* My Submission Performance
Runtime: 58 ms, faster than 87.68% of Java online submissions for Kth Largest Element in a Stream.
Memory Usage: 44.9 MB, less than 96.67% of Java online submissions for Kth Largest Element in a Stream.

* Description
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.

Example:

int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8

Note: 
You may assume that nums' length ≥ k-1 and k ≥ 1.
****************************************************/

class KthLargest {
    PriorityQueue pq;
    int size;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<Integer>();
        size = k;
        for (int num: nums) {
            add(num);
        }
    }
    
    
    public int add(int val) {
        if (pq.size() < size) {
            pq.add(val);
        } else {
            if ((int) pq.peek() >= val) {
                return (int) pq.peek();
            } else {
                pq.poll();
                pq.add(val);
                return (int) pq.peek();
            }
        }
        return (int) pq.peek();
    }    
}


/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
