import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BaekJoon 12865. 평범한 배낭
 * Date: 2021. 9. 25.
 * Solution: Knapsack 알고리즘(DP)
 * @author MIRAE
 */

public class Solution_12865 {
	private static int N, K;
	private static int[][] object;
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);  // 물품 수
		K = Integer.parseInt(tmp[1]);  // 준서가 버틸 수 있는 무게
		
		object = new int[N+1][2];
		
		// 물건의 무게와 가치 입력받기
		for (int i = 1; i <= N; i++) {
			tmp = br.readLine().split(" ");
			object[i][0] = Integer.parseInt(tmp[0]);  // 무게
			object[i][1] = Integer.parseInt(tmp[1]);  // 가치
		}
		
		// 가방 무게별 최적 가치 구하기
		int[][] worth = new int[N+1][K+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (object[i][0] > j) {   // 현재 고려한 물건의 무게가 가방 무게보다 크면 이전까지 고려한 물건의 최대 가치 입력
					worth[i][j] = worth[i-1][j];
					continue;
				}
				
				// 이전까지 고려한 물건들의 최대 가치 vs 현재 물건의 가치 + 현재 물건의 무게를 뺀 무게의 최대 가치
				worth[i][j] = Math.max(worth[i-1][j], object[i][1] + worth[i-1][j-object[i][0]]);
			}
		}
		
		System.out.println(worth[N][K]);
	}
	
}
