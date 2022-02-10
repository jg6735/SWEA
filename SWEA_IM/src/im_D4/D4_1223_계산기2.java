package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class D4_1223_계산기2 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_D4_1223_계산기2.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			// 문자열의 길이 입력
			int N = Integer.parseInt(in.readLine());
			// 문자열 입력
			String str = in.readLine();

			// 후위표기식 변경 스택
			Stack<Character> stk = new Stack<Character>();
			// 후위표기식 계산 스택
			Stack<Integer> result = new Stack<Integer>();
			// 후위표기식 저장 문자열
			String post = "";
			
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				
				// 해당 문자 값이 0 ~ 9 사이의 숫자면 후위표기식에 바로 저장
				if (c - '0' >= 0 && c - '0' <= 9) {
					post += c;
				} else {
					// 곱셈 연산자라면 스택에 저장
					if (c == '*') {
						stk.push(c);
						
						// 덧셈 연산자라면
					} else {
						// 스택이 빌 때까지 스택에 있는 연산자를 꺼내 후위표기식에 저장(곱셈에 우선순위가 밀리기 때문에 곱셈먼저)
						while (!stk.isEmpty()) {
							post += stk.pop();
						}
						// 스택이 비어있다면 스택에 저장
						stk.push(c);
					}
				}
			}
			
			// 남아 있는 연산자 모두 후위 표기식에 저장
			while (!stk.empty()) {
				post += stk.pop();
			}
			
			for (int i = 0; i < N; i++) {
				char c = post.charAt(i);
				
				// 후위 표기식의 문자값이 0 ~ 9 숫자라면 스택에 저장
				if (c - '0' >= 0 && c - '0' <= 9) {
					result.push(c - '0');
				} else {
					// 문자값이 연산자라면 스택에서 두 숫자를 차례대로 꺼냄
					int num1 = result.pop();
					int num2 = result.pop();
					
					// 연산자에 맞게 계산해서 스택에 저장
					if(c == '+') {
						result.push(num1 + num2);
					} else {
						result.push(num1 * num2);
					}
				}
			}
			
			// 최종 값
			int sum = result.pop();
			
			System.out.printf("#%d %d%n", tc, sum);
		}
	}

}
