package im_D2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * SWEA D2 
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PjMgaALgDFAUq
 */
public class D2_1940_가랏RC카 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/input_D2_1940_가랏RC카.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int speed = 0;
			int sum = 0;
			int n = 0;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int cmd = Integer.parseInt(st.nextToken());
				switch (cmd) {
				case 0 :	// 현상 유지
					break;
				case 1 :	// 가속
					n = Integer.parseInt(st.nextToken());
					speed += n;
					break;
				case 2 :	// 감속
					n = Integer.parseInt(st.nextToken());
					if (speed < n) {
						speed = 0;
						break;
					}
					speed -= n;
					break;
				}
				sum += speed;
			}
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		System.out.print(sb);
	}

}
