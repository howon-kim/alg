package samsung;
//1222 - 1222. [S/W 문제해결 기본] 6일차 - 계산기1

import java.io.FileInputStream;
import java.util.*;

public class CalculatorOne {
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		System.setIn(new FileInputStream("./src/1223_input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=1;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
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
