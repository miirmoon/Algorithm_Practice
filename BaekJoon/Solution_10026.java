import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BeakJoon 10026. 적록색약
 * Date: 2021. 8. 25.
 * @author MIRAE
 */

public class Solution_10026 {
	
	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	private static int N;
	private static char[][] painting;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		painting = new char[N][];
		for (int i = 0; i < N; i++) {
			painting[i] = br.readLine().toCharArray();
		}
		
		int normal = countGroup();  // 적록색약이 아닌 사람이 봤을 때 구역 수
		
		for (int i = 0; i < N; i++) {   // G인 색을 R로 바꾸어줌
			for (int j = 0; j < N; j++) {
				if (painting[i][j] == 'G') painting[i][j] = 'R';
			}
		}
		
		int weak = countGroup();  // 적록색양인 사람이 봤을 때 구역 수
		
		System.out.println(normal + " " + weak);
	}
	private static int countGroup() {
		Queue<Pos> q = new LinkedList<Pos>();
		boolean[][] selected = new boolean[N][N];
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		int groupNum = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (selected[i][j]) continue;
				
				q.add(new Pos(i, j));
				char color = painting[i][j];
				
				while (!q.isEmpty()) {
					Pos cur = q.poll();
					selected[cur.x][cur.y] = true;
					
					for (int d = 0; d < 4; d++) {
						int nx = cur.x + dx[d];
						int ny = cur.y + dy[d];
						if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
						if (selected[nx][ny]) continue;
						
						if (painting[nx][ny] == color) {  // 같은 색인 경우에만 추가 탐색
							q.add(new Pos(nx, ny));
							selected[nx][ny] = true;
						}
					}
				} 
				groupNum++;   // 한가지 색에 대한 탐색이 끝났을 때 개수 카운트
			}
		}
		return groupNum;
	}
}
