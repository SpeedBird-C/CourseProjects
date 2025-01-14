import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Stack;
import java.util.Scanner;
import java.util.HashMap;

;

public class Lab13 {

	/**
	 * A method that takes in a string "message" and returns a string that has
	 * all of the words of the input string in reverse order. Use a stack to
	 * accomplish this.
	 * 
	 * @param message
	 *            - the input string
	 * @return result
	 */
	public static String printBack(String message) {
		Scanner sc = new Scanner(message);
		String msg = "";
		String word;
		Stack<String> s = new Stack<String>();
		String[] fields;
		while(sc.hasNext()){
			word = sc.next();
			word = word.replaceAll("[^A-Za-z0-9]", "");
			s.push(word);
		}
		/*msg = "";
		for (int i = 0; i < fields.length; i++) {
			fields[i] = fields[i].replaceAll("[^A-Za-z0-9]", "");
			s.push(fields[i]);
		}*/
		while(!s.isEmpty()){
			msg += " ";
			msg += s.pop();
		}
		return msg.trim();
	}

	/**
	 * A method that takes in a file written in a specific format: ... 1 James
	 * Grant Temes Warshaw Weber vs. Schnabel Mcnair Cosgrove Braun Crouse 0
	 * Temes Huttner Degger Seber Lane vs. Mcnair Weber Schnabel Oleson Sanford
	 * ... Your method will take in this file, and output the player (last name)
	 * with the most wins according to the file. A preceding 1 means the team
	 * before the "vs." won, and a 0 means the team before the "vs." lost.
	 * 
	 * Use a hashmap to accomplish this.
	 * 
	 * @param message
	 * @return result
	 */
	public static String compete(File tweets) throws FileNotFoundException {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		Scanner s = new Scanner(tweets);
		String str;
		String winner = "";
		String[] fields1;
		String[] fields2;
		int status;
		int largest = 0;
		while (s.hasNextLine()) {
			str = s.nextLine();
			status = Integer.parseInt(str.substring(0, 1));
			str = str.substring(1);
			fields1 = str.split("vs.");
			fields2 = fields1[0].split(" ");
			for (int i = 0; i < fields2.length; i++) {
				if(hm.containsKey(fields2[i]))
					hm.put(fields2[i], status + hm.get(fields2[i]));
				else
					if (fields2[i].length() >2)
						hm.put(fields2[i], status);
			}
			fields2 = fields1[1].split(" ");
			for (int i = 0; i < fields2.length; i++) {
				if (hm.containsKey(fields2[i]))
					hm.put(fields2[i], Math.abs(status - 1) + hm.get(fields2[i]));
				else
					if (fields2[i].length() >2)
						hm.put(fields2[i], Math.abs(status - 1));
			}
		}
		for (String key : hm.keySet()) {
			if (largest == 0 || hm.get(key) > largest) {
				largest = hm.get(key);
				winner = key;			}
		}
		return winner; 
	}

	// use this method to print out a map to debug your code
	public static void printMap(Map<String, Integer> m) {
		for (String s : m.keySet()) {
			System.out.println(s + ": " + m.get(s));
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		String reverseSent = printBack("Hello World! Look how far we've come!");
		// It should print: come weve far how Look World Hello
		System.out.println("Output of printBack() is : " + reverseSent);
		reverseSent = printBack("#@#@a%$%oweifjaowiejf!\n");
		System.out.println("Output of printBack() is : " + reverseSent);

		File tweets = new File("lab13test");
		String winner = compete(tweets);
		System.out.println("Winner is: " + winner);
	}

}
