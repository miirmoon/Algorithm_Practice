import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA 7964. 부먹왕국의 차원 관문
 * Date: 2021. 8. 29.
 * @author MIRAE
 */

public class Solution_7964 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int door = 0;
			
			st = new StringTokenizer(br.readLine(), " ");
			int destroyed = 0;   // 파괴된 도시 수(제한거리 확인 위함)
			for (int n = 0; n < N; n++) {
				String tmp = st.nextToken();
				if (tmp.contains("1")) {  // 차원관문이 있으면 파괴된 도시 수(제한거리) 0으로 초기화
					destroyed = 0;
					continue;
				}
				
				// tmp가 0일 때
				destroyed++;  
				
				if (destroyed == D) {  // 파괴된 도시 수가 D와 같으면 차원관문 건설
					door++;
					destroyed = 0;
				}				
			}
			System.out.println("#" + tc + " " + door);
		}
	}
}
