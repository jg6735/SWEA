package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D3_1225_암호생성기 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input_D3_1225_암호생성기.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			int t = Integer.parseInt(in.readLine());
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			Queue<Integer> que = new LinkedList<Integer>();
			
			for (int i = 0; i < 8; i++) {
				que.offer(Integer.parseInt(st.nextToken()));
			}
			
			while (true) {
				for (int i = 1; i <= 5; i++) {
					int temp = que.poll();
					if (temp - i <= 0) {
						que.offer(0);
						break;
					} else {
						que.offer(temp - i);
					}
				}
				if (que.contains(0)) {
					break;
				}
			}
			sb.append("#" + tc + " ");
			for (int i = 0; i < 8; i++) {
				sb.append(que.poll()).append(" ");
			}
			
			System.out.println(sb.toString());
		}
	}

}
