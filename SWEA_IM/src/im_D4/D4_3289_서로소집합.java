package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_3289_서로소집합 {

	static int n;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input_D4_3289_서로소집합.txt"));
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());	// a와 b는 n이하의 자연수
			int m = Integer.parseInt(st.nextToken());	// 연산의 개수
			makeSet();	// 1부터 n까지의 단위 집합 생성
			
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int op = Integer.parseInt(st.nextToken());	// 연산자 0 or 1
				int a = Integer.parseInt(st.nextToken());	// 피연산자1
				int b = Integer.parseInt(st.nextToken());	// 피연산자2
				
				// 연산자가 1일 경우 두 원소가 같은 집합에 포함되어 있는지 확인
				if (op == 1) {
					// (a, b의 루트 노드가 같다면) 같은 집합이다.
					if (findSet(a) == findSet(b)) {
						sb.append("1");
					} else {
						sb.append("0");
					}
				// 연산자가 0이면 합집합
				} else {
					union(a, b);
				}
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}

	// 단위 집합 생성
	public static void makeSet() {
		parents = new int[n + 1];
		// 자신의 부모 노드를 자신의 값으로 세팅
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}
	
	// a의 집합 찾기 : a의 대표자(루트 노드) 찾기
	public static int findSet(int a) {
		if (a == parents[a]) return a;
		return parents[a] = findSet(parents[a]); // path compression
	}
	
	// a, b 두 집합 합치기
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
}
