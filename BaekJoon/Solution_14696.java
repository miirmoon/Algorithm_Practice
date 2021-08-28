import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BeakJoon 14696. 딱지놀이
 * Date: 2021. 8. 28.
 * @author MIRAE
 */

public class Solution_14696 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(br.readLine());		
		int[] A, B;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			A = new int[5];                 // ★(4), ●(3), ■(2), ▲(1)
			for (int n = 0; n < a; n++) {   // A의 딱지에 그려진 모양의 개수 카운트
				A[Integer.parseInt(st.nextToken())]++;
			}
			
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			B = new int[5];                // ★(4), ●(3), ■(2), ▲(1)
			for (int n = 0; n < b; n++) {  // B의 딱지에 그려진 모양의 개수 카운트
				B[Integer.parseInt(st.nextToken())]++;
			}

			boolean existWinner = false;
			for (int s = 4; s > 0; s--) {    // ★부터 ▲까지 개수 비교
				if (A[s] == B[s]) continue;  // 개수가 같으면 다음 모양을 비교
				System.out.println(A[s] > B[s] ? "A" : "B");
				existWinner = true;
				break;
			}
			if (!existWinner) System.out.println("D");  // 모든 모양의 개수가 같으면(승자가 없으면) 무승부(D)
		}
	}
}
