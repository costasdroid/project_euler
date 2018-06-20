package helperPackage;

public class Sets {
	
	//any permutation of a set and a given length
	public static void permutations(String set, String created, int length) {
		if (created.length() == length) {
			System.out.println(created);
			return;
		}
		for (int i = 0; i < set.length(); i++) {
			permutations(set, created + set.charAt(i), length);
		}
	}
	
	
	//pick any items of a given length of a set
	public static void combinations(String set, String created, int length) {
		if (created.length() == length) {
			System.out.println(created);
			return;
		}
		for (int i = 0; i < set.length(); i++) {
			combinations(set.substring(i+1), created + set.charAt(i), length);
		}
	}
	
}
