import java.util.Scanner;

/**
 * BeakJoon 3052. 나머지
 * Date: 2021. 8. 25.
 * @author MIRAE
 */

public class Solution_3052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[42];
		
		for (int i = 0; i < 10; i++) {
			arr[sc.nextInt() % 42]++;
		}
		
		int cnt = 0;
		for (int i = 0; i < 42; i++) {
			if (arr[i] != 0) cnt++;
		}
		
		System.out.println(cnt);
		sc.close();
	}
}
