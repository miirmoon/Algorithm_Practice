import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BeakJoon 16236. 아기 상어
 * Date: 2021. 8. 25.
 * @author MIRAE
 */

public class Solution_16236 {
	static class Pos {
		int x, y;
		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	private static int N;
	private static int[][] map;
	private static int[] dx = {-1, 0, 0, 1};  // 상, 좌, 우, 하
	private static int[] dy = {0, -1, 1, 0};
	private static Pos shark, fish;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) shark = new Pos(i, j);
			}
		}
		
		System.out.println(hunt());
	}
	private static int hunt() {
		Queue<Pos> q = new LinkedList<Pos>();
		boolean[][] visited = new boolean[N][N];
		int moveSec = 0;  // 움직인 시간(초)
		int eat = 0;       // 먹은 물고기 수
		int size = 2;      // 현재 상어의 크기
		
		q.add(new Pos(shark.x, shark.y));
		map[shark.x][shark.y] = 0; 
		int lvl = 0;
		while (!q.isEmpty()) {
			int qSize = q.size();
			lvl++;
			
			for (int i = 0; i < qSize; i++) {
				Pos cur = q.poll();
				
				// 이번 level에 움직일 수 있는 위치 확인 
				for (int d = 0; d < 4; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;  // 공간 범위를 벗어나면 pass
					if (visited[nx][ny]) continue;      // 이미 방문한 지점인 경우 pass
					if (map[nx][ny] > size) continue;     // 상어보다 큰 물고기가 있으면 pass
					
					q.add(new Pos(nx, ny));    // 위에서 걸러지지 않은 경우 이동 조건이 되므로 큐에 넣음
					visited[nx][ny] = true;
					
					if (map[nx][ny] == 0 || map[nx][ny] == size) continue;  // 비어있거나 물고기의 크기가 상어 크기와 같은 경우 pass
					
					// ========  먹을 수 있는 물고기가 있는 경우
					if (fish == null) {    // 이번 level에서 먹을 수 있는 물고기가 아직 없었을 때
						fish = new Pos(nx, ny);
					} else {               // 같은 level에 먹을 수 있는 물고기가 있었다면 위치 비교
						if (nx < fish.x || (nx == fish.x && ny < fish.y)) fish = new Pos(nx, ny);  // 더 위에 있거나 같은 높이라면 더 왼쪽에 있을 때 먹을 물고기 변경
					}
				}
			}
			// 이번 초에 움직일 수 있는 위치 비교 끝, 다음 초로 넘어가기 전 먹을 물고기가 있으면 물고기 먹고 변수 초기화하기
			if (fish != null) {	
				q.clear();                       // 새로운 위치에서 시작하기 위해 큐 초기화
				q.add(new Pos(fish.x, fish.y));  // 상어는 fish 위치로 이동
				map[fish.x][fish.y] = 0;
				
				fish = null;                     // 다음 번에 먹을 물고기를 찾기 위해 null 초기화
				eat++;                           // 물고기 먹은 수 증가
				if (eat == size) {               // 물고기를 먹은 수와 상어 크기가 같으면 크기가 1커지고 먹은 수 0으로 초기화
					size++;
					eat = 0;
				}
				visited = new boolean[N][N];     // 물고기를 먹고 상어가 그 위치로 이동했기 때문에 해당 위치에서 다시 확인 필요
				moveSec += lvl;                  // 물고기를 먹기까지 이동한 level이 움직인 초(위치)이므로 합산 후 초기화
				lvl = 0;
			}	
		}
		return moveSec;
	}
}