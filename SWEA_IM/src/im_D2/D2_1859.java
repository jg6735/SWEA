package im_D2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D2_1859 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input/1859.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			int n = sc.nextInt();
			
			int[] prices = new int[n];
			for(int j = 0; j < n; j++) {
				prices[j] = sc.nextInt();
			}
			
			int max = prices[n - 1];
			long sum = 0;
			
			for (int j = n - 2; j >= 0; j--) {
				if (prices[j] > max) {
					max = prices[j];
				} else {
					sum += max - prices[j];
				}
			}
			System.out.println("#" + i + " " + sum);
		}
		
	}

}
