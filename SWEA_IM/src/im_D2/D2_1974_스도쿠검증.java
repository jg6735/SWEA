package im_D2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1974 {

	/*
	 * 1. 입력 받은 숫자를 배열에 저장 
	 * 2. 새로운 배열을 만들고 그 안에 각 행의 숫자들을 저장하고 (1 ~ 9)중 없는 숫자가 있으면 스도쿠 X 
	 * 3. 새로운 배열을 만들고 그 안에 각 열의 숫자들을 저장하고 (1 ~ 9)중 없는 숫자가 있으면 스도쿠 X 
	 * 4. 3X3 배열마다 (1 ~ 9)중 없는 숫자가 있으면 스도쿠 X ====> 지금은 좀 복잡한데 더 간단하게, 최적화 할 수 있는 방법을 찾아봐야겠다.
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input/1974.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			// 9X9 크기의 스도쿠 배열 생성
			int[][] grid = new int[9][9];

			// 배열에 데이터 입력
			for (int r = 0; r < 9; r++) {
				String str = in.readLine();

				StringTokenizer st = new StringTokenizer(str, " ");
				for (int c = 0; c < 9; c++) {
					grid[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			// 스도쿠가 맞는지 체크
			boolean check = true;

			// 모든 행 체크
			for (int i = 0; i < 9; i++) {
				// 각 행의 열마다 요소를 담을 배열 생성하고 저장하기
				int[] arr = new int[10];
				for (int j = 0; j < 9; j++) {
					arr[grid[i][j]]++;
				}
				// 1 ~ 9까지 하나라도 담긴게 없다면 스도쿠퍼즐이 아니므로
				for (int j = 1; j < 10; j++) {
					if (arr[j] == 0) {
						check = false;
						break;
					}
				}
			}

			// 모든 열 체크
			for (int i = 0; i < 9; i++) {
				int[] arr = new int[10];
				for (int j = 0; j < 9; j++) {
					arr[grid[j][i]]++;
				}
				for (int j = 1; j < 10; j++) {
					if (arr[j] == 0) {
						check = false;
						break;
					}
				}
			}

			int count = 0; // 9개의 스도쿠를 체크하기 위해 카운트 체킹
			int x = 0; // 행 인덱스를 3씩 증가하기 위한 변수
			int y = 0; // 열 인덱스를 3씩 증가하기 위한 변수
			
			while (true) {
				// 3X3배열이 스도쿠가 맞는지 검사하기 위한 배열 생성
				int[] arr = new int[10];
				for (int i = x; i < 3 + x; i++) {
					for (int j = y; j < 3 + y; j++) {
						arr[grid[i][j]]++;
					}
				}
				
				for (int i = 1; i < 10; i++) {
					if (arr[i] == 0) {
						check = false;
						break;
					}
				}
				
				// 첫번째 열(3번째칸까지)의 스도쿠퍼즐을 모두 검사했다면 다음 열(4번째칸 ~ 6번째칸)로 이동
				if (x == 6) {
					x = 0;
					y += 3;
				} else {
					x += 3;
				}
				
				count++;
				
				// 9번 체크했으면 반복문 탈출
				if (count == 8) {
					break;
				}			
			}

			System.out.printf("#%d %d%n", tc, check == true ? 1 : 0);
		}

	}

}