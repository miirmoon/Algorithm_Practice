import java.util.Scanner;

/**
 * BeakJoon 3985. 롤 케이크
 * Date: 2021. 8. 25.
 * @author MIRAE
 */

public class Solution_3985 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		int N = sc.nextInt();
		
		int[] cake = new int[L+1];
		int[] audience = new int[N+1];
		int aud1 = 0, aud1cake = 0, aud2 = 0;
		
		// 각 방청객이 원하는 케이크 조각 입력받고 기록하기
		for (int i = 1; i <= N; i++) {
			int p = sc.nextInt();
			int k = sc.nextInt();
			
			for (int j = p; j <= k; j++) {
				if (cake[j] == 0) {
					cake[j] = i;      // 방청객이 원하는 케이크 조각에 기록
					audience[i]++;    // 각 방청객이 실제로 받는 케이크 조각 수 카운트
				}
			}			
			if (aud1cake < k-p) {  // 가장 많은 조각을 받을 것으로 기대하고 있는 방청객
				aud1cake = k-p;
				aud1 = i; 
			}
		}
		// 실제로 가장 많은 조각을 받는 방청객
		for (int i = 1; i <= N; i++) {
			if(audience[aud2] < audience[i]) aud2 = i;
		}
		System.out.println(aud1 + "\n" + aud2);
		sc.close();
	}
}
