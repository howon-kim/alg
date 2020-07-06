package samsung;

import java.io.FileInputStream;
import java.util.*;

public class FindPath {
	static HashMap<Integer, ArrayList<Integer>> hashMap;
	static Boolean flag;
	
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		System.setIn(new FileInputStream("./src/1219_input.txt"));

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
