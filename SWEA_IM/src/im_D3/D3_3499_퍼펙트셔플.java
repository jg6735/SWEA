package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class D3_3499_퍼펙트셔플 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_D3_3499_퍼펙트셔플.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			String str = in.readLine();
			st = new StringTokenizer(str, " ");
			List<String> list = new LinkedList<String>();

			for (int i = 0; i < N; i++) {
				list.add(st.nextToken());
			}
			
			int half = N / 2;
			boolean isOdd = N % 2 == 1 ? true : false;
			String odd = "";
			if (isOdd) odd = list.remove(half);
			
			for (int i = 0; i < half; i++) {
				System.out.print(list.get(i) + " ");
				System.out.print(list.get(i + half) + " ");
			}
			if(isOdd) System.out.println(odd);
			System.out.println();
		}
	}

	public static void main1(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_D3_3499_퍼펙트셔플.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			String str = in.readLine();
			st = new StringTokenizer(str, " ");
			String[] arr1;
			String[] arr2;
			int count = 0;

			if (N % 2 == 0) {
				arr1 = new String[N / 2];
				arr2 = new String[N / 2];

				for (int i = 0; i < N / 2; i++) {
					arr1[i] = st.nextToken();
				}
				for (int i = 0; i < N / 2; i++) {
					arr2[i] = st.nextToken();
				}
			} else {
				arr1 = new String[N / 2 + 1];
				arr2 = new String[N / 2];

				for (int i = 0; i < N / 2 + 1; i++) {
					arr1[i] = st.nextToken();
				}
				for (int i = 0; i < N / 2; i++) {
					arr2[i] = st.nextToken();
				}
			}

			System.out.printf("#%d ", tc);
			for (int i = 0; i < N; i++) {
				if (count == 0) {
					System.out.print(arr1[i / 2] + " ");
					count++;
				} else {
					System.out.print(arr2[i / 2] + " ");
					count--;
				}
			}

			System.out.println();
		}

	}

}
