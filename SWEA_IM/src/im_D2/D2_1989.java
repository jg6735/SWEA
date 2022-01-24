package im_D2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class D2_1989 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input/1989.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			String str = in.readLine();
			
			char [] arr = str.toCharArray();
			
			int result = 1;

			for (int i = 0; i < arr.length; i++) {
				if(arr[i] != arr[arr.length - 1 - i]) {
					result = 0;
				}
			}		
			
			// 출력
			System.out.printf("#%d %d\n", tc, result);
		}
		
	}

}
