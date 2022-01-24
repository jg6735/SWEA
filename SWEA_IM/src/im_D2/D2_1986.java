package im_D2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class D2_1986 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input/1986.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(in.readLine());
			
			int sum = 0;
			for (int i = 1; i <= N; i++) {
				if (i % 2 == 0) {
					sum -= i;
				} else {
					sum += i;
				}
			}
			
			System.out.printf("#%d %d\n", tc, sum);
		}
	}

}
