import java.io.File;

public class RecursionLab {
	public static int mysterySeries(int i, int j) {
		if (i < 0 || j < 0 || i < j)
			return 0;
		else if (i == 0 && j == 0)
			return 1;
		else if (i == 1 && j == 0)
			return 1;
		else if (i == 1 && j == 1)
			return 1;
		else
			return mysterySeries(i - 1, j) + mysterySeries(i - 1, j - 1);
	}

	public static int power(int a, int b) {
		if (b == 0)
			return 1;
		else
			return a * power(a, b - 1);
	}

	public static double goldenRatio(int n) {
		if (n == 0)
			return 1;
		else
			return 1 + 1 / goldenRatio(n - 1);
	}

	public static int fileCount(File f) {
		if (!f.isDirectory())
			return 1;
		else {
			int i = 1;
			for (File m : f.listFiles()) {
				i += fileCount(m);
			}
			return i;
		}
	}

	public static void hanoi(int n, char from, char to, char other) {
		if(n == 0)
			return;
		else {
			hanoi(n-1, from, other, to);
			System.out.println("move " + n + " from " + from + " to " + to);
			hanoi(n-1, other, to, from);
		}
	}
}
