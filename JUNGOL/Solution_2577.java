import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Jungol 2577. 회전 초밥(고)
 * Date: 2021. 10. 5.
 * @author MIRAE
 */

public class Solution_2577 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());   // 회전 초밥 벨트에 놓인 접시 수
		int d = Integer.parseInt(st.nextToken());   // 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken());   // 연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken());   // 쿠폰 번호
		
		int[] belt = new int[N];
		
		for (int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}

		// 맨 앞(0)에서부터 k개 접시의 초밥 번호 기록
		int cnt = k+1;                   // 먹을 수 있는 최대 가짓수로 초기화(연속해서 먹는 접시 수 + 쿠폰 1개)
		int[] ate = new int[d+1];
		for (int i = 0; i < k; i++) {
			if (ate[belt[i]] > 0) cnt--;                  // 이미 먹은 번호의 초밥인 경우 가짓수 하나 줄이기
			if (ate[belt[i]] == 0 && belt[i] == c) cnt--; // 먹으려는 초밥 번호가 쿠폰 번호와 동일할 경우 가짓수 하나 줄이기
			ate[belt[i]]++;                               // 초밥 번호를 인덱스로 하여 개수 기록
		}
		
		int maxCnt = cnt;  // 연속해서 먹는 접시 최대 개수(최초 구한 개수로 초기화)
		
		// 두 번째 위치부터 N번째 위치까지를 시작점으로 k개 접시를 먹을 때 가짓수 구하기
		for (int i = 1; i < N; i++) {		
			ate[belt[i-1]]--;                  // i-1번째 위치부터 시작하는 가짓수는 계산 완료했으므로 해제
			if (ate[belt[i-1]] == 0) cnt--;    // 해제한 후 0이면 이제는 없는 종류이므로 가짓수 하나 줄이기
			if (ate[belt[i-1]] == 0 && belt[i-1] == c) cnt++;    // i-1 번째가 유일하게 쿠폰번호와 같았다면 가짓수 하나 늘리기 
			
			int kSushi = (i+k-1) % N;
			ate[belt[kSushi]]++;                   // i번째 위치부터 시작했을 때 k번째 위치의 접시 기록
			if (ate[belt[kSushi]] == 1) cnt++;     // 1이면 새로운 종류이므로 가짓수 하나 늘리기
			if (ate[belt[kSushi]] == 1 && belt[kSushi] == c) cnt--; // 새로 추가된 접시가 유일하게 쿠폰번호와 같으면 가짓수 하나 줄이기
			
			maxCnt = Math.max(maxCnt, cnt);
		}		
		System.out.println(maxCnt);
	}
}
