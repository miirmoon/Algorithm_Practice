import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * SWEA 1767. 프로세서 연결하기
 * Date: 2021. 9. 17.
 * @author MIRAE
 */

public class Solution_1767 {
	private static int N;
	private static int[][] maxi;
	private static List<int[]> core;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			maxi = new int[N][N];
			core = new ArrayList<int[]>();   // 연결해야하는 코어 리스트
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					maxi[i][j] = Integer.parseInt(st.nextToken());
					if (maxi[i][j] == 1) {
						if (i == 0 || i == N-1 || j == 0 || j == N-1) {
							maxi[i][j] = 8;    // 이미 연결된 상태 표시
							continue;
						}
						core.add(new int[] {i, j});
					}
				}
			}
			
			int coreNum = 0;
			int sumLen = 0;
			for (int i = 0; i < core.size(); i++) {
				int[] tmp = linkCore(i);
				
				if (coreNum < tmp[0]) {    // 연결된 코어 개수 비교
					coreNum = tmp[0];
					sumLen = tmp[1];
				}
				
				if (coreNum == tmp[0] && sumLen > tmp[1]) {  // 코어 개수가 같을 경우 전선길이 비교
					sumLen = tmp[1];
				}
			}
			
			System.out.println("#" + tc + " " + sumLen);
		}
	}
	
	private static int[] linkCore(int idx) {
		int sumLen = 0;
		int coreNum = 0;
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int[][] copy = new int[N][N];
		
		// maxi 배열 복사하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = maxi[i][j];
			}
		}
		
		// idx번째 코어부터 시작해서 가장 짧은 위치에 core연결하기
		int i = idx;
		boolean tmp = false;
		while (!tmp || i != idx) {
			tmp = true;
			int[] cur = core.get(i);
			int dir = 0;
			int minCnt = N;
			
			i = (i+1) % core.size();
			
			// 연결할 수 있는 가장 짧은 위치 구하기
			outer: for (int d = 0; d < 4; d++) {
				int nx = cur[0];
				int ny = cur[1];
				int cnt = 0;
				while (true) {
					nx += dx[d];
					ny += dy[d];
					if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;
					if (copy[nx][ny] != 0) continue outer;
					
					cnt++;
				}
				if (minCnt > cnt) {
					minCnt = cnt;
					dir = d;
				}
			}
			
			if (minCnt == N) continue;   // 연결할 수 있는 위치가 없으면 다음 core로 pass
			
			// 구한 위치로 연결하기
			coreNum++;
			int a = cur[0], b = cur[1];
			while (true) {
				a += dx[dir];
				b += dy[dir];
				
				if (a < 0 || a >= N || b < 0 || b >= N) break;
				copy[a][b] = 9;
				sumLen++;
			}
		}
		
		return new int[] {coreNum, sumLen};
	}
}
