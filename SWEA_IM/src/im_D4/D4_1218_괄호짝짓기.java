package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class D4_1218_괄호짝짓기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_D4_1218_괄호짝짓기.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			// 문자열의 길이 입력 받기
			int N = Integer.parseInt(in.readLine());
			// 문자열 입력 받기
			String str = in.readLine();
			// 문자형 자료구조를 저장하는 스택 생성
			Stack<Character> stk = new Stack<Character>();

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);

				// 닫는 괄호일 때 스택의 top이 페어라면 여는 괄호 꺼내기
				if (c == ')' && stk.peek() == '(') {
					stk.pop();
				} else if (c == ']' && stk.peek() == '[') {
					stk.pop();
				} else if (c == '}' && stk.peek() == '{') {
					stk.pop();
				} else if (c == '>' && stk.peek() == '<') {
					stk.pop();
				// 여는 괄호라면 스택에 집어넣기
				} else {
					stk.push(c);
				}
			}

			// 출력 : 모든 괄호가 페어라면 스택에서 모두 꺼내므로 비어있으니 유효 - 1, 아니라면 0
			System.out.printf("#%d %d%n", tc, stk.isEmpty() ? 1 : 0);
		}
	}

}
