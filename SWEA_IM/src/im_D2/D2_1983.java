package im_D2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D2_1983 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input/1983.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		String[] grade = { "D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+" };

		for (int tc = 1; tc <= T; tc++) {
			String str = in.readLine();

			StringTokenizer st = new StringTokenizer(str, " ");

			int N = Integer.parseInt(st.nextToken());

			int K = Integer.parseInt(st.nextToken()) - 1;

			int[] sum = new int[N];

			for (int i = 0; i < N; i++) {
				str = in.readLine();
				st = new StringTokenizer(str, " ");

				int midScore = Integer.parseInt(st.nextToken());
				int finalScore = Integer.parseInt(st.nextToken());
				int homework = Integer.parseInt(st.nextToken());
				sum[i] = midScore * 35 + finalScore * 45 + homework * 20;
			}
			
//			// 출력 테스트
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < 3; j++) {
//					System.out.print(sum[i] + " ");
//				}
//				System.out.println();
//			}
			
			int score = sum[K];
			
			Arrays.sort(sum);
			
			int index = 0;
			
			for (int i = 0; i < N; i++) {
				if (sum[i] == score) {
					index = i;
					break;
				}
			}
			
			int result = index / (N / 10);
			System.out.printf("#%d %s\n", tc, grade[result]);
		}


	}

}
