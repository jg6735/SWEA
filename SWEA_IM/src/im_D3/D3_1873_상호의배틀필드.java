package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_1873_상호의배틀필드 {

	private static int nr;
	private static int nc;
	private static int r;
	private static int c;
	private static int dir;
	private static int H;
	private static int W;

	/*
	 * . 평지(전차가 들어갈 수 있다.) 
	 * * 벽돌로 만들어진 벽 
	 * # 강철로 만들어진 벽 
	 * - 물(전차는 들어갈 수 없다.) 
	 * ^ 위쪽을 바라보는 전차(아래는 평지이다.) 
	 * v 아래쪽을 바라보는 전차(아래는 평지이다.) 
	 * < 왼쪽을 바라보는 전차(아래는 평지이다.) 
	 * > 오른쪽을 바라보는 전차(아래는 평지이다.) 
	 * 
	 * 전차의 방향에 따라 deltas방향 조절
	 * S가 입력됐을 때 전차가 바라보는 방향의 다음 좌표에 '*'가 있으면 '.'로 변환, 포탄 소멸 (탈출)
	 * S가 입력됐을 때 '#'가 있으면 포탄 소멸 (탈출)
	 * 
	 * 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_D3_1873_상호의배틀필드.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		// 상, 하, 좌, 우 순서로 방향 설정
		int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		for (int tc = 1; tc <= T; tc++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			char[][] map = new char[H][W];

			// 문자열 읽어서 각각의 문자를 map에 저장
			for (int i = 0; i < H; i++) {
				str = in.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			r = 0;
			c = 0;
			dir = 0;

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					// map의 해당 요소가 전차라면 바라보고 있는 방향에 따라 dir 설정
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						switch (map[i][j]) {
						case '^':
							dir = 0;
							break;
						case 'v':
							dir = 1;
							break;
						case '<':
							dir = 2;
							break;
						case '>':
							dir = 3;
							break;
						}
						// 해당 행과 열을 저장
						r = i;
						c = j;
					}
				}
			}

			// 입력된 문자열의 길이
			int N = Integer.parseInt(in.readLine());
			// 입력된 수행 문자열
			String inputKey = in.readLine();

			// 첫번째 문자부터 마지막 문자까지 반복
			for (int i = 0; i < N; i++) {
				char input = inputKey.charAt(i);

				// 입력된 문자가 'S'면 포탄 발사
				if (input == 'S') {	
					int count = 1;
					while (true) {
						// 현재 좌표(r, c)에 count를 곱해 해당 방향으로 다음 좌표 변경
						nr = r + deltas[dir][0] * count;
						nc = c + deltas[dir][1] * count;
						
						// 다음 좌표가 배열 범위를 벗어나면 탈출
						if (check()) {
							break;
						}
						// 다음 좌표가 강철 벽이면 강철 벽은 못 부수므로 탈출
						if (map[nr][nc] == '#') {
							break;
						}
						// 다음 좌표가 벽돌 벽이면 부술 수 있으므로 부수고 평지(.)로 바꾸고 탈출
						if (map[nr][nc] == '*') {
							map[nr][nc] = '.';
							break;
						}
						count++;
					}
				} else { // 입력된 문자가 이동 문자일 때 이동 문자에 따라 전차 방향을 설정하고, 방향값 초기화
					switch (input) {
					case 'U':
						map[r][c] = '^';
						dir = 0;
						break;
					case 'D':
						map[r][c] = 'v';
						dir = 1;
						break;
					case 'L':
						map[r][c] = '<';
						dir = 2;
						break;
					case 'R':
						map[r][c] = '>';
						dir = 3;
						break;
					}
					
					nr = r + deltas[dir][0];
					nc = c + deltas[dir][1];

					if (check()) {
						continue;
					}

					// 다음 좌표가 평지면
					if (map[nr][nc] == '.') {
						// 다음 좌표로 전차 이동
						map[nr][nc] = map[r][c];
						// 이전 좌표는 평지로 변경
						map[r][c] = '.';
						// 현재 좌표 초기화
						r = nr;
						c = nc;
					}
				}
			}
			
			// 출력
			System.out.printf("#%d ", tc);
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}

	}

	// 배열 범위를 벗어나는 경우 true 반환
	private static boolean check() {
		return nr < 0 || nr >= H || nc < 0 || nc >= W;
	}

}
