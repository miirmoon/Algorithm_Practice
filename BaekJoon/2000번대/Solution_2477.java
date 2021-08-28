import java.util.Scanner;

/**
 * BeakJoon 2477. 참외밭
 * Date: 2021. 8. 28.
 * @author MIRAE
 */

public class Solution_2477 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int[] len = new int[6];
		int w = 0, h = 0;       // 가장 긴 너비와 높이
		int iw = 0, ih = 0; // 가장 긴 너비와 높이의 인덱스
		
		for (int i = 0; i < 6; i++) {
			int dir = sc.nextInt();
			len[i] = sc.nextInt();
			if (dir == 1 || dir == 2) {
				if (w < len[i]) {
					w = len[i];
					iw = i;
				}
			} else {
				if (h < len[i]) {
					h = len[i];
					ih = i;
				}
			}
		}
		int idx = 0;    // 작은 사각형 한 변의 인덱스
		if (iw == (ih+1)%6) idx = iw;   // 연속으로 긴 길이가 두번 나올 때 뒷 변의 인덱스 구하기
		else idx = ih;
		idx = (idx+2)%6; // 구해진 뒷 변 인덱스의 +2는 작은 사각형의 한 변 인덱스
		
		System.out.println((w*h - len[idx]*len[(idx+1)%6])*K);
		sc.close();
	}
}
