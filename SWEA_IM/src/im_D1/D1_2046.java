package im_D1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D1_2046 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input/2046.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.print("#");
		}
	}

}
