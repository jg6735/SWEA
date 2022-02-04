package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_2805_농작물수확하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_D3_2805_농작물수확하기.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			int[][] grid = new int[N][N];
			int sum = 0;

			for (int i = 0; i < N; i++) {
				String str = in.readLine();
				for (int j = 0; j < N; j++) {
					grid[i][j] = str.charAt(j) - '0';
				}
			}
			
			for (int i = 0; i < N / 2; i++) {
				for (int j = N / 2 - i; j <= N / 2 + i; j++) {
					sum += grid[i][j];
				}
			}
			
			for (int i = N / 2; i >= 0; i--) {
				for (int j = N / 2 - i; j <= N / 2 + i; j++) {
					sum += grid[N - i - 1][j];
				}
			}

			System.out.printf("#%d %d\n", tc, sum);
		}
	}

}
