import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * SWEA 4047. 영준이의 카드 카운팅
 * Date: 2021. 8. 28.
 * @author MIRAE
 */

public class Solution_4047 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		outer: for(int tc = 1; tc <= T; tc++) {
			boolean[][] card = new boolean[4][14];
			char[] str = br.readLine().toCharArray();
			int s = 13, d = 13, h = 13, c = 13;   // 각 카드가 있어야할 개수
			
			// S(0), D(1), H(2), C(3)
			int ix;
			for (int i = 0; i < str.length; i+=3) {
				switch(str[i]) {   // 해당 모양의 카드가 있으면 -1
				case 'S': ix = 0; s--; break;
				case 'D': ix = 1; d--; break;
				case 'H': ix = 2; h--;break;
				default: ix = 3; c--;
				}
				
				int iy = (str[i+1]-'0') * 10 + (str[i+2]-'0');  // 카드 번호를 정수로 변경
				
				if (card[ix][iy] == true) {   // 이미 있는 카드이면 에러 출력 후 다음 케이스로 넘어감
					System.out.println("#" + tc + " ERROR");
					continue outer;
				}
				card[ix][iy] = true;				
			}
			System.out.printf("#%d %d %d %d %d", tc, s, d, h, c);
			System.out.println();
		}
	}
}
