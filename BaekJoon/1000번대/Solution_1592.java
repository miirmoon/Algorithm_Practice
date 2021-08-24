import java.util.Scanner;

/**
 * BaekJoon 1592. 영식이와 친구들
 * Date: 2021. 8. 24. 
 * @author MIRAE
 */

public class Solution_1592 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		int[] seat = new int[N];  // 각 자리의 사람이 공을 받는 수 카운트
		
		int count = 0;
		int ball = 1;
		seat[1]++;
		while (true) {
			if (seat[ball] % 2 == 1) ball = (ball + L) % N;  // 공을 받은 사람이 지금까지 공을 받은 횟수가 홀수일 때
			else ball = (ball - L + N) % N;                  // 공을 받은 사람이 지금까지 공을 받은 횟수가 짝수일 때
			count++;
			if (++seat[ball] == M) break;   // 누군가가 공을 M번 받으면 중단
		}
		
		System.out.println(count);
		sc.close();
	}
}
