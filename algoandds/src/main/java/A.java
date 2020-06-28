import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class A {
	public static void main(String args[]) {
		System.out.println(myPow(2.00000, -2147483648));
	}

	public static double myPow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Math.abs(Integer.MIN_VALUE+1));
		if(n==Integer.MIN_VALUE) {
			return 0;
		}
		double ans = 1;
		double multi = x;
		for (int i = Math.abs(n); i > 0; i = i / 2) {
			if (i % 2 != 0) {
				ans = multi * ans; // x x3 x7
			}
			multi = multi * multi; // x2 x4 x8
		}
		return n > 0 ? ans : 1 / ans;
	}
}
