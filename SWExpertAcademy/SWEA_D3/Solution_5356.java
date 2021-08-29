import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * SWEA 5356. 의석이의 세로로 말해요
 * Date: 2021. 8. 29.
 * @author MIRAE
 */

public class Solution_5356 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String[] str = new String[5];
			int len = 0;
			for (int i = 0; i < 5; i++) {
				str[i] = br.readLine();
				len = Math.max(len, str[i].length());  // 5개의 문자열 중 최대 길이 구하기
			}
			
			System.out.print("#" + tc + " ");
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < 5; j++) {
					if (i >= str[j].length()) continue;   // 문자열의 마지막까지 출력한 경우 pass
					System.out.print(str[j].charAt(i));
				}
			}
			System.out.println();
		}
	
	}
}
