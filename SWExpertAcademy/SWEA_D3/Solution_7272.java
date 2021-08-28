import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * SWEA 7272. 안경이 없어!
 * Date: 2021. 8. 28.
 * @author MIRAE
 */

public class Solution_7272 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] alpabet = {"CEFGHIJKLMNSTUVWXYZ", "ADOPQR", "B"};
		
		for (int tc = 1; tc <= T; tc++) {
			String[] str = br.readLine().split(" ");
			if (str[0].length() != str[1].length()) {  // 길이가 다르면 바로 결과 출력
				System.out.println("#" + tc + " DIFF");
				continue;
			}
			
			String res = "SAME";
			outer: for (int i = 0; i < str[0].length(); i++) {
				for (int a = 0; a < 3; a++) {  // 각 알파벳 그룹에 포함 여부가 다르면 다른 글씨로 인식		
					if (alpabet[a].contains(Character.toString(str[0].charAt(i))) != alpabet[a].contains(Character.toString(str[1].charAt(i)))) {
						res = "DIFF";
						break outer;
					}
				}
			}
			System.out.println("#" + tc + " " + res);
		}
	}
}
