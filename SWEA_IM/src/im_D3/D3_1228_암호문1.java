package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class D3_1228_암호문1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_D3_1228_암호문1.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(in.readLine());
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			List<Integer> list = new LinkedList<Integer>();
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int OP = Integer.parseInt(in.readLine());
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			
			for (int i = 0; i < OP; i++) {
				if (st.nextToken().charAt(0) == 'I') {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						list.add(x, Integer.parseInt(st.nextToken()));
						x++;
					}
				}
			}
			
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

}
