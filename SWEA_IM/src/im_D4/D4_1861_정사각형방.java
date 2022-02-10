package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1861_정사각형방 {

	static int N;
	static int max;
	static int point;
	static int[][] map;
	static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_D4_1861_정사각형방.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			point = 0;
			max = 0;

			for (int i = 0; i < N; i++) {
				String str = in.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					move(i, j, 1, map[i][j]);
				}
			}

			System.out.printf("#%d %d %d%n", tc, point, max);

		}
	}

	// dfs : 깊이 우선 탐색
	static void move(int r, int c, int count, int start) {
		// 해당 방 방문 체크
		visited[r][c] = true;

		for (int d = 0; d < 4; d++) {
			// 상 하 좌 우 다음 방 탐색
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];

			// 배열 바깥이면 continue
			if (nr >= N || nr < 0 || nc >= N || nc < 0) {
				continue;
			}

			// 방문하지 않은 방이고 현재 방보다 1이 더 크면 이동
			if ((!visited[nr][nc]) && (map[nr][nc] - map[r][c]) == 1) {
				move(nr, nc, count + 1, start);
			}
		}

		// 이동횟수 최대치
		if (count > max) {
			max = count;
			// 시작 지점 저장
			point = start;
		}
		
		// 최대 이동횟수가 있으면
		if (count == max) {
			// 시작지점은 시작지점 중 가장 작은 값
			point = Math.min(point, start);
		}

		// 방문 여부 초기화
		visited[r][c] = false;
	}

}
