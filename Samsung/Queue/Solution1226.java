package samsung;

import java.io.FileInputStream;
import java.util.Scanner;

// 1226. [S/W 문제해결 기본] 7일차 - 미로1


public class Solution1226 {
	static boolean flag;
	static boolean [][] isVisited;
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		System.setIn(new FileInputStream("./src/1226_input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int testNum = sc.nextInt();
			int[][] map = new int[16][16];
			isVisited = new boolean[16][16];
			flag = false;
			int [] start = new int[2];
			int [] end = new int[2];
			
			for (int i = 0 ; i < 16 ; i++) {
				char [] line = sc.next().toCharArray();
				for (int j = 0 ; j < 16 ; j++) {
					int curr = line[j] - '0';
					map[i][j] = curr;
					if (map[i][j] == 2) start = new int[] {i, j};
					if (map[i][j] == 3) end = new int[] {i, j};
				}
			}
			
			helper(start[0], start[1], end[0], end[1], map);
			if (flag) System.out.println("#" + testNum + " " + 1);
			else System.out.println("#" + testNum + " " + 0);
		}
		
	}
	
	public static void helper(int x, int y, int endX, int endY, int[][] map) {

		if (x < 0 || y < 0 || x >= 16 || y >= 16) return;
		if (isVisited[x][y] == true) return;

		if (map[x][y] == 3) flag = true;
		else {
			isVisited[x][y] = true;

			if (map[x - 1][y] != 1) helper(x - 1, y, endX, endY, map);
			if (map[x + 1][y] != 1) helper(x + 1, y, endX, endY, map);
			if (map[x][y - 1] != 1) helper(x, y - 1, endX, endY, map);
			if (map[x][y + 1] != 1) helper(x, y + 1, endX, endY, map);
		}

	}
}
