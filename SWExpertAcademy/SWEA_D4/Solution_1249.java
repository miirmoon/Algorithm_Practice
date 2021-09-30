import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * SWEA 1249. [S/W 문제해결 응용] 보급로
 * Date: 2021. 9. 30.
 * Solution: BFS(너비우선탐색) + Priority Queue(우선순위 큐)
 * @author MIRAE
 */

public class Solution_1249 {
	private static class Pos implements Comparable<Pos> {
		int x, y, time;

		public Pos(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}

		@Override
		public int compareTo(Pos o) {
			return this.time - o.time;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] dx = new int[] {-1, 0, 1, 0};
		int[] dy = new int[] {0, 1, 0, -1};
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());			
			int[][] map = new int[N][N];
			int[][] result = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				char[] tmp = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = tmp[j]-'0';    // 읽어들인 문자를 숫자로 바꾸기
					result[i][j] = -1;         // 방문체크를 겸하기 위해 -1로 초기화하기
				}
			}
			
			PriorityQueue<Pos> pq = new PriorityQueue<>();
			pq.offer(new Pos(0, 0, map[0][0]));
			result[0][0] = map[0][0];
			
			while (!pq.isEmpty()) {
				Pos cur = pq.poll();
				
				for (int d = 0; d < 4; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					
					if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue; // 범위를 벗어나면 pass
					if (result[nx][ny] != -1) continue;    // 이미 방문한 곳이면 pass
					
					int ntime = cur.time + map[nx][ny];
					result[nx][ny] = ntime;
					pq.offer(new Pos(nx, ny, ntime));
				}
			}		
			System.out.println("#" + tc + " " + result[N-1][N-1]);
		}
	}
}

