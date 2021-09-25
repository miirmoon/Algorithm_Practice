import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BaekJoon 7576. 토마토
 * Date: 2021. 9. 24.
 * Solution: BFS(Breadth First Search)
 * @author MIRAE
 */

public class Solution_7576 {
	private static int M, N, totalCnt;
	private static int[][] box;
	private static Queue<int[]> ripeTomatos;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		box = new int[N][M];
		ripeTomatos = new LinkedList<int[]>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 0) totalCnt++;
				if (box[i][j] == 1) {
					ripeTomatos.offer(new int[] {i, j});
				}
			}
		}
		
		if (totalCnt == 0) {             // 익지않은 토마토가 없을 때
			System.out.println(0);
			return;
		}
		if (ripeTomatos.size() == 0) {   // 익지 않은 토마토는 있으나 익은 토마토가 없을 때
			System.out.println(-1);
			return;
		}
		
		int answer = ripen();
		
		System.out.println(totalCnt == 0 ? answer : -1);
		
	}
	
	private static int ripen() {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		int time = 0;
		while (!ripeTomatos.isEmpty()) {
			time++;
			int num = ripeTomatos.size();
			for (int i = 0; i < num; i++) {
				int[] cur = ripeTomatos.poll();
				int x = cur[0];
				int y = cur[1];
				
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					
					if (box[nx][ny] != 0) continue;
					
					ripeTomatos.offer(new int[] {nx, ny});
					box[nx][ny] = 1;
					totalCnt--;
				}
			}
		}
		return time-1;
	}
}
