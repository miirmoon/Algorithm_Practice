import java.util.Scanner;

/**
 * SWEA 1984. 중간 평균값 구하기
 * Date: 2021. 8. 29.
 * @author MIRAE
 */

public class Solution_1984 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int[] num = new int[10];
			int max = 0, maxi = 0;
			int min = 10000, mini = 0;
			for (int i = 0; i < 10; i++) {
				num[i] = sc.nextInt();
				if (max < num[i]) {     // 최댓값과 그 인덱스 구하기
					max = num[i];
					maxi = i;
				}
				if (min > num[i]) {     // 최솟값과 그 인덱스 구하기
					min = num[i];
					mini = i;
				}
			}
			
			int sum = 0;
			for (int i = 0; i < 10; i++) {   // 최댓값과 최솟값은 제외하고 합산
				if (i == maxi || i == mini) continue;
				sum += num[i];
			}
			
			System.out.println("#" + tc + " " + Math.round(sum/8.0));		
		}
		sc.close();
	}
}
