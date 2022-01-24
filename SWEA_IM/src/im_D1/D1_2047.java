package im_D1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D1_2047 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input/2047.txt"));
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		System.out.println(str.toUpperCase());
	}

}
