package samsung;

import java.io.FileInputStream;
import java.util.*;

public class DessertCafe {
	static int max;
	static int size;
	static int [][] map;
	public static void main(String[] args) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		System.setIn(new FileInputStream("./src/2105_sample_input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			size = sc.nextInt();
			map = new int[size][size];
			max = -1;
			
			// Create the map
			for (int i = 0 ; i < size; i++) {
				for (int j = 0 ; j < size ; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			// Draw the rect
			for (int j = 1; j < size - 1 ; j++) {
				for (int k = 0; k < size - 2 ; k++) {
					for (int maxX = 1; maxX < size - 1; maxX++) {
						for (int maxY = 1; maxY < size - 1; maxY++) {
							helper(maxX, maxY, j, k, j, k);
						}
					}
				}
			}
			
			System.out.println("#" + test_case + " " + max);
		}

	}
	
	public static void helper (int maxLengthX, int maxLengthY, int x, int y, int originX, int originY) {
		if (x < 0 || y < 0 || x == size || y == size) return;
		HashSet<Integer> hashSet = new HashSet<>();
		hashSet.add(map[x][y]);
		int [] dx = {-1, 1, 1, -1};
		int [] dy = {1, 1, -1, -1};
		int [] order = {maxLengthX, maxLengthY, maxLengthX, maxLengthY};
		int length = 1;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < order[i]; j++) {
				x += dx[i];
				y += dy[i];
				if (x == originX && y == originY) break;
				if (x < 0 || y < 0 || x == size || y == size) return;
				if (hashSet.contains(map[x][y])) return;
				else hashSet.add(map[x][y]);
				
				length++;
			}
		}
		if (length > max) max = length;
		
	}
}
