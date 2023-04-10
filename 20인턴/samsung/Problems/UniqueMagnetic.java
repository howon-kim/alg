package samsung;

import java.io.FileInputStream;
import java.util.*;

public class UniqueMagnetic {
	static final int NUM_MAGNET = 4;
	static final int NUM_SIDE = 8;
	static final int [] SCORE = new int[] {1, 2, 4, 8};
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("./src/4013_sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int numTest = sc.nextInt();
			int total = 0;
			ArrayList<LinkedList<Integer>> magnet = new ArrayList<>();
			
			for (int i = 0; i < NUM_MAGNET; i++) {
				LinkedList<Integer> temp = new LinkedList<>();
				for (int j = 0; j < NUM_SIDE; j++) {
					temp.add(sc.nextInt());
				}
				magnet.add(temp);
			}
		
			for (int i = 0; i < numTest; i++) {
				int order = sc.nextInt() - 1;
				int rotation = sc.nextInt();
				int [] move = new int[] {0,0,0,0};
				move[order] = rotation;
				
				for (int j = order - 1; j >= 0; j--) {
					if (magnet.get(j).get(2) != magnet.get(j + 1).get(6)) {
						move[j] = (move[j + 1] * -1); 
					} else {
						break;
					}
				}
				
				for (int j = order + 1; j < NUM_MAGNET; j++) {
					if (magnet.get(j).get(6) != magnet.get(j - 1).get(2)) {
						move[j] = (move[j - 1] * -1);
					} else {
						break;
					}
				}
				
				for (int j = 0; j < NUM_MAGNET; j++) {
					LinkedList<Integer> current = magnet.get(j);
					if (move[j] == -1) {
						current.addLast(current.getFirst());
						current.removeFirst();
					} else if (move[j] == 1) {
						current.addFirst(current.getLast());
						current.removeLast();
					}
				}
			}
			for (int j = 0; j < NUM_MAGNET; j++) {
				LinkedList<Integer> current = magnet.get(j);
				total += (current.get(0) * SCORE[j]);
			}

			System.out.println("#" + test_case + " " + total);
		}
	}
}
