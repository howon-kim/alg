package samsung;

import java.io.FileInputStream;
import java.util.*;

//1225. [S/W �����ذ� �⺻] 7���� - ��ȣ������

public class PasswordGenerator {
	public static void main(String args[]) throws Exception
	{
		/*
		   �Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		   �������� �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��,
		   �� �ڵ带 ���α׷��� ó�� �κп� �߰��ϸ� ���� �Է��� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�.
		   ���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�.
		   ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
		 */
		System.setIn(new FileInputStream("./src/1225_input.txt"));

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
			Queue<Integer> queue = new LinkedList<>();
			int sub = 1;
			for (int i = 0 ; i < 8; i ++) {
				queue.add(sc.nextInt());	
			}
			
			boolean isZero = false;
			
			
			while (!isZero) {
				int first = queue.poll();
				first -= sub;
				if (first <= 0) {
					first = 0;
					isZero = true;
				}
				queue.add(first);
				sub = (sub % 5) + 1;
			}
			
			System.out.print("#" + testNum + " ");
			while (!queue.isEmpty()) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();
		}
	}
}
