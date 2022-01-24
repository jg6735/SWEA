package im_D2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D2_1984 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input/1984.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
//			int[] arr = new int[10];
//			
//			for (int i = 0; i < 10; i++) {
//				arr[i] = sc.nextInt();
//			}
//			
//			int sum = 0;
//			int max = arr[0];
//			int min = arr[0];
//			
//			for (int i = 1; i < 10; i++) {
//				if (arr[i] > max) {
//					max = arr[i];
//				}
//				if (arr[i] < min) {
//					min = arr[i];
//				}
//			}
//			
//			for (int i = 0; i < 10; i++) {
//				if (arr[i] != max && arr[i] != min) {
//					sum += arr[i];
//				}
//			}

			int sum = 0;
			int max = -1;
			int min = 10001;

			for (int i = 0; i < 10; i++) {
				int n = sc.nextInt();

				if (n > max) {
					max = n;
				}
				if (n < min) {
					min = n;
				}
				
				sum += n;
			}

			System.out.printf("#%d %d\n", tc, Math.round((sum - max - min) / 8.0));
		}

	}

}
