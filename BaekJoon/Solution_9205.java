import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BeakJoon 9205. 맥주 마시면서 걸어가기
 * Date: 2021. 9. 16.
 * @author MIRAE
 */

public class Solution_9205 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] pos = new int[N+2][2];
			int[][] adj = new int[N+2][N+2];
			
			for (int n = 0; n < N+2; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				pos[n][0] = Integer.parseInt(st.nextToken());
				pos[n][1] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < N+1; i++) {
				for (int j = i+1; j < N+2; j++) {
					int dis = Math.abs(pos[i][0]-pos[j][0]) + Math.abs(pos[i][1]-pos[j][1]);
					
					if (dis <= 1000) dis = 1; // 이동 가능한 거리인 경우
					adj[i][j] = dis;          // 이동 불가능한 거리인 경우 충분히 큰 값
					adj[j][i] = dis;
				}
			}
			
			for (int k = 0; k < N+2; k++) {
				for (int i = 0; i < N+2; i++) {
					if (i == k) continue;
					for (int j = 0; j < N+2; j++) {
						if (j == k || j == i) continue;
						
						adj[i][j] = Math.min(adj[i][k] + adj[k][j], adj[i][j]);
					}
				}
			}
			
			System.out.println(adj[0][N+1] < 1000 ? "happy" : "sad");
		}
	}
}
