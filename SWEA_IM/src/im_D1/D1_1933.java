package im_D1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D1_1933 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input/1933.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			if (N % i != 0) {
				continue;
			}
			System.out.print(i + " ");
		}

	}

}
