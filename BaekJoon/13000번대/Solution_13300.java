import java.util.Scanner;

/**
 * BaekJoon 13300. 방 배정
 * Date: 2021. 8. 24.
 * @author MIRAE
 */

public class Solution_13300 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] room = new int[7][2];
		
		// 수학여행에 참가하는 학생 수 입력 받기
		for (int i = 0; i < N; i++) {
			int s = sc.nextInt();
			int y = sc.nextInt();
			
			room[y][s]++;
		}
		// 학생 수에 따라 필요한 방의 수 카운트하기
		int count = 0;
		for (int i = 1; i < 7; i++) {
			for (int j = 0; j < 2; j++) {
				count += (room[i][j]+K-1) / K;
			}
		}
		System.out.println(count);
		sc.close();
	}
}
