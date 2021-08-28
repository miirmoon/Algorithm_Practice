import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BaekJoon 2567. 색종이-2
 * Date: 2021. 8. 28. 
 * @author MIRAE
 */

public class Solution_2567 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] paper = new int[101][101];
		
		// 색종이를 붙이는 영역에 1로 채우기
		for (int n = 0; n < N; n++) {    
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int i = x; i < x+10; i++) {
				for (int j = y; j < y+10; j++) {
					paper[i][j] = 1;
				}
			}
		}
		
		// 색종이가 붙어있는 영역의 상하좌우를 확인하여 0이면 둘레길이 +1
		int len = 0;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				if (paper[i][j] == 0) continue; 
				// 종이가 붙어있는 영역일 때 상하좌우 확인
				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					
					if (nx < 0 || nx >= 101 || ny < 0 || ny >= 101) continue;
					if (paper[nx][ny] == 0) len++;
				}
			}
		}
		System.out.println(len);
	}
}
