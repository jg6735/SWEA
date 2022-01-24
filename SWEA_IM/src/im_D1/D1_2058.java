package im_D1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D1_2058 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input/2058.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int sum = 0;
		
		while (N > 0) {
			sum += N % 10;
			N /= 10;
		}
		
		System.out.print(sum);
	}

}
