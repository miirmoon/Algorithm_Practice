import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BeakJoon 10163. 색종이
 * Date: 2021. 8. 28.
 * Solution: 색종이가 놓여지는 위치에 순서번호를 채운다. 
 * 		다음 차례 색종이가 놓여질 때에 가려지는 부분은 다음 순서번호로 채워진다.
 * 		모든 색종이가 놓인 뒤 남은 각 순서번호의 수를 카운팅하면 해당되는 색종이의 면적이 된다.
 * @author MIRAE
 */

public class Solution_10163 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] paper = new int[1001][1001];
		
		for (int n = 1; n <= N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			for (int i = x; i < x+p; i++) {
				for (int j = y; j < y+q; j++) {
					paper[i][j] = n;
				}
			}
		}
		for (int n = 1; n <= N; n++) {
			int cnt = 0;
			for (int i = 0; i < 1001; i++) {
				for (int j = 0; j < 1001; j++) {
					if (paper[i][j] == n) cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}
