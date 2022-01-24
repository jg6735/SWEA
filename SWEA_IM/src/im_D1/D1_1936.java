package im_D1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D1_1936 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input/1936.txt"));

		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if ((a == 1 && b == 2) || (a == 2 && b == 3) || (a == 3 && b == 1)) {
			System.out.println("B");
		} else {
			System.out.println("A");
		}
	}
}
