import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Jungol 1205. 조커
 * Date: 2021. 8. 29.
 * @author MIRAE
 */

public class Solution_1205 {
	private static int[] card;
	private static int joker;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		card = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
			if (card[i] == 0) joker++;  // 조커 카드 수 세기
		}
		
		if (joker == N) {              // 카드가 모두 조커로만 이루어져 있으면 joker수를 출력하고 리턴
			System.out.println(joker);
			return;
		}
		Arrays.sort(card);

		int maxlen = 0;
		for (int i = joker; i < N; i++) { // 조커가 아닌 수만 검사
			maxlen = Math.max(maxlen, solve(i));
		}
		
		System.out.println(maxlen);
	} 
	private static int solve(int idx) {
		int cnt = 1;
		int jokertmp = joker;
		outer: for (int i = idx; i < card.length-1; i++) {
			if (card[i] == card[i+1]) continue;     // 현재 수와 다음 수가 같으면 pass
			if (card[i] + 1 == card[i+1]) {         // 다음 수가 현재 수+1 이면 길이 카운트 +1
				cnt++;
				continue;
			}
			if (jokertmp > 0 && card[i+1]-card[i]-1 <= jokertmp) { // 다음 카드와 현재 카드 수의 사이를 조커로 매꿀 수 있을 때
				cnt += card[i+1]-card[i];
				jokertmp -= (card[i+1]-card[i]-1);
				continue outer;
			}
			break;
		}
		cnt += jokertmp;

		return cnt;
	}
}
