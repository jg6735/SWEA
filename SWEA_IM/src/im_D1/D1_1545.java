package im_D1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D1_1545 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input/1545.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();

		for (int i = N; i >= 0; i--) {
			System.out.print(i + " ");
		}

	}

}
