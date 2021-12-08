import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BeakJoon 3085. 사탕 게임
 * Date: 2021. 12. 9.
 * Solution: Brute Force(브루트 포스) - 가능한 모든 방법을 모두 대입해보는 방식
 * @author MIRAE
 */

public class Solution_3085 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		char[][] board = new char[N][];
		for (int n = 0; n < N; n++) {
			board[n] = br.readLine().toCharArray();
		}
		
		int maxCandy = 1;
		int[] dx = new int[] {-1, 0, 1, 0};
		int[] dy = new int[] {0, 1, 0, -1};
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 상, 하, 좌, 우의 사탕 색 확인
				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					
					if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

					char[][] tmp = copyArr(board);
					tmp[i][j] = board[nx][ny];
					tmp[nx][ny] = board[i][j];
					
					maxCandy = Math.max(maxCandy, countCandy(tmp, 1, i));
					maxCandy = Math.max(maxCandy, countCandy(tmp, 2, j));
				}
			}
		}
		System.out.println(maxCandy);
	}
	
	// 배열 복사
	private static char[][] copyArr(char[][] arr) {
		int N = arr.length;
		char[][] copy = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = arr[i][j];
			}
		}
		
		return copy;
	}
	
	// 같은 사탕 갯수 확인하기
	private static int countCandy(char[][] arr, int flag, int rc) {
		int count = 1;
		int max = 0;
		char tmp = flag == 1 ? arr[rc][0] : arr[0][rc];
		for (int i = 1; i < arr.length; i++) {
			if (tmp == (flag == 1 ? arr[rc][i] : arr[i][rc])) {
				count++;
				continue;
			}
			max = Math.max(max, count);
			count = 1;
			tmp = flag == 1 ? arr[rc][i] : arr[i][rc];
		}
		max = Math.max(max, count);
		return max;
	}
}
