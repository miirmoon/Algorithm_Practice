import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BaekJoon 4485. 녹색 옷 입은 애가 젤다지?
 * Date: 2021. 9. 28.
 * Solution: 다익스트라(Dijkstra) 알고리즘
 * 		- 하나의 시작 정점에서 끝 정점까지 거리가 최소인 정점을 선택해 나가면서 최단 경로를 구하는 방식
 * 		- 탐욕 기법을 사용한 알고리즘
 * 		- 음의 가중치를 허용하지 않음
 * 		- 우선순위 큐를 사용할 경우 시간복잡도 측면에서 더 효율적임
 * @author MIRAE
 */

public class Solution_4485 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 0;
		
		while (true){
			int N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			
			int[][] cave = new int[N][N];
			int[][] rupee = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
					rupee[i][j] = -1;
				}
			}
			
			// 도둑루피 크기 구하기			
			int[] dr = new int[] {-1, 0, 1, 0};
			int[] dc = new int[] {0, 1, 0, -1};
			// 현재까지의 도둑루피가 더 작은 것을 기준으로 하기위해 우선순위 큐 이용
			PriorityQueue<int[]> pq = new PriorityQueue<>((int[] arr1, int[] arr2) -> arr1[2] - arr2[2]);
			pq.offer(new int[] {0, 0, cave[0][0]});
			rupee[0][0] = cave[0][0];
			
			while (!pq.isEmpty()) {
				int[] cur = pq.poll();
				
				for (int d = 0; d < 4; d++) {  // 4방향 탐색
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					
					if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					if (rupee[nr][nc] != -1) continue;    // 이미 방문한 길이면 pass
					
					rupee[nr][nc] = cur[2]+cave[nr][nc];
					pq.offer(new int[] {nr, nc, rupee[nr][nc]});
				}

			}		
			System.out.println("Problem " + ++tc + ": " + rupee[N-1][N-1]);
		}
	}
}
