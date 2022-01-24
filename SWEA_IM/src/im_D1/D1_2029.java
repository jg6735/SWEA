package im_D1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D1_2029 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input/2029.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.println("#" + i + " " + a / b + " " + a % b);
		}
	}

}
