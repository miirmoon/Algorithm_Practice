import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA 5643. 키 순서
 * Date: 2021. 9. 29.
 * Solution: DFS(Depth First Search, 깊이 우선 탐색)
 * @author MIRAE
 */

public class Solution_5643 {
	private static int N, taller;
	private static int[][] adj;
	private static int[] result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			// 학생들의 키 비교 결과 입력받기
			adj = new int[N+1][N+1];
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				adj[x][y] = 1;
			}
			
			result = new int[N+1];
			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				boolean[] tmp = new boolean[N+1];
				taller = 0;      // i보다 키가 큰 사람 수: compare함수(dfs)의 깊이
				compare(i, tmp);
				result[i] += taller;
			}
			
			// result[i] = i보다 작은 학생 수 + i보다 큰 학생 수(i포함) -> N과 같으면 순서를 알 수 있음
			for (int i = 1; i <= N; i++) {
				if (result[i] == N) cnt++;     
			}
			
			System.out.println("#" + tc + " " + cnt);
		}
	}
	
	public static void compare(int n, boolean[] tmp) {
		
		tmp[n] = true;
		taller++;
		for (int i = 1; i <= N; i++) {
			if (adj[n][i] == 1 && !tmp[i]) {
				result[i]++;   // i학생은 시작점 학생보다 큰 학생이므로 i학생보다 작은 학생 수 계산을 위해 카운트
				compare(i, tmp);
			}
		}
	}
}
