import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Jungol 1037. 오류교정
 * Date: 2021. 8. 29.
 * @author MIRAE
 */

public class Solution_1037 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		int chi = -1, chj = -1;
		
		// 배열 입력 및 행의 합 구하기
		for (int i = 0; i < N; i++) {
			int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				sum += arr[i][j];
			}
			if (sum % 2 == 1) {    // 합이 홀수일 때 
				if (chi != -1) {   // 이미 홀수인 행이 있었으면 corrupt 출력 후 리턴
					System.out.println("Corrupt");
					return;
				}
				chi = i;
			}
	 	}
		// 열의 합 구하기
		for (int j = 0; j < N; j++) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += arr[i][j];
			}
			if (sum % 2 == 1) {    // 합이 홀수일 때
				if (chj != -1) {   // 이미 홀수인 행이 있었으면 corrupt 출력 후 리턴
					System.out.println("Corrupt");
					return;
				}
				chj = j;
			}
		}
		if (chi == -1 && chj == -1) System.out.println("OK");  // 모두 짝수였을 때
		else System.out.printf("Change bit (%d,%d)", chi+1, chj+1);
	}
}
