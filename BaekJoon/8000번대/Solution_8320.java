import java.util.Scanner;

/**
 * BaekJoon 8320. 직사각형을 만드는 방법
 * Date: 2021. 8. 26. 
 * @author MIRAE
 */

public class Solution_8320 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int n = sc.nextInt();
		sc.close();
		
		int cnt = n;  // 1~n까지 1Xn크기의 사각형이 만들어짐
		for (int i = 4; i <= n; i++) {  // 1~n까지의 수 중 소수가 아닌 수의 약수 개수를 구함(약수 개수의 1/2개 합산)
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
