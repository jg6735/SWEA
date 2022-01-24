package im_D1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D1_2056 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input/2056.txt"));
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		for (int i = 1; i <= T; i++) { 
			String date = sc.next();

			int month = Integer.parseInt(date.substring(4, 6));
			int day = Integer.parseInt(date.substring(6, 8));
			
			System.out.print("#" + i + " ");
			if (month >= 1 && month <= 12 && day >= 1 && day <= daysOfMonth[month - 1]) {
				System.out.println(date.substring(0, 4) + "/" + date.substring(4, 6) + "/" + date.substring(6, 8));
			} else {
				System.out.println(-1);
			}
		}
	}
}
