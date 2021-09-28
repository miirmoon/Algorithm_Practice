import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA 8458. 원점으로 집합
 * Date: 2021. 9. 28.
 * @author MIRAE
 */

public class Solution_8458 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		tc: for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] point = new int[N];
			int res = 0;
			int max = 0;
			
			int check = 0;   // 각 점에서 원점으로의 거리의 짝수(0), 홀수(1) 판단(모든 거리가 짝수 또는 홀수로 일치해야 함)
			for (int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int dis = Math.abs(Integer.parseInt(st.nextToken())) + Math.abs(Integer.parseInt(st.nextToken()));
				
				if (res == -1) continue;       // res가 -1이면 더이상 연산이 필요없음
				
				if (n == 0) check = dis % 2;
				else if (dis % 2 != check) res = -1;     // 모든 원점의 거리가 짝수 또는 홀수로 일치하지 않으면 모든 점을 원점으로 이동시킬 수 없다
				
				point[n] = dis;
				max = Math.max(max, dis);
			}
			
			if (res == -1) {    // 모든 점을 원점으로 이동시킬 수 없을 때
				System.out.println("#" + tc + " " + res);
				continue tc;
			}
			
			if (max == 0) {     // 입력된 모든 점이 원점에 있을 때
				System.out.println("#" + tc + " 0");
				continue tc;
			}
			
			
			int moveCnt = 0;
			outer: while (true) {
				moveCnt += ++res;
				if (moveCnt < max) continue;         // 가장 큰 값과 원점 사이의 거리보다 작을 때에는 원점에 도착 불가
				if (moveCnt % 2 != check) continue;  // 점들과 같은 짝수 또는 홀수일 때 원점에 도착 가능
				
				for (int i = 0; i < N; i++) {        // 모든 점의 길이의 공배수이면 모든 점이 원점에 도착
					if (point[i] == 0) continue;
					if (moveCnt % point[i] == 1) continue outer;
				}				
				break;
			}
			
			System.out.println("#" + tc + " " + res);
		}
	}
}