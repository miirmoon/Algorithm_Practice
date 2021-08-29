import java.util.Scanner;

/**
 * SWEA 6485. 삼성시의 버스 노선
 * Date: 2021. 8. 29.
 * @author MIRAE
 */

public class Solution_6485 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); 
			int[] p = new int[5001];
			for (int n = 0; n < N; n++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				for (int i = a; i <= b; i++) {  // i번째 버스가 다니는 정류장에 표시
					p[i]++;
				}
			}
			
			int P = sc.nextInt();
			System.out.print("#"+tc);
			for (int i = 1; i <= P; i++) {    
				System.out.print(" " + p[sc.nextInt()]);
			}
			System.out.println();
		}
		sc.close();
	}
}
