import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BaekJoon 1600. 말이 되고픈 원숭이
 * Date: 2021. 9. 15. 
 * @author MIRAE
 */

public class Solution_1600 {
	static class Pos {
		int x, y, k, cnt;

		public Pos(int x, int y, int k, int cnt) {
			this.x = x;        // x좌표
			this.y = y;        // y좌표
			this.k = k;        // (x, y) 위치까지 말의 움직임으로 움직인 횟수
			this.cnt = cnt;    // (x, y) 위치까지 움직인 횟수
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][] road = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) {
				road[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 움직인 위치까지의 말처럼 움직인 횟수에 따라 다음에 움직일 수 있는 방향이 결정되므로 k횟수별로 방문체크를 해야함 
		boolean[][][] visited = new boolean[H][W][K+1];
		int[] dx = {-1, 0, 1, 0, -2, -1, 1, 2, 2, 1, -1, -2};  // 0~3: 인접한 4개 방향, 4~11: 말처럼 움직이는 방향
		int[] dy = {0, 1, 0, -1, 1, 2, 2, 1, -1, -2, -2, -1};
		
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(0, 0, 0, 0));     // 초기 데이터: 출발점(0, 0), 말처럼 움직인 횟수(0), 움직인 횟수(0) 추가
		visited[0][0][0] = true;
		
		while (!q.isEmpty()) {
			Pos cur = q.poll();
			
			if (cur.x == H-1 && cur.y == W-1) {   // 도착점에 도달하면 해당 위치에서의 횟수(cnt)를 출력하고 리턴
				System.out.println(cur.cnt);
				return;
			}
			
			for (int d = 0; d < (cur.k >= K ? 4 : 12); d++) {    // 말의 움직임으로 k번 모두 움직였다면 4방향만, 아직 기회가 남았다면 12방향 순회
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				int nk = d < 4 ? cur.k : cur.k + 1;
			    int nCnt = cur.cnt + 1;
				
				if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
				if (visited[nx][ny][nk]) continue;
				if (road[nx][ny] == 1) continue;
				
				visited[nx][ny][nk] = true;
				q.offer(new Pos(nx, ny, nk, nCnt));
			}
		}		
		System.out.println(-1);
	}	
}