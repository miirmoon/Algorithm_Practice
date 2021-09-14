import java.util.Scanner;

/**
 * BaekJoon 1463. 1로 만들기
 * Date: 2021. 9. 14.
 * @author MIRAE
 */

public class Solution_1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] D = new int[N+1];
		
		D[0] = Integer.MAX_VALUE;
		D[1] = 0;
		for (int i = 2; i <= N; i++) {
			int tmp1 = 0, tmp2 = 0;

			if (i % 3 == 0) tmp1 = i / 3;
			if (i % 2 == 0) tmp2 = i / 2;
			
			D[i] = Math.min(Math.min(D[tmp1], D[tmp2]), D[i-1]) + 1;
		}
		
		System.out.println(D[N]);
		sc.close();
	}
}
