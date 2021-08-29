import java.util.Scanner;

/**
 * SWEA 2005. 파스칼의 삼각형
 * Date: 2021. 8. 29.
 * @author MIRAE
 */

public class Solution_2005 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			arr[0][0] = 1;
			for (int i = 1; i < N; i++) {
				for (int j = 0; j < i+1; j++) {
					if (j == 0 || j == i) {  // 처음과 마지막은 1로 채움
						arr[i][j] = 1;
						continue;
					}
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j];  // 왼쪽 위와 오른쪽 위 숫자의 합
				}
			}
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < i+1; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
