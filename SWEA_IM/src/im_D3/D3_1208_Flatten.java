package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_1208_Flatten {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_D3_1208_Flatten.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[100];
		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			int dump = Integer.parseInt(in.readLine());
			String str = in.readLine();
			int count = 0;
			int diff = 0;
			StringTokenizer st = new StringTokenizer(str, " ");

			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			while (true) {
				int max = 0;
				int min = 101;
				int maxIdx = -1;
				int minIdx = -1;
				
				if (count == dump) {
					for (int i = 0; i < arr.length; i++) {
						if (arr[i] > max) {
							max = arr[i];
							maxIdx = i;
						}
						
						if (arr[i] < min) {
							min = arr[i];
							minIdx = i;
						}
					}
					diff = arr[maxIdx] - arr[minIdx];
					break;
				}
				count++;						
					
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] > max) {
						max = arr[i];
						maxIdx = i;
					}

					if (arr[i] < min) {
						min = arr[i];
						minIdx = i;
					}
				}
				
				diff = arr[maxIdx] - arr[minIdx];
				
				if (diff == 1 || diff == 0) {
					break;
				}
				
				arr[maxIdx]--;
				arr[minIdx]++;			
			}
			
			System.out.printf("#%d %d%n", tc, diff);
		}
	}

}
