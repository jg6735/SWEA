package im_D1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class D1_2063 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input/2063.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		System.out.print(arr[N / 2]);
	}

}
