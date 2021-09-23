import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Jungol 1681. 해밀턴 순환회로
 * Date: 2021. 9. 23.
 * @author MIRAE
 */

public class Solution_1681 {
	private static int N, min;
	private static int[][] costs;
	private static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		costs = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				costs[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Integer.MAX_VALUE;
		visited = new boolean[N];
		solMinCost(0, 0, 0);
		
		System.out.println(min);
	}
	
	private static void solMinCost(int cur, int sum, int cnt) {
		
		if (cnt == N-1) {
			if (costs[cur][0] == 0) return;    // 마지막 장소에서 회사로 돌아갈 수 없으면 리턴
			sum += costs[cur][0];              // 마지막 장소에서 회사로 돌아가는 비용 합산
			min = Math.min(min, sum);
			return;
		}
		
		for (int i = 1; i < N; i++) {
			if (visited[i] || costs[cur][i] == 0) continue; 
			
			if (sum+costs[cur][i] >= min) continue;   // 비용의 합이 최저 비용을 넘어가면 더이상 계산하지 않음

			visited[i] = true;
			solMinCost(i, sum+costs[cur][i], cnt+1);
			visited[i] = false;
		}		
	}
}
