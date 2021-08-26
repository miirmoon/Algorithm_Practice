import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BaekJoon 8958. OX퀴즈
 * Date: 2021. 8. 26. 
 * @author MIRAE
 */

public class Solution_8958 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			char[] arr = br.readLine().toCharArray();
			
			int score = 0;
			int cnt = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 'O') score += ++cnt;
				else cnt = 0;
			}
			
			System.out.println(score);
		}
	}
}
