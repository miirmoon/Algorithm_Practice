import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * SWEA 7087. 문제 제목 붙이기
 * Date: 2021. 8. 29.
 * @author MIRAE
 */

public class Solution_7087 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] str = new String[N];
			
			for (int n = 0; n < N; n++) {
				str[n] = br.readLine();
			}
			
			Arrays.sort(str);    // 알파벳 순서대로 정렬 후 검사
			
			char alph = 'A';
			int res = 0;
			for (int i = 0; i < N; i++) {
				if (i == 0) {    
					if (str[i].charAt(0) == alph) res++; // 첫 번째 제목의 맨 앞이 A이면 +1
					else break;   // A가 아니면 중단
				}
				
				if (str[i].charAt(0) == alph) continue;
				if (str[i].charAt(0) == ++alph) res++;   // 알파벳 다음 순서와 같으면 +1
				else break;    // 다음 순서와 같지 않으면 중단

			}
			System.out.println("#" + tc + " " + res);
		}
	}
}
