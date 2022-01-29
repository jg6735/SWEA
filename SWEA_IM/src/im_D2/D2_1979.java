package im_D2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1979 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input/1979.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String str = in.readLine();

			StringTokenizer st = new StringTokenizer(str, " ");

			// 단어 퍼즐의 가로, 세로 길이
			int N = Integer.parseInt(st.nextToken());

			// 단어의 길이
			int K = Integer.parseInt(st.nextToken());

			// N x N 크기의 배열 생성
			int[][] grid = new int[N][N];

			for (int i = 0; i < N; i++) {
				str = in.readLine();
				st = new StringTokenizer(str, " ");

				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//			배열 출력 확인
//			for (int i = 0; i < grid.length; i++) {
//				for (int j = 0; j < grid.length; j++) {
//					System.out.print(grid[i][j] + " ");
//				}
//				System.out.println();
//
//			}

			int result = 0;

			for (int r = 0; r < N; r++) {
				int count = 0;
				for (int c = 0; c < N; c++) {

					// 오른쪽 방향으로
					if (grid[r][c] == 0) {
						if (count == K) {
							result++;
						}
						count = 0;
					} else {
						count++;
					}
				}
				if (count == K) {
					result++;
				}
			}

			for (int r = 0; r < N; r++) {
				int count = 0;
				for (int c = 0; c < N; c++) {
					
					// 아래 방향으로
					if (grid[c][r] == 0) {
						if (count == K) {
							result++;
						}
						count = 0;
					} else {
						count++;
					}
				}
				
				if(count == K) {
					result++;
				}
			}
			
			// 출력
			System.out.printf("#%d %d\n", tc, result);
		}
	}

}