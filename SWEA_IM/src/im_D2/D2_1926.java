package im_D2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class D2_1926 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input/1926.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		for (int i = 1; i <= N; i++) {
			int q = i / 10; // 몫
			int r = i % 10; // 나머지
			
			// 몫이 3의 배수면 (일의 자리가 아닌 나머지 자리)
			if (q == 3 || q == 6 || q == 9) {
				// 나머지가 3의 배수면 (일의 자리) -- 출력 후 다음 반복 실행
				if (r == 3 || r == 6 || r == 9) {
					System.out.print("-- ");
					continue;
				}
				// 몫만 3의 배수면 - 출력
				System.out.print("- ");
				// 일의 자리만 3의 배수면 - 출력
			} else if (r == 3 || r == 6 || r == 9) {
				System.out.print("- ");
				// 나머지 값은 숫자 출력
			} else {				
				System.out.print(i + " ");
			}
		}

	}

}
