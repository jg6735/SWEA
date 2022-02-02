package im_D2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1970 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input/1970.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		int[] exchange = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		
		for (int tc = 1; tc <= T; tc++) {
			String str = in.readLine();
			
			StringTokenizer st = new StringTokenizer(str);
			
			int money = Integer.parseInt(st.nextToken());
			System.out.printf("#%d\n", tc);
			
			for (int count : exchange) {
				System.out.printf("%d ", money / count);
				money %= count;
			}
			
			System.out.println();			
			
		}
		
	}

}
