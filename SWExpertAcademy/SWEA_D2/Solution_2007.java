import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * SWEA 2007. 패턴 마디의 길이
 * Date: 2021. 8. 29.
 * @author MIRAE
 */

public class Solution_2007 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			StringBuffer sb = new StringBuffer();
			
			sb.append(str.charAt(0));
			for (int i = 1; i <= 10; i++) { // 마디의 최대 길이는 10이므로 10까지만 검사
				if (str.substring(i, i*2).contains(sb))	break;  // i인덱스부터 i길이 만큼을 현재까지의 마디 후보(sb)와 비교했을 때 같으면 중단
				
				sb.append(str.charAt(i));
			}
			System.out.println("#" + tc + " " + sb.length());
		}
	}
}
