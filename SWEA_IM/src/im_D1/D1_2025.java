package im_D1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D1_2025 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input/2025.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int sum = 0;
		
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		
		System.out.println(sum);
	}

}
