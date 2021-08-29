import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * SWEA 4789. 성공적인 공연 기획
 * Date: 2021. 8. 29.
 * @author MIRAE
 */

public class Solution_4789 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			int[] num = new int[str.length()];
			
			int clap = 0;   // 박수 친 사람 수
			int hire = 0;   // 고용한 사람 수
			for (int i = 0; i < str.length(); i++) {  // i => i 인덱스에 있는 사람이 박수를 치기위해 필요한 최소 인원
				num[i] = Integer.parseInt(Character.toString(str.charAt(i)));
				
				if (i == 0) {        // 아무도 박수를 치지 않아도 기립박수를 칠 인원 clap에 합산
					clap = num[0];
					continue;
				}
				
				if (clap < i) {     // 박수를 칠 사람 수가 최소인원인 i에 미달되면
					hire += i-clap; // 필요한 인원만큼 고용하고
					clap += i-clap; // 고용한 사람 수 박수 칠 인원에 추가
				}
				clap += num[i];     // 고용한 사람 포함하여 조건을 만족했다는 가정하에 박수칠 사람 합산
			}
			System.out.println("#" + tc + " " + hire);
		}
		
	}
}
