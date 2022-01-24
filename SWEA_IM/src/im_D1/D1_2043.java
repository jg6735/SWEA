package im_D1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D1_2043 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input/2043.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int pw = sc.nextInt();
		int input = sc.nextInt();
		int count = 0;
		
		for (int i = input; i <= pw; i++) {
			count++;
		}
		
		System.out.println(count);
	}

}
