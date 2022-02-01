package im_D2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1976 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input/1976.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String str = in.readLine();
			
			StringTokenizer st = new StringTokenizer(str, " ");
			
			int hour1 = Integer.parseInt(st.nextToken());
			int min1 = Integer.parseInt(st.nextToken());
			int hour2 = Integer.parseInt(st.nextToken());
			int min2 = Integer.parseInt(st.nextToken());
			
			int hour = 0;
			int min = 0;
			
			if (min1 + min2 >= 60) {
				min = min1 + min2 - 60;
				if (hour1 + hour2 > 12) {
					hour = hour1 + hour2 - 11;
				} else {
					hour = hour1 + hour2 + 1;
				}
			} else {
				if (hour1 + hour2 > 12) {
					hour = hour1 + hour2 - 12;
				} else {
					hour = hour1 + hour2;
				}
				min = min1 + min2;
			}
			
			System.out.printf("#%d %d %d\n", tc, hour, min);
		}
	}

}
