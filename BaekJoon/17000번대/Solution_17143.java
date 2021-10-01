import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BaekJoon 17143. 낚시왕
 * Date: 2021. 10. 1.
 * @author MIRAE
 */

public class Solution_17143 {
	private static class Shark {
		int r, c, speed, dir, size;

		public Shark(int r, int c, int speed, int dir, int size) {
			this.r = r;
			this.c = c;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}
	}
	
	private static int R, C;
	private static Shark[][] map;
	private static ArrayList<Shark> list;
	private static int[] dr = {0, -1, 1, 0, 0};
	private static int[] dc = {0, 0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new Shark[R+1][C+1];
		list = new ArrayList<Shark>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			map[r][c] = new Shark(r, c, s, d, z);
			list.add(map[r][c]);
		}
		
		int sum = 0;
		// 낚시왕의 이동(매 초 오른쪽으로 한 칸)
		for (int king = 1; king <= C; king++) {
			// 낚시왕이 있는 열에서 가장 가까운 상어 잡기
			for (int i = 1; i <= R; i++) {
				if (map[i][king] == null) continue;
				
				sum += map[i][king].size;
				list.remove(map[i][king]);
				map[i][king] = null;
				break;
			}
			
			// 상어 이동
			moveShark();
			
			// 같은 자리에 여러 마리 상어가 있을 경우 가장 큰 상어만 남기고 죽이기
			killShark();
		}
		System.out.println(sum);
	}

	private static void moveShark() {
		for (Shark shark: list) {
			map[shark.r][shark.c] = null;
			int ns = shark.speed % ((shark.dir <= 2 ? R-1 : C-1)*2);
			int d = shark.dir;
			
			for (int s = ns; s > 0; s--) {
				int nr = shark.r + dr[d];
				int nc = shark.c + dc[d];
				
				if (nr <= 0 || nr > R || nc <= 0 || nc > C) {
					if (d % 2 == 0) d -= 1;  // 2 -> 1 / 4 -> 3
					else d += 1;             // 1 -> 2 / 3 -> 4
					shark.dir = d;
					s++;
					continue;
				}
				shark.r = nr;
				shark.c = nc;
			}
			map[shark.r][shark.c] = shark;
		}
	}
	
	private static void killShark() {
		int size = list.size();
		for (int i = size-1; i >= 0; i--) { // 중간에 리스트의 요소가 삭제되므로 뒤에서부터 탐색
			Shark cur = list.get(i);
			
			if (map[cur.r][cur.c] == cur) continue;
			if (map[cur.r][cur.c] == null) {
				map[cur.r][cur.c] = cur;
				continue;
			}
			
			if (map[cur.r][cur.c].size < cur.size) {
				list.remove(map[cur.r][cur.c]);
				map[cur.r][cur.c] = cur;
			} else {
				list.remove(cur);
			}
		}
	}
}
