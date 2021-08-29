import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA 1859. 백만 장자 프로젝트
 * Date: 2021. 8. 29.
 * @author MIRAE
 */

public class Solution_1859 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] price = new int[N];
			long cnt = 0, buy = 0, max = 0;
			long res = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}			
			for (int n = N-1; n >= 0; n--) {  // 뒤에서부터 검사
				
				if (n == N-1) {         // 맨 뒤 매매가를 max 값으로 초기화
					max = price[n];
					continue;
				}
				
				if (price[n] >= max) {     // 현재 매매가가 현재까지의 최댓값 max보다 크면
					res += max*cnt - buy;  // 현재까지 구매한 원료 최댓값으로 판매
					max = price[n];
					buy = 0;
					cnt = 0;
					continue;
				}			
				buy += price[n];        // 위 조건에 해당하지 않으면 현재 매매가로 구매
				cnt++;
				
				if (n == 0) res += max*cnt - buy;  // 첫째날까지 검사가 완료되면 해당 기간의 최댓값으로 판매
			}
			System.out.println("#" + tc + " " + res);
		}
	}
}
