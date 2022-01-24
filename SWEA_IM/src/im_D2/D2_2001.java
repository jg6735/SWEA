package im_D2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_2001 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.setIn(new FileInputStream("input/2001.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			String str = in.readLine();
			
			// 입력 값을 공백으로 구분해 배열의 크기와 파리채의 크기 각각 저장
			StringTokenizer st = new StringTokenizer(str, " ");
			
			// 배열 크기 변수
			int N = Integer.parseInt(st.nextToken());
			
			// 파리채 크기 변수
			int M = Integer.parseInt(st.nextToken());
			
			// N x N 크기의 배열 생성
			int[][] arr = new int[N][N];
			
			// 입력 값을 공백으로 구분해 배열에 초기화
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//			// 출력 테스트
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(arr[i][j] + " ");
//				}
//				System.out.println();
//			}
			
			// 누적값 변수
			int sum = 0;
			// 최댓값 변수
			int max = 0;

			
			for (int i = 0; i < N - M + 1; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					for(int k = 0; k < M; k++) {
						for (int l = 0; l < M; l++) {
							sum += arr[i+k][j+l];					
						}
					}
					if (sum > max) {
						max = sum;
					}
					sum = 0;
				}
			}
			
			// 출력 #tc max
			System.out.printf("#%d %d\n", tc, max);
		}
	}

}
