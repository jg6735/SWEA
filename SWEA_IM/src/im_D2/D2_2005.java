package im_D2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class D2_2005 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input/2005.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(in.readLine());
			
			// N * N의 크기를 갖는 정수형 배열 생성
			int[][] arr = new int[N][N];
			
			/** 
			삼각형의 좌우변은 1만 출력해야하므로 첫번째 열이거나 마지막 열일때는 1을 저장하고
			그 외의 경우에는 배열상 왼쪽위(i-1, j-1)와 위(i-1, j)의 합을 저장한다
			*/		
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					if (j == i || j == 0) {
						arr[i][j] = 1;
					} else {
						arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
					}
				}
			}
			
			System.out.printf("#%d\n", N);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
