import java.util.Scanner;

/**
 * BaekJoon 4963. 섬의 개수
 * Date: 2021. 8. 23. 
 * @author MIRAE
 */

public class Solution_4963 {
	private static int w, h;
	private static int[][] island;
	private static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	private static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			w = sc.nextInt();   // 지도의 너비
			h = sc.nextInt();   // 지도의 높이
			
			if (w == 0 && h == 0) break;   // 너비와 높이가 0으로 입력되면 중단
			
			island = new int[h][w];			
			for (int i = 0; i < h; i++) {   // 지도 내용 입력받기
				for (int j = 0; j < w; j++) {
					island[i][j] = sc.nextInt();
				}
			}
			
			int count = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (island[i][j] == 1) {  // 땅의 위치에서 dfs함수 호출
						dfs(i, j);    // i, j 지점부터 연결된 위치는 0으로 표시하고, 시작지점의 개수를 카운트
						count++;
					}
				}
			}
			System.out.println(count);
		}
		sc.close();
	}
	// 연결된 섬 찾기: (x, y) 지점부터 8개 방향으로 검사하여 연결된 지점이 있으면 그 위치로 이동하여 확인했음을 체크(0)
	private static void dfs(int x, int y) {
		island[x][y] = 0;
		
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
			
			if (island[nx][ny] == 1) {  // 연결된 지점은 0으로 체크 후 해당 위치로 이동
				island[nx][ny] = 0;
				dfs(nx, ny);
			}
		}
	}
	
}
