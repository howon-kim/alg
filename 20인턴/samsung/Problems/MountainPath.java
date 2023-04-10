package samsung;

import java.io.FileInputStream;
import java.util.*;

public class MountainPath {
	static int maxLength;
	static int [][] mapSave;
	static boolean[][] isVisited;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("./src/1949_sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int size = sc.nextInt();
			int k = sc.nextInt();
			int [][] map = new int[size][size];
			HashMap<Integer, ArrayList<int[]>> hashMap = new HashMap<>();
			int max = 0;
			maxLength = 0;
			
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					int temp = map[i][j] = sc.nextInt();
					if (!hashMap.containsKey(temp)) hashMap.put(temp, new ArrayList<>());
					hashMap.get(temp).add(new int[] {i, j});
					if (max < temp) max = temp;
				}
			}
			
			for (int[] entry : hashMap.get(max)) {
				//System.out.println(entry[0] + " " + entry[1]);
				isVisited = new boolean[size][size];
				helper(map, entry[0], entry[1], k, size, 1, 9999, false, new LinkedList<>());
			}
			
			System.out.println("***" + maxLength);
		}
	}
	
	public static void helper(int[][] map, int x, int y, int k, int size, int length, int prev, boolean isShaved, Queue<int[]> q) {
		if (length > maxLength) maxLength = length;
		int [] dx = new int[] {1, -1, 0, 0};
		int [] dy = new int[] {0, 0, 1, -1};

		if (x >= 0 && y >= 0 && x < size && y < size) {		
			if (!isVisited[x][y]) {
				for (int i = 0; i < 4; i++) {
					x = x + dx[i];
					y = y + dy[i];
				if (!isShaved) {
					if (map[x][y] < prev) {
						prev = map[x][y];
					} else if (map[x][y] - prev < k) {
						prev -= 1;
						isShaved = true;
					} else {
						return;
					}
					isVisited[x][y] = true;
					helper(map, x, y, k, size, length + 1, prev, isShaved, q);
					isVisited[x][y] = false;
				} else {
					if (map[x][y] < prev) {
						prev = map[x][y];
						isVisited[x][y] = true;
						helper(map, x + dx[i], y + dy[i], k, size, length + 1, prev, isShaved, q);
						isVisited[x][y] = false;
					}
			}
				}
		}
	}
}}
