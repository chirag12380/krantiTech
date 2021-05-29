import java.util.HashMap;

public class Question2 {
	public static void main(String[] args) {
		String str = "Given a sentence find number of times Given a a";
		String[] words = str.split(" ");
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for(String word:words) {
			if(hm.containsKey(word))
				hm.put(word, hm.get(word)+1);
			else
				hm.put(word, 1);
		}
		System.out.println(hm);
		
	}
}
