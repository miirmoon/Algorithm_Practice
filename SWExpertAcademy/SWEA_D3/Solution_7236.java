import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * SWEA 7236. 저수지의 물의 총 깊이 구하기
 * Date: 2021. 8. 29.
 * @author MIRAE
 */

public class Solution_7236 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[][] arr = new String[N][];
			
			for (int n = 0; n < N; n++) {
				arr[n] = br.readLine().split(" ");
			}
			
			int depth = 0;
			int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
			int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j].contains("G")) continue; // 현재 위치가 땅(G)이면 pass
					
					// 현재 위치가 물(W)일 때 8개 방향에 있는 물(W)의 개수 확인
					int water = 0;
					for (int d = 0; d < 8; d++) {
						int nx = i+dx[d];
						int ny = j+dy[d];
						if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
						
						if (arr[nx][ny].contains("W")) water++;
					}
					depth = Math.max(depth, water);
				}
			}
			if (depth == 0) depth = 1;
			System.out.println("#" + tc + " " + depth);
		}
	}
}
