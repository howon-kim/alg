package samsung;

import java.io.FileInputStream;
import java.util.*;

public class FindPath {
	static HashMap<Integer, ArrayList<Integer>> hashMap;
	static Boolean flag;
	
	public static void main(String args[]) throws Exception
	{
		/*
		   �Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		   �������� �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��,
		   �� �ڵ带 ���α׷��� ó�� �κп� �߰��ϸ� ���� �Է��� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�.
		   ���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�.
		   ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
		 */
		System.setIn(new FileInputStream("./src/1219_input.txt"));

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
			int linkNum = sc.nextInt();
			hashMap = new HashMap<>();
			flag = false;
			
			for (int i = 0; i < linkNum; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				if (!hashMap.containsKey(from)) hashMap.put(from, new ArrayList<Integer>());
				hashMap.get(from).add(to);
			}
			helper(0);
			if (flag) System.out.println("#" + testNum + " " + 1);
			else System.out.println("#" + testNum + " " + 0);
		
		}
	}
	public static void helper(int curr) {		
		if (curr == 99) {
			flag = true; 
			return;
		}
		else if (!hashMap.containsKey(curr)) return;
		else if (hashMap.get(curr).isEmpty()) return;
		ArrayList<Integer> arrayList = hashMap.get(curr);
		for (int i = 0; i < arrayList.size(); i++) {
			int next = arrayList.get(i);
			helper(next);
		}	
	}

}
