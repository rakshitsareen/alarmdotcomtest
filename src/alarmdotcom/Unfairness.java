package alarmdotcom;

import java.util.Arrays;

public class Unfairness {
	public static int distributeChocolates(int[] chocolatePackets, int n) {

		if (chocolatePackets == null || chocolatePackets.length == 0 || n == 0) {
			return Integer.MIN_VALUE;
		}

		Arrays.sort(chocolatePackets);
		System.out.println(Arrays.toString(chocolatePackets));

		int m = chocolatePackets.length;
		if (m < n) {
			return Integer.MIN_VALUE;
		}
		int minDiff = chocolatePackets[m - 1];
		int first = 0;
		int last = 0;
		int diff = 0;
		for (int i = 0; i + n - 1 < m; i++) {
			diff = chocolatePackets[i + n - 1] - chocolatePackets[i];
			if (diff < minDiff) {
				minDiff = diff;
				first = i;
				last = i + n - 1;
			}
		}
		return minDiff;

	}
}
