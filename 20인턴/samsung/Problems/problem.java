package samsung;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
/////////////////////////////////////////////////////////////////////////////////////////////
//기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
//아래 표준 입출력 예제 필요시 참고하세요.
//표준 입력 예제
//int a;
//double b;
//char g;
//String var;
//long AB;
//a = sc.nextInt();                           // int 변수 1개 입력받는 예제
//b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
//g = sc.nextByte();                          // char 변수 1개 입력받는 예제
//var = sc.next();                            // 문자열 1개 입력받는 예제
//AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
//표준 출력 예제
//int a = 0;                            
//double b = 1.0;               
//char g = 'b';
//String var = "ABCDEFG";
//long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

/*
사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class problem
{
	static int height;
	static int width;
	static int startVertical;
	static int startHorizontal;
	static int time;
	static int[][] map;
	static HashSet<ArrayList<Integer>> hashSet;
	static Queue<ArrayList<Integer>> queue;
	
	public static void main(String args[]) throws Exception
	{


		System.setIn(new FileInputStream("./src/1953_sample_input.txt"));
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			height = sc.nextInt();
			width = sc.nextInt();
			startVertical = sc.nextInt();
			startHorizontal = sc.nextInt();
			time = sc.nextInt();
			hashSet = new HashSet<>();
			queue = new LinkedList<>();
			
			map = new int[height][width];
			for (int i = 0 ; i < height; i ++) {
				for (int j = 0 ; j < width; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			if (time == 1) {
				System.out.println("hello");
				System.out.println("#" + test_case + " " + 1);
			} 
			
			ArrayList<Integer> current = new ArrayList<>();
			current.add(startVertical);
			current.add(startHorizontal);
			queue.add(current);
			hashSet.add(current);
			
			for (int i = 1; i < time; i++) {
				int size = queue.size();
				for (int j = 0 ; j < size; j++) {
					current = queue.poll();
					if (map[current.get(0)][current.get(1)] == 1) {
						toAbove(current);
						toBelow(current);
						toLeft(current);
						toRight(current);
					}
					else if (map[current.get(0)][current.get(1)] == 2) {
						toAbove(current);
						toBelow(current);
					}
					else if (map[current.get(0)][current.get(1)] == 3) {
						toLeft(current);
						toRight(current);
					}
					else if (map[current.get(0)][current.get(1)] == 4) {
						toAbove(current);
						toRight(current);
					}
					else if (map[current.get(0)][current.get(1)] == 5) {
						toBelow(current);
						toRight(current);
					}
					else if (map[current.get(0)][current.get(1)] == 6) {
						toLeft(current);
						toBelow(current);
					}
					else if (map[current.get(0)][current.get(1)] == 7) {
						toAbove(current);
						toLeft(current);
					}
				}
			}


			System.out.println("#" + test_case + " " + hashSet.size());
		}
	}
	
	
	
	public static boolean toAbove(ArrayList<Integer> location) {
		ArrayList<Integer> newLocation = new ArrayList<>();
		newLocation.add(location.get(0) - 1);
		newLocation.add(location.get(1));

		if (newLocation.get(0) >= 0 && !hashSet.contains(newLocation)
				&& (map[newLocation.get(0)][newLocation.get(1)] == 1
				|| map[newLocation.get(0)][newLocation.get(1)] == 2
				|| map[newLocation.get(0)][newLocation.get(1)] == 5
				|| map[newLocation.get(0)][newLocation.get(1)] == 6)) {
			queue.add(newLocation);
			hashSet.add(newLocation);
			return true;
		}
		else return false;
	}
	
	public static boolean toBelow(ArrayList<Integer> location) {
		ArrayList<Integer> newLocation = new ArrayList<>();
		newLocation.add(location.get(0) + 1);
		newLocation.add(location.get(1));
		if (newLocation.get(0) < height && !hashSet.contains(newLocation) 
				&& (map[newLocation.get(0)][newLocation.get(1)] == 1
				|| map[newLocation.get(0)][newLocation.get(1)] == 2
				|| map[newLocation.get(0)][newLocation.get(1)] == 4
				|| map[newLocation.get(0)][newLocation.get(1)] == 7)) {
			queue.add(newLocation);
			hashSet.add(newLocation);
			return true;
		}
		else return false;
	}
	
	public static boolean toLeft(ArrayList<Integer> location) {
		ArrayList<Integer> newLocation = new ArrayList<>();
		newLocation.add(location.get(0));
		newLocation.add(location.get(1) - 1);
		if (newLocation.get(1) >= 0 && !hashSet.contains(newLocation)
				&& (map[newLocation.get(0)][newLocation.get(1)] == 1
				|| map[newLocation.get(0)][newLocation.get(1)] == 3
				|| map[newLocation.get(0)][newLocation.get(1)] == 4
				|| map[newLocation.get(0)][newLocation.get(1)] == 5)) {
			queue.add(newLocation);
			hashSet.add(newLocation);
			return true;
		}
		else return false;
	}
	
	public static boolean toRight(ArrayList<Integer> location) {
		ArrayList<Integer> newLocation = new ArrayList<>();
		newLocation.add(location.get(0));
		newLocation.add(location.get(1) + 1);
		if (newLocation.get(1) < width && !hashSet.contains(newLocation) 
				&& (map[newLocation.get(0)][newLocation.get(1)] == 1
				|| map[newLocation.get(0)][newLocation.get(1)] == 3
				|| map[newLocation.get(0)][newLocation.get(1)] == 6
				|| map[newLocation.get(0)][newLocation.get(1)] == 7)) {
			queue.add(newLocation);
			hashSet.add(newLocation);
			return true;
		}
		else return false;
	}
	
}