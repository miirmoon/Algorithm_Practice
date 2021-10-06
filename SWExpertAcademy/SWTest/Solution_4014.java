import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA 4014. 활주로 건설
 * Date: 2021. 10. 7.
 * @author MIRAE
 */

public class Solution_4014 {
	private static int N, X;
	private static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			
			for (int i = 0; i < N; i++) {
				if (isConst(i, 0, 0, 1)) cnt++;  // 가로방향 확인
				if (isConst(0, i, 1, 0)) cnt++;  // 세로방향 확인
			}
			
			System.out.println("#" + tc + " " + cnt);
		}
	}

	private static boolean isConst(int x, int y, int dx, int dy) {
		int data = map[x][y], cnt = 1;
		boolean down = false;
		
		for (int i = 1; i < N; i++) {
			x += dx;
			y += dy;
			int cur = map[x][y];
			
			if (data == cur) {   // 이전 지형과 높이가 같으면 카운트
				cnt++;
				continue;
			}
			
			if (Math.abs(data-cur) > 1) return false;  // 높이가 2 이상이면 경사로 설치 불가
			if (data < cur) {
				if (!down && cnt < X) return false;    // 높이가 높아지다가 높아졌을 때 이전 지형의 수가 경사로 길이(X)보다 적으면 경사로 설치 불가
				if (down && cnt < 2*X) return false;   // 높이가 낮아지다가 높아진 경우 이전 지형의 수는 경사로 길이의 2배 이상이어야 함
				cnt = 1;
				down = false;
			} else {
				if (down && cnt < X) return false;  // 높이가 낮아지다가 더 낮아진 경우 이전 지형의 수 확인 필요
				cnt = 1;
				down = true;
			}
			data = cur;
		}
		if (down && cnt < X) return false;    // 마지막 지형 확인
		
		return true;
	}
}
