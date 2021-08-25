import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BeakJoon 2810. 컵홀더
 * Date: 2021. 8. 25.
 * @author MIRAE
 */

public class Solution_2810 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		char[] seat = br.readLine().toCharArray();
		
		boolean first = false;
		int count = 0;
		int couple = 0;
		
		for (int i = 0; i < N; i++) {
			// 자리가 S일 때
			if (seat[i] == 'S') {
				count++;
				continue;
			}
			// 자리가 L일 때
			// 커플석을 처음 만나면 카운트
			if (!first) {
				count++;
				couple++;
				first = true;
				continue;
			}
			// 커플석을 두번째 이상 만나면 2좌석당 하나 카운트
			if (couple == 1 && seat[i-1] == 'L') {
				count++;
				couple = 0;
				continue;
			}
			couple++;
		}
		
		System.out.println(count);
	}
}
