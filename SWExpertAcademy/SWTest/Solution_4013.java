import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * SWEA 4013. 특이한 자석
 * Date: 2021. 9. 30.
 * @author MIRAE
 */

public class Solution_4013 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());
			StringTokenizer st = null;
			
			List<Integer>[] magnet = new LinkedList[5];
			for (int i = 1; i <= 4; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				magnet[i] = new LinkedList<>();
				for (int j = 0; j < 8; j++) {
					magnet[i].add(Integer.parseInt(st.nextToken()));
				}
			}
			
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine(), " ");
				int mgNum = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				boolean[] compare = new boolean[] {magnet[1].get(2) == magnet[2].get(6), magnet[2].get(2) == magnet[3].get(6), magnet[3].get(2) == magnet[4].get(6)};
				
				// mgNum과 번호가 같거나 큰 자석
				int num = mgNum;
				int d = dir;
				while (num <= 4) {
					magnet[num] = rotate(magnet[num], d);   // d 방향으로 자석 회전
					if (num >= 4 || compare[num-1]) break;  // 오른쪽 번호의 자석과 붙어있는 날의 자성이 같은 경우 중단
					num++;
					d *= -1;
				}
				
				// mgNum보다 번호가 작은 자석
				num = mgNum;
				d = dir;
				while (num > 0) {
					if (num <= 1 || compare[num-2]) break;  // 왼쪽 번호의 자석과 붙어있는 날의 자성이 같은 경우 중단
					num--;
					d *= -1;
					magnet[num] = rotate(magnet[num], d);   // d 방향으로 좌석 회전
				}
			}
			
			// 점수 계산
			int ans = 0;
			for (int i = 1; i <= 4; i++) {
				if (magnet[i].get(0) == 1) {
					ans += Math.pow(2, i-1);
				}
			}			
			System.out.println("#" + tc + " " + ans);
		}	
	}

	private static List<Integer> rotate(List<Integer> list, int d) {
		if (d == 1) {    // 자석을 시계방향으로 회전
			list.add(0, list.remove(list.size()-1));
		}
		else {           // 자석을 반시계방향으로 회전
			list.add(list.remove(0));
		}
		return list;
	}
}
