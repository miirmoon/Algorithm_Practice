import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA 7465. 창용 마을 무리의 개수
 * Date: 2021. 8. 24.
 * @author MIRAE
 */

public class Solution_7465 {
	private static int[] leaders;   // 각 원소의 부모 원소를 담을 배열
	private static int groupNum;    // 무리의 개수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
						
			// {1}, {2} ... {N} 만들기
			leaders = new int[N+1];
			for (int i = 1; i <= N; i++) {
				leaders[i] = i;
			}
			
			groupNum = N;   // 무리의 개수를 N개로 초기화
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			System.out.println("#" + tc + " " + groupNum);
		}
	}
	
	// 무리의 리더 찾기
	private static int findLeader(int n) {
		if (n == leaders[n]) return n;
		
		return leaders[n] = findLeader(leaders[n]);		
	}
	// 각 무리에 서로 아는 관계가 포함되어있을 때 한 무리로 통합
	private static void union(int a, int b) {
		int leaderA = findLeader(a);
		int leaderB = findLeader(b);
		if (leaderA == leaderB) return;
		
		leaders[leaderA] = leaderB;
		groupNum--;    // 통합되면 무리 개수가 1 줄어듦
	}
}
