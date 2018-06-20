package problem106;

import java.util.ArrayList;

public class Solution106 {

	static int numbers = 12;
	static int counts = 0;

	static ArrayList<Integer> initialList = new ArrayList<Integer>(numbers);

	public static void main(String[] args) {

		long t = System.currentTimeMillis();

		for (int i = 1; i <= numbers; i++) {
			initialList.add(i);
		}
		
		permutationsOf(initialList, new ArrayList<>());
		
		int sol = counts / 2;
		
		System.out.println("Took: " + (System.currentTimeMillis() - t) + "ms");
		System.out.println("Answer: " + sol);
	}

	public static void permutationsOf(ArrayList<Integer> list, ArrayList<Integer> generated) {

		ArrayList<Integer> restList = new ArrayList<Integer>();
		for (int item : initialList) {
			if (!generated.contains(item))
				restList.add(item);
		}

		if (generated.size() > 0) {
			generatePair(generated, restList, new ArrayList<Integer>());
		}

		if (list.size() == 0) {
			return;
		}
		for (int index = 0; index < list.size(); index++) {
			ArrayList<Integer> rest = new ArrayList<>();
			rest.addAll(list.subList(index + 1, list.size()));
			generated.add(list.get(index));
			permutationsOf(rest, generated);
			generated.remove(generated.size() - 1);
		}
	}

	public static void generatePair(ArrayList<Integer> listA, ArrayList<Integer> list, ArrayList<Integer> generated) {
		if (generated.size() > 1 && generated.size() == listA.size()) {
			boolean asc = true;
			boolean des = true;
			for (int i = 0; i < generated.size(); i++) {
				asc = asc && listA.get(i) < generated.get(i);
				des = des && listA.get(i) > generated.get(i);
			}
			if (!(asc && !des || des && !asc)) {
				//System.out.println(listA + " ~ " + generated);
				counts++;
			}
		}
		
		if (list.size() == 0) {
			return;
		}
		for (int index = 0; index < list.size(); index++) {
			ArrayList<Integer> rest = new ArrayList<>();
			rest.addAll(list.subList(index + 1, list.size()));
			generated.add(list.get(index));
			generatePair(listA, rest, generated);
			generated.remove(generated.size() - 1);
		}
	}

}
