import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BaekJoon 17144. 미세먼지 안녕!
 * Date: 2021. 9. 24.
 * Solution: 시뮬레이션
 * 		- spread(): 미세먼지 확산 동작
 * 		- circulate(): 공기청정기 작동, 공기 순환 동작
 * @author MIRAE
 */

public class Solution_17144 {
	private static int R, C, pos;
	private static int[][] room;
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		room = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				
				if (room[i][j] == -1) pos = i;
			}
		}
		
		for (int t = 0; t < T; t++) {
			spread();
			circulate();
		}
		
		// 미세먼지 양 구하기
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (room[i][j] <= 0) continue;
				
				sum += room[i][j];
			}
		}
		
		System.out.println(sum);
	}
	
	/**
	 *  인접한 4개 방향으로 미세먼지 확산
	 *  - 확산되는 양: A(r, c) * 1/5
	 *  - 확산되고 남은 양: A(r, c) - A(r, c) * 1/5 * 확산된 방향의 개수
	 */
	private static void spread() {
		int[][] arr = new int[R][C];
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (room[r][c] == -1) arr[r][c] = -1;
				if (room[r][c] < 5) {  // 1/5씩 확산되므로 미세먼지가 5미만일 경우 확산되지 않음
					arr[r][c] += room[r][c];
					continue;  
				}
				int amount = room[r][c] / 5;
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
					if (room[nr][nc] == -1) continue;
					
					arr[nr][nc] += amount;
					cnt++;
				}
				arr[r][c] += room[r][c] - (amount * cnt);
			}
		}

		room = arr;
	}
	
	/**
	 * 공기청정기 작동 
	 * - 위쪽 바람은 반시계방향으로, 아래쪽 방향은 시계방향으로 순환
	 * - 바람의 방향에 따라 한 칸씩 이동
	 * @param idx: 공기청정기(아래쪽) 위치(행 인덱스)
	 */
	private static void circulate() {
		// 위쪽 순환(반시계방향)
		int r = pos-1, c = 0;
		for (int d = 0; d < 4; d++) {
			while (true) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if (nr < 0 || nr > pos-1 || nc < 0 || nc >= C) break;
				if (nr == pos-1 && nc == 0) {
					room[pos-1][1] = 0;
					break;
				}
				
				room[r][c] = room[nr][nc];
				r = nr;
				c = nc;
			}
		}
		room[pos-1][0] = -1;
		
		// 아래쪽 순환(시계방향)
		r = pos;
		c = 0;
		int d = 2;
		for (int i = 0; i < 4; i++) {
			while (true) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if (nr < pos || nr >= R || nc < 0 || nc >= C) break;
				if (nr == pos && nc == 0) {
					room[pos][1] = 0;
					break;
				}
				
				room[r][c] = room[nr][nc];
				r = nr;
				c = nc;
			}
			d = (d > 0) ? d-1 : 3;
		}
		room[pos][0] = -1;
	}
}
