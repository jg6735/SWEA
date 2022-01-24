package im_D2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class D2_2007 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input/2007.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String str = in.readLine();
			int length = 0;

			System.out.println(str);

			// 마디의 최대길이는 10이므로 10보다 작거나 같을 때까지 반복
			for (int i = 1; i <= 10; i++) {
				if (str.substring(0, i).equals(str.substring(i, i * 2))) {
					length = i;
					break;
				}
			}
			System.out.println("#" + tc + " " + length);
		}

	}

}
