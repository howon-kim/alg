package samsung;
//1222 - 1222. [S/W �����ذ� �⺻] 6���� - ����1

import java.io.FileInputStream;
import java.util.*;

public class CalculatorOne {
	public static void main(String args[]) throws Exception
	{
		/*
		   �Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		   �������� �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��,
		   �� �ڵ带 ���α׷��� ó�� �κп� �߰��ϸ� ���� �Է��� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�.
		   ���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�.
		   ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
		 */
		System.setIn(new FileInputStream("./src/1223_input.txt"));

		/*
		   ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=1;
		/*
		   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
		*/
		char[] priority = new char[2];
		priority['*' - 42] = 2;
		priority['+' - 42] = 1;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int testNum = sc.nextInt();
			char [] equation = new char[testNum];
			Stack<Character> stack = new Stack<>();
			int curr = 0;
			int total = 0;
			
			for (char c: sc.next().toCharArray()) {
				if (c != '+' && c != '*') {
					equation[curr++] = c;
				} else {
					if (stack.isEmpty()) stack.push(c);
					else if (priority[stack.peek()- 42] < priority[c - 42]) {
						stack.push(c);
					} else {
						char temp = stack.pop();
						equation[curr++] = temp;
						while (!stack.isEmpty() && priority[stack.peek()- 42] >= priority[temp- 42]) {
							temp = stack.pop();
							equation[curr++] = temp;
						}
					}
				}
			}
			for (char c : equation) {
				System.out.print(c);
			}
			
			Stack<Integer> stack2 = new Stack<Integer>();
			for (char c : equation) {
				curr = 0;
				if (c != '+' && c != '*') stack2.push(c - '0');
				else {
					if (c == '+') {
						curr = stack2.pop() + stack2.pop();
						stack2.push(curr);
					} else {
						curr = stack2.pop() * stack2.pop();
						stack2.push(curr);
					}
				}
				System.out.println(stack2.peek() + " " );
			}
			


			
			System.out.println("#" + test_case + " " + stack2.pop());
		}
	}
}
