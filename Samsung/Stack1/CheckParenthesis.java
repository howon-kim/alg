package samsung;
import java.util.*;
import java.io.FileInputStream;

public class CheckParenthesis {
	/////////////////////////////////////////////////////////////////////////////////////////////
	//�⺻ �����ڵ�� ���� �����ص� ���� �����ϴ�. ��, ����� ���� ����
	//�Ʒ� ǥ�� ����� ���� �ʿ�� �����ϼ���.
	//ǥ�� �Է� ����
	//int a;
	//double b;
	//char g;
	//String var;
	//long AB;
	//a = sc.nextInt();                           // int ���� 1�� �Է¹޴� ����
	//b = sc.nextDouble();                        // double ���� 1�� �Է¹޴� ����
	//g = sc.nextByte();                          // char ���� 1�� �Է¹޴� ����
	//var = sc.next();                            // ���ڿ� 1�� �Է¹޴� ����
	//AB = sc.nextLong();                         // long ���� 1�� �Է¹޴� ����
	/////////////////////////////////////////////////////////////////////////////////////////////
	//ǥ�� ��� ����
	//int a = 0;                            
	//double b = 1.0;               
	//char g = 'b';
	//String var = "ABCDEFG";
	//long AB = 12345678901234567L;
	//System.out.println(a);                       // int ���� 1�� ����ϴ� ����
	//System.out.println(b); 		       						 // double ���� 1�� ����ϴ� ����
	//System.out.println(g);		       						 // char ���� 1�� ����ϴ� ����
	//System.out.println(var);		       				   // ���ڿ� 1�� ����ϴ� ����
	//System.out.println(AB);		       				     // long ���� 1�� ����ϴ� ����
	/////////////////////////////////////////////////////////////////////////////////////////////

	/*
����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
�̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
	 */

	public static void main(String args[]) throws Exception
	{
		/*
�Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
�������� �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��,
�� �ڵ带 ���α׷��� ó�� �κп� �߰��ϸ� ���� �Է��� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�.
���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�.
��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
		 */
		System.setIn(new FileInputStream("./src/1218_input.txt"));

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
			Stack<Character> stack = new Stack<>();
			int numTest = sc.nextInt();
			String curr = sc.next();

			for (char c: curr.toCharArray()) {
				if (!stack.isEmpty() && c != stack.peek() && ((int) c - (int) stack.peek() == 2 || (int) c - (int) stack.peek() == 1)) {
					//System.out.println(stack.peek() + " " + c);
					//System.out.println((int) stack.peek() + " " + (int) c);


					stack.pop();
				}
				else stack.add(c);
			}

			if (stack.isEmpty()) {
				System.out.println("#" + test_case + " " + 1);
			} else {
				System.out.println("#" + test_case + " " + 0);

			}
		}
	}
}
