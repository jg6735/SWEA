package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1210_Ladder1 {

	static int x;
	static int y;
	static int start;
	static int[][] map;
	static int[][] deltas = { { -1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_D4_1210_Ladder1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 1; tc <= 10; tc++) {
			int t = Integer.parseInt(br.readLine());

			map = new int[100][100];
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					if (map[i][j] == 2) {
						x = i;
						y = j;
					}
				}
			}
			
			move(x, y);
			
			System.out.printf("#%d %d%n", t, start);
		}
	}

	static void move(int r, int c) {

		while (true) {
			// 출발지점 찾을때까지 반복
			if (r == 0) {
				start = c;
				break;
			}
			for (int d = 0; d < 3; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];

				// 맵 바깥으로 나가면 넘어가기
				if (nr < 0 || nr >= 100 || nc < 0 || nc >= 100) {
					continue;
				}

				// 다음 요소가 길이면
				if (map[nr][nc] == 1) {
					// 현재 값 변경하고
					map[r][c] = -1;
					// 다음 요소로 이동
					r = nr;
					c = nc;
				}
			}
		}
	}
}
