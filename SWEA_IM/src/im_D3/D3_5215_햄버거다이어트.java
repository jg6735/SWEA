package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 데이터를 어떻게 입력 받을건지? 1차원배열, 2차원배열, 클래스?
 * 클래스는 inner class로..
 */
public class D3_5215_햄버거다이어트 {

	static int N;
	static int L;
	static int max;
	static int[] score;
	static int[] cal;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_D3_5215_햄버거다이어트.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			score = new int[N];
			cal = new int[N];
			max = 0;
			
			for (int i = 0; i < N; i++) {
				str = in.readLine();
				st = new StringTokenizer(str, " ");
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			score(0, 0, 0);
			
			System.out.printf("#%d %d%n", tc, max);
			
		}
	}
	
	static void score(int cnt, int sumScore, int sumCal) {
		// 칼로리의 누적합이 제한값을 넘어섰을 때
		if (sumCal > L) {
			return;
		}
		// 마지막 재료까지 고려했을 때
		if (cnt == N) {
			if (sumScore > max) {
				max = sumScore;
			}
			return;
		}
		
		score(cnt + 1, sumScore + score[cnt], sumCal + cal[cnt]);
		score(cnt + 1, sumScore, sumCal);
	}

}
