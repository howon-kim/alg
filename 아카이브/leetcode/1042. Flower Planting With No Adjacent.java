/**
 * 1042. Flower Planting With No Adjacent | Easy
 * https://leetcode.com/problems/flower-planting-with-no-adjacent/

 * MY SUBMISSION PERFORMANCE
 * Runtime: 84 ms, faster than 9.38% of Java online submissions for Flower Planting With No Adjacent.
 * Memory Usage: 55.4 MB, less than 100.00% of Java online submissions for Flower Planting With No Adjacent.

 * DESCRIPTION
 * You have N gardens, labelled 1 to N.  In each garden, you want to plant one of 4 types of flowers.
 * paths[i] = [x, y] describes the existence of a bidirectional path from garden x to garden y.
 * Also, there is no garden that has more than 3 paths coming into or leaving it.
 * Your task is to choose a flower type for each garden such that, for any two gardens connected by a path, they have different types of flowers.
 * Return any such a choice as an array answer, where answer[i] is the type of flower planted in the (i+1)-th garden.  The flower types are denoted 1, 2, 3, or 4.  It is guaranteed an answer exists.

 * Example 1:
 * Input: N = 3, paths = [[1,2],[2,3],[3,1]]
 * Output: [1,2,3]
 * Example 2:
 * Input: N = 4, paths = [[1,2],[3,4]]
 * Output: [1,2,1,2]
 * Example 3:
 * Input: N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
 * Output: [1,2,3,4]

 * Note:
 * 1 <= N <= 10000
 * 0 <= paths.size <= 20000
 * No garden has 4 or more paths coming into or leaving it.
 * It is guaranteed an answer exists.
 */

class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        if (paths.length == 0) {
            int[] answer = new int[N];
            for (int i = 0; i < N; i++) {
                answer[i] = 1;
            }
            return answer;
        }


        Map<Integer, Map<Integer, Boolean>> graph = new HashMap<>();
        Map<Integer, Integer> flower = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            HashMap<Integer, Boolean> temp = new HashMap<>();
            graph.put(i, temp);
        }

        for (int[] path : paths) {
            graph.get(path[0]).put(path[1], false);
            graph.get(path[1]).put(path[0], false);
        }

        for (Map.Entry<Integer, Map<Integer, Boolean>> entry : graph.entrySet()) {
            if (!flower.containsKey(entry.getKey())) {
                flower.put(entry.getKey(), 1);
            }
            int current = flower.get(entry.getKey());
            for (Map.Entry<Integer, Boolean> e : entry.getValue().entrySet()) {
                if (!flower.containsKey(e.getKey())) {
                    flower.put(e.getKey(), 1);
                }
                if (flower.get(e.getKey()) == flower.get(entry.getKey())) {
                    ArrayList<Integer> temp = new ArrayList<>();

                    for (Map.Entry<Integer, Boolean> t : graph.get(e.getKey()).entrySet()) {
                        temp.add(flower.get(t.getKey()));
                    }
                    for (int i = 1; i <= 4; i++) {
                        if (!temp.contains(i)) {
                            flower.put(e.getKey(), i);
                            i = 5;
                        }
                    }
                }
                graph.get(entry.getKey()).put(e.getKey(), true);
                graph.get(e.getKey()).put(entry.getKey(), true);
            }
        }

        int[] answer = new int[N];
        int index = 0;
        for (Integer i : flower.values()) {
            answer[index++] = i;
        }
        for (; index < N; index++) {
            answer[index] = 1;
        }
        return answer;
    }
}

