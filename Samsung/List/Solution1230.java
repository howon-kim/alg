package samsung;

import java.io.FileInputStream;
import java.util.*;

// 1230. [S/W �����ذ� �⺻] 8���� - ��ȣ��3

public class Solution1230 {
	public static void main(String args[]) throws Exception
	{
		/*
		   �Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		   �������� �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��,
		   �� �ڵ带 ���α׷��� ó�� �κп� �߰��ϸ� ���� �Է��� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�.
		   ���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�.
		   ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
		 */
		System.setIn(new FileInputStream("./src/1230_input.txt"));

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
			ArrayList<Integer> arrayList = new ArrayList<>();
			int numOrigin = sc.nextInt();
			for (int i = 0 ; i < numOrigin; i++) {
				arrayList.add(sc.nextInt());
			}
			
			int numCommand = sc.nextInt();
			for (int i = 0 ; i < numCommand; i++) {
				String command =  sc.next();
				int start = sc.nextInt();
				int length;
				if (command.equals("I")) {
					length = sc.nextInt();
					for (int j = 0; j < length ; j++) {
						arrayList.add(start + j, sc.nextInt());
					}
				} else if (command.equals("D")) {
					length = sc.nextInt();
					for (int j = 0; j < length; j++) {
						arrayList.remove(start);
					}
				} else if (command.equals("A")) {
					for (int j = 0; j < start; j++) {
						arrayList.add(sc.nextInt());
					}
				}
			}
		
			System.out.print("#" + test_case);
			for (int i = 0 ; i < 10 ; i++) {
				System.out.print(" " + arrayList.get(i));
			}
			System.out.println();
		}
	}
}
