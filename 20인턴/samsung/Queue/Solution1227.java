package samsung;

import java.io.FileInputStream;
import java.util.Scanner;

// 1227. [S/W �����ذ� �⺻] 7���� - �̷�2


public class Solution1227 {
	static boolean flag;
	static boolean [][] isVisited;
	static int SIZE = 100;
	public static void main(String args[]) throws Exception
	{
		/*
		   �Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		   �������� �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��,
		   �� �ڵ带 ���α׷��� ó�� �κп� �߰��ϸ� ���� �Է��� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�.
		   ���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�.
		   ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
		 */
		System.setIn(new FileInputStream("./src/1227_input.txt"));

		/*
		   ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
		/*
		   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int testNum = sc.nextInt();
			int[][] map = new int[SIZE][SIZE];
			isVisited = new boolean[SIZE][SIZE];
			flag = false;
			int [] start = new int[2];
			
			for (int i = 0 ; i < SIZE ; i++) {
				char [] line = sc.next().toCharArray();
				for (int j = 0 ; j < SIZE ; j++) {
					int curr = line[j] - '0';
					map[i][j] = curr;
					if (map[i][j] == 2) start = new int[] {i, j};
				}
			}
			
			helper(start[0], start[1], map);
			if (flag) System.out.println("#" + testNum + " " + 1);
			else System.out.println("#" + testNum + " " + 0);
		}
		
	}
	
	public static void helper(int x, int y, int[][] map) {

		if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) return;
		if (isVisited[x][y] == true) return;

		if (map[x][y] == 3) flag = true;
		else {
			isVisited[x][y] = true;

			if (map[x - 1][y] != 1) helper(x - 1, y, map);
			if (map[x + 1][y] != 1) helper(x + 1, y, map);
			if (map[x][y - 1] != 1) helper(x, y - 1, map);
			if (map[x][y + 1] != 1) helper(x, y + 1,  map);
		}

	}
}
