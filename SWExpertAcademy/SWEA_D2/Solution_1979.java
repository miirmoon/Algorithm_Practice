import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA 1979. 어디에 단어가 들어갈 수 있을까
 * Date: 2021. 8. 29.
 * @author MIRAE
 */

public class Solution_1979 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			String[][] puzzle = new String[N][];
			int cnt = 0, res = 0;
			
			for (int i = 0; i < N; i++) {
				puzzle[i] = br.readLine().split(" ");
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (puzzle[i][j].contains("0")) continue;
					
					// 현재 위치가 왼쪽 끝이거나 왼쪽 원소가 0일 때 들어갈 자리 카운트 시작
					if (j == 0 || puzzle[i][j-1].contains("0")) {
						for (int right = j; right < N; right++) {
							if (cnt > K) break;
							if (puzzle[i][right].contains("0")) break;
							cnt++;
						}
						if (cnt == K) res++;
						cnt = 0;
					}
					
					// 현재 위치가 위쪽 끝이거나 위쪽 원소가 0일 때 들어갈 자리 카운트 시작
					if (i == 0 || puzzle[i-1][j].contains("0")) {
						for (int up = i; up < N; up++) {
							if (cnt > K) break;
							if (puzzle[up][j].contains("0")) break;
							cnt++;
						}
						if (cnt == K) res++;
						cnt = 0;
					}
				}
			}
			System.out.println("#" + tc + " " + res);
		}
	}
}
