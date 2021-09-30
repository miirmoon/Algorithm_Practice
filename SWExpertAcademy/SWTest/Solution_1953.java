import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * SWEA 1953. [모의 SW 역량테스트] 탈주범 검거
 * Date: 2021. 9. 30.
 * @author MIRAE
 */

public class Solution_1953 {
	
	private static int N, M, L;
	// 터널의 모양대로 이동방향 초기화
	private static int[][] dr = {{0}, {-1, 0, 1, 0}, {-1, 0, 1, 0}, {0, 0, 0, 0}, {-1, 0, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {-1, 0, 0, 0}};
	private static int[][] dc = {{0}, {0, 1, 0, -1}, {0, 0, 0, 0}, {0, 1, 0, -1}, {0, 1, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, -1}, {0, 0, 0, -1}};
	private static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}	
			
			System.out.println("#" + tc + " " + bfs(R, C));
		}
	}

	private static int bfs(int sr, int sc) {	
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.offer(new int[] {sr, sc});
		visited[sr][sc] = true;	
		int cnt = 1, time = 0;
		
		while (!q.isEmpty()) {
			int LEN = q.size();
			time++;
			if (time == L) break;    // 시간이 L만큼 소요되면 중단
			
			for (int i = 0; i < LEN; i++) {
				int[] cur = q.poll();
				int type = map[cur[0]][cur[1]];
				
				for (int d = 0; d < 4; d++) {
					if (dr[type][d] == 0 && dc[type][d] == 0) continue;  // 움직임이 없으면 pass
					
					int nr = cur[0] + dr[type][d];
					int nc = cur[1] + dc[type][d];
					int pos = (d + 2) % 4;  // 연결 가능한 터널 위치 확인을 위함(좌-우, 상-하)
					
					if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					if (visited[nr][nc]) continue;      // 이미 방문한 곳인 경우
					if (map[nr][nc] == 0) continue;     // 터널이 없는 경우
					if (dr[map[nr][nc]][pos] == 0 && dc[map[nr][nc]][pos] == 0) continue;  // 연결되지 않은 터널이 있는 경우
					
					q.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
					cnt++;
				}
			}
			
		}	
		return cnt;
	}
}