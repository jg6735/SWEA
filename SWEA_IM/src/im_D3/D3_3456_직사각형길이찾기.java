package im_D3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_3456_직사각형길이찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input/input_D3_3456_직사각형길이찾기.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int[] arr = new int[101];
			int result = 0;
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if (a == b) {
				result = c;
			} else if (a == c) {
				result = b;
			} else {
				result = a;
			}
//			for (int i = 0; i < 3; i++) {
//				arr[Integer.parseInt(st.nextToken())]++;
//			}
//			
//			for (int i = 1; i < 101; i++) {
//				if (arr[i] == 1 || arr[i] == 3) {
//					result = i;
//					break;
//				}
//			}
			
			System.out.printf("#%d %d%n", tc, result);
			
		}
	}

}
