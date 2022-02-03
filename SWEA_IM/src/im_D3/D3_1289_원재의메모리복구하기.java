package im_D3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_1289_원재의메모리복구하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.setIn(new FileInputStream("input/D3_1289_원재의메모리복구하기.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String str = in.readLine();
			int[] arr = new int[str.length()];
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = str.charAt(i) - '0';
			}
			
			// 고친 횟수
			int count = 0;
			
			// 0번 인덱스가 1이면 고치고 시작
			if (arr[0] == 1) {
				count = 1;
			}

			// 1번 인덱스부터 시작
			for (int i = 1; i < arr.length; i++) {
				// 현재 인덱스의 값이 이전 인덱스의 값과 다르면 변경해야하기 때문에 count 증가
				if (arr[i] != arr[i - 1]) {
					count++;
				}
			}			
			
			// 출력
			System.out.printf("#%d %d%n", tc, count);
		}
		
	}

}