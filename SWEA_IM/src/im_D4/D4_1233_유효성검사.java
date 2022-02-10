package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 이진 트리 정점의 총 수 N
 * 각 정점들은 "+, -, *, /"와 양의 정수로만 구성
 * 임의의 정점에 연산자가 있으면
 * 	>> 왼쪽 서브트리의 결과와 오른쪽 서브 트리의 결과 사용해서 연산
 * 적절한 식인지 유효성 판단 (0으로 나누는 경우는 고려XX)
 * 계산이 가능하면 "1" 출력, 불가능하면 "0" 출력
 */
public class D4_1233_유효성검사 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_D4_1233_유효성검사.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			sb.append('#').append(tc).append(' ');
			int N = Integer.parseInt(in.readLine());
			int result = 1; // 유효성 검증
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int level = Integer.parseInt(st.nextToken()); // 정점 번호 버리는 값
				char op = st.nextToken().charAt(0);

				if (st.hasMoreTokens()) { // 자식 노드가 있다면 부모 노드
					if (op >= '0' && op <= 9) { // 연산자가 아니라 숫자라면
						result = 0; // 계산 불가능
					}
				} else {
					if (op < '0' || op > '9') { // 리프노드가 숫자가 아니라면
						result = 0; // 계산 불가능
					}
				}
			}
			sb.append(result).append('\n');
		}
		System.out.print(sb);
	}

}
