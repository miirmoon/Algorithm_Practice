import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Jungol 1733. 오목
 * Date: 2021. 8. 29.
 * @author MIRAE
 */

public class Solution_1733 {
	private static String[][] baduk;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		baduk = new String[19][];
		String res = "0";
		int resX = 0, resY = 0;
		
		for (int i = 0; i < 19; i++) {
			baduk[i] = br.readLine().split(" ");
		}
		
		outer: for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (baduk[i][j].contains("0")) continue;
				
				if (solve(i, j)) {
					res = baduk[i][j];
					resX = i;
					resY = j;
					break outer;
				}
			}
		}
		System.out.println(res);
		if (res.contains("1") || res.contains("2")) 
			System.out.println((resX+1) + " " + (resY+1));
	}
	private static boolean solve(int x, int y) {
		// 하, 우, 하우, 상우 방향으로 이어진 바둑돌만 오목 유효성 검사하기
		int[] dx = {-1, 1, 0, 0, -1, 1, 1, -1};  // 상-하 좌-우 상좌-하우 하좌-상우
		int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
		
		String stone = baduk[x][y];
		for (int d = 0; d < 8; d+=2) {
			int nx1 = x + dx[d];
			int ny1 = y + dy[d];
			int nx2 = x + dx[d+1];
			int ny2 = y + dy[d+1];
			
			if (!isIn(nx2, ny2)) continue;
			
			// 상, 좌, 상좌, 하좌 위치가 막혀있고, 하, 우, 하우, 상우 방향으로 (x, y)와 같은 색의 돌이 있을 때
			if ((!isIn(nx1, ny1) || !baduk[nx1][ny1].contains(stone)) && baduk[nx2][ny2].contains(stone)) {
				int cnt = 2;    // 현재 2개까지 같은 색의 돌임(x, y), (nx2, ny2)
				int tmpx = nx2;
				int tmpy = ny2;
				while (true) {
					if (cnt > 5) break;  // 6개 이상 넘어가면 더 이상 볼 필요없음
					tmpx += dx[d+1];
					tmpy += dy[d+1];
					if (!isIn(tmpx, tmpy)) break;  // 바둑판 영역을 벗어나면 중단
					if (!baduk[tmpx][tmpy].contains(stone)) break;  // 다른 색의 돌이 나오면 중단
					cnt++;
				}
				if (cnt == 5) return true;
			}
		}
		return false;
	}
	// 바둑판 영역을 벗어나는지 검사하기
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < 19 && y >= 0 && y < 19;
	}
}
