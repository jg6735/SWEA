package im_D2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1204_최빈수구하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input/input_D2_1204_최빈수구하기.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for (int t = 1; t <= T; t++) {
			int tc = Integer.parseInt(in.readLine());
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			
			int[] arr = new int[101];
			int maxIdx = 0;
			int maxCount = 0;
			for (int i = 0; i < 1000; i++) {
				arr[Integer.parseInt(st.nextToken())]++;
			}
			
			for (int i = 0; i < 101; i++) {
				if (arr[i] >= maxCount) {
					maxCount = arr[i];
					maxIdx = i;
				}
			}
			
			System.out.printf("#%d %d%n", tc, maxIdx);
		}
	}

}
