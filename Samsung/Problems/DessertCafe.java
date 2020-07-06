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
		   �Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		   �������� �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��,
		   �� �ڵ带 ���α׷��� ó�� �κп� �߰��ϸ� ���� �Է��� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�.
		   ���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�.
		   ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
		 */
		System.setIn(new FileInputStream("./src/2105_sample_input.txt"));

		/*
		   ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
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
