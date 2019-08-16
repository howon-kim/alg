/**
 * 380. Insert Delete GetRandom O(1) | Medium
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 
 * My Submission Performance
 * Runtime: 53 ms, faster than 77.70% of Java online submissions for Insert Delete GetRandom O(1).
 * Memory Usage: 45.3 MB, less than 82.00% of Java online submissions for Insert Delete GetRandom O(1).
 
 * Description
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * Example:
 *
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 *
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 *
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 *
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 *
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 *
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 *
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 *
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 */


class RandomizedSet {
    HashMap<Integer, Integer> lists;
    ArrayList<Integer> values;
    int size;
    java.util.Random rand;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        lists = new HashMap<>();
        values = new ArrayList<>();
        size = 0;
        rand = new java.util.Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!lists.containsKey(val)) {
            lists.put(val, size);
            values.add(val);
            size++;
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (lists.containsKey(val)) {
            int pos = lists.get(val);
            int temp = values.get(size - 1);
            if (pos != (size - 1)) {
                values.set(pos, temp);
                lists.replace(temp, pos);
            }
            values.remove(size - 1);
            lists.remove(val);
            size--;
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return values.get(rand.nextInt(size));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */