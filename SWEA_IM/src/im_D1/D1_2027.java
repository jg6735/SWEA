package im_D1;

public class D1_2027 {

	public static void main(String[] args) {
		int count = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (j == count) {
					System.out.print("#");
				} else {
					System.out.print("+");
				}
			}
			count++;
			System.out.println();
		}
	}

}
