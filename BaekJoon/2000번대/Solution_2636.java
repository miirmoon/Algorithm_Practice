import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BeakJoon 2636. 치즈
 * Date: 2021. 9. 15.
 * @author MIRAE
 */

public class Solution_2636 {
	private static int R, C, cheeseCnt;
	private static int[][] plate;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		plate = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				plate[i][j] = Integer.parseInt(st.nextToken());
				if (plate[i][j] == 1) cheeseCnt++;
			}
		}
		
		int lastCnt = 0, time = 0;
		while (cheeseCnt > 0) {
			lastCnt = cheeseCnt;
			time++;
			changeBad();
		}
		System.out.println(time);
		System.out.println(lastCnt);
	}
	/**
	 *  공기와 맞닿아 상한 치즈를 공기(0)로 바꾸기
	 *  - BFS 이용
	 */
	private static void changeBad() {
		boolean[][] visited = new boolean[R][C];
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {0, 0});
		visited[0][0] = true;
		
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = tmp[0] + dr[d];
				int nc = tmp[1] + dc[d];
				
				if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;  // 범위 밖으로 나가면 pass
				
				if (visited[nr][nc]) continue;  // 이미 방문했던 위치이면 pass
				
				visited[nr][nc] = true;         // 방문 체크하기
				
				if (plate[nr][nc] == 0) {       // 다음 방문을 위해 큐에 넣기
					q.offer(new int[] {nr, nc});
					continue;
				}
				plate[nr][nc] = 0;              // 치즈를 공기(0)로 바꾸기
				cheeseCnt--;
			}
		}
	}
}
