import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BeakJoon 2798. 블랙잭
 * Date: 2021. 8. 25.
 * @author MIRAE
 */

public class Solution_2798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] card = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(card);
		
		int sum = 0;
		for (int i = N-1; i >= 0 ; i--) {
			for (int j = i-1; j >= 0; j--) {
				for (int k = j-1; k >= 0; k--) {
					int tmp = card[i]+card[j]+card[k];
					if (tmp > sum && tmp <= M) sum = tmp;
				}
			}
		}
		System.out.println(sum);
	}
}
