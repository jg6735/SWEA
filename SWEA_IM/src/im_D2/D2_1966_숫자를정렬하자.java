package im_D2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D2_1966_숫자를정렬하자 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input/input_D2_1966_숫자를정렬하자.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int[] arr = new int[N];
			int temp = 0;
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					if (arr[j] > arr[i]) {
//						temp = arr[i];
//						arr[i] = arr[j];
//						arr[j] = temp;
//					}
//				}
//			}
			
//			// 버블 정렬
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N - 1 - i; j++) {
//					if (arr[j] > arr[j + 1]) {
//						temp = arr[j];
//						arr[j] = arr[j + 1];
//						arr[j + 1] = temp;
//					}
//				}
//			}
			
			// Arrays API
			Arrays.sort(arr);
			
			System.out.printf("#%d ", tc);
			for (int i = 0; i < N; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}

}
