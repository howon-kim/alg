/**
 * 347. Top K Frequent Elements | Medium | 
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Performance
 * Runtime: 23 ms, faster than 52.21% of Java online submissions for Top K Frequent Elements.
 * Memory Usage: 40.4 MB, less than 69.83% of Java online submissions for Top K Frequent Elements.
 *
 * Description
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */


class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        ArrayList<HashSet<Integer>> alist = new ArrayList<>();
        HashMap<Integer, Integer> hmap = new HashMap();

        for (int num: nums) {
            int n = 0;
            if(!hmap.containsKey(num)) {
                hmap.put(num, 1);
            } else {
                n = hmap.get(num);
                hmap.replace(num, n + 1);
                alist.get(n - 1).remove(num);
            }

            if (n >= alist.size()) {
                HashSet<Integer> t = new HashSet<>();
                t.add(num);
                alist.add(t);
            } else {
                HashSet<Integer> t = alist.get(n);
                t.add(num);
            }
        }

        int index = 0;
        int size = alist.size();
        ArrayList<Integer> ans = new ArrayList<>();
        while (index < k) {
            HashSet<Integer> t = alist.get(--size);
            if (t.size() != 0) {
                for (int i: t) {
                    ans.add(i);
                    if (index == k - 1) {return ans;}
                    index++;
                }
            }
        }
        return ans;
    }
}


