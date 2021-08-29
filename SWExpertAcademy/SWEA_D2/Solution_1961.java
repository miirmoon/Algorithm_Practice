import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * SWEA 1961. 숫자 배열 회전
 * Date: 2021. 8. 29.
 * @author MIRAE
 */

public class Solution_1961 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[][] arr = new String[N][];
			StringBuffer[] res = new StringBuffer[N];
			
			for (int n = 0; n < N; n++) {
				arr[n] = br.readLine().split(" ");
			}
			
			// 90도 회전
			for (int c = 0; c < N; c++) {
				res[c] = new StringBuffer();
				for (int r = N-1; r >= 0; r--) {
					res[c].append(arr[r][c]);
				}
				res[c].append(" ");
			}
			
			// 180도 회전
			for (int r = N-1; r >= 0; r--) {
				for (int c = N-1; c >= 0; c--) {
					res[N-1-r].append(arr[r][c]);
				}
				res[N-1-r].append(" ");
			}
			
			// 270도 회전
			for (int c = N-1; c >= 0; c--) {
				for(int r = 0; r < N; r++) {
					res[N-1-c].append(arr[r][c]);
				}
			}
			
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				System.out.println(res[i]);
			}
		}
	}
}
