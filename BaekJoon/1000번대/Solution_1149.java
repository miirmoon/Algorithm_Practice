import java.util.Scanner;

/**
 * BeakJoon 1149. RGB거리
 * Date: 2021. 9. 14.
 * @author MIRAE
 */

public class Solution_1149 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] D = new int[N+1][3];
		int[][] costs = new int[N+1][3];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 3; j++) {
				costs[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 1; i <= N; i++) {
			D[i][0] = Math.min(D[i-1][1], D[i-1][2]) + costs[i][0]; // i번째 집에 빨강으로 칠하는 최소 비용 구하기
			D[i][1] = Math.min(D[i-1][0], D[i-1][2]) + costs[i][1]; // i번째 집에 초록으로 칠하는 최소 비용 구하기
			D[i][2] = Math.min(D[i-1][0], D[i-1][1]) + costs[i][2]; // i번째 집에 파랑으로 칠하는 최소 비용 구하기
		}
		
		System.out.println(Math.min(Math.min(D[N][0], D[N][1]), D[N][2]));
		sc.close();
	}
}
