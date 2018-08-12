package alarmdotcom;

public class Pangrams {

	public static String isPangram(String[] strings) {
		char[] output = new char[strings.length];
		for (int i = 0; i < strings.length; i++) {
			if (strings[i].length() < 26) {
				output[i] = '0';
			}
			for (char c = 'a'; c <= 'z'; c++) {
				if (strings[i].indexOf(c) < 0) {
					output[i] = '0';
					break;
				} else {
					output[i] = '1';
				}
			}
		}
		String newOutput = new String(output);
		return newOutput;
	}

	public static void main(String[] args) {
		String[] strings = new String[4];
		strings[0] = "we promptly judged antique ivory buckles for the next prize";
		strings[1] = "we promptly judged antique ivory buckles for the prizes";
		strings[2] = "the quick brown fox jumps over the lazy dog";
		strings[3] = "the quick brown fox jump over the lazy dog";
		System.out.println(isPangram(strings));
	}
}
