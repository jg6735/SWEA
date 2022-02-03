package com.ssafy.im;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D2_1954_달팽이숫자 {

	/*
	 * 1. (0, 0)에서 시작
	 * 2. count = 1부터 이동할 때마다 1씩 증가
	 * 3. 오른쪽, 아래, 왼쪽, 위 순서대로 계속 반복
	 * 4. 0이 아닌 다른 수를 만나거나 배열의 범위를 벗어나면 다음 방향으로....?
	 */
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input_D2_1954_달팽이숫자.txt"));
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		// 방향 설정 (우, 하, 좌, 상)
		int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		
		for (int tc = 1; tc <= T; tc++) {
			int count = 1;
			int N = in.nextInt();
			int[][] grid = new int[N][N];
			
			// 현재 좌표? (0, 0)에서 시작
			int r = 0;
			int c = 0;
			
			// 방향값 : 처음은 오른쪽 방향으로 시작(deltas)
			int dir = 0;
			
			while (true) {
				// count가 N * N 보다 크면 배열의 모든 인덱스를 채운 것이므로 반복문 탈출
				if (count > N * N) {
					break;
				}
				
				// 다음 행과 열의 값
				int nr = r + deltas[dir][0];
				int nc = c + deltas[dir][1];
				
				// 다음 행과 다음 열이 배열의 범위를 벗어나거나 이미 지나갔던 (0이 아닌) 곳이면 방향 바꾸기
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || grid[nr][nc] != 0) {
					dir = (dir + 1) % 4;
					nr = r + deltas[dir][0];
					nc = c + deltas[dir][1];
				}
				
				// 현재 인덱스에 count 저장하고 증가
				grid[r][c] = count++;
				
				// 다음 행과 열로 이동
				r = nr;
				c = nc;
			}
			
			// 출력
			System.out.printf("#%d%n", tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(grid[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
