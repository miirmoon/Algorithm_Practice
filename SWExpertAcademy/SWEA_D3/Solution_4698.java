import java.util.Scanner;

/**
 * SWEA 4698. 테네스의 특별한 소수
 * Date: 2021. 8. 29.
 * @author MIRAE
 */

public class Solution_4698 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		// 여러 테스트 케이스에서 사용할 소수 미리 찾기
		boolean[] isprime = new boolean[1000001];
		isprime[2] = true;
		outer: for (int n = 3; n < 1000001; n++) {
			if (n % 2 == 0) continue;
			for (int i = 3; i <= Math.sqrt(n); i+=2) {
				if (n % i == 0) continue outer;
			}
			isprime[n] = true;
		}
		
		for (int tc = 1; tc <= T; tc++) {
			int D = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			int res = 0;
					
			for (int n = A; n <= B; n++) {
				if (!isprime[n]) continue;  // n이 소수가 아니면 pass
				
				// n이 D를 포함하면 카운트
				if (Integer.toString(n).contains(Integer.toString(D))) res++;
			}			
			System.out.println("#" + tc + " " + res);
		}
		sc.close();
	}
}
