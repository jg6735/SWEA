package im_D1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D1_2019 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input/2019.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int res = 1;
		
		System.out.print(res + " ");
		for (int i = 1; i <= n; i++) {
			res *= 2;
			System.out.print(res + " ");
		}
	}

}
