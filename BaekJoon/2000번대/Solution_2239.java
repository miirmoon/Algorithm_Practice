import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * BeakJoon 2239. 스도쿠
 * Date: 2021. 10. 11.
 * @author MIRAE
 */

public class Solution_2239 {
	
	private static ArrayList<int[]> zero;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] sdoku = new int[9][9];
		zero = new ArrayList<>();
		
		for (int i = 0; i < 9; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				sdoku[i][j] = tmp[j]-'0';
				if (sdoku[i][j] == 0) zero.add(new int[] {i, j});  // 아직 숫자가 채워지지 않은 칸 정보 저장
			}
		}
		
		game(0, sdoku);    // zero 리스트의 0번 인덱스부터 숫자를 채워나감
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(sdoku[i][j]);
			}
			System.out.println();
		}
	}
	
	private static boolean game(int idx, int[][] arr) {
		if (idx == zero.size()) return true;    // zero리스트 끝까지 숫자 채우기를 완료하면 true
		
		int x = zero.get(idx)[0];
		int y = zero.get(idx)[1];
		boolean isCompleted = false;
		
		for (int i = 1; i <= 9; i++) {
			if (check(x, y, i, arr)) {    // 행, 열, 3X3에 겹치는 숫자가 없을 때
				arr[x][y] = i;            // 해당 위치에 해당 숫자를 채움
				if (isCompleted = game(idx+1, arr)) break;  // 숫자채우기가 완료된 상태라면 더이상 검사할 필요 없음(모든 재귀 종료)
				else continue;
			}
		}
		if (!isCompleted) arr[x][y] = 0;  // 다음 0에서 채워지지 않았다면 다음 숫자로 채워보기 위해 현재 칸은 0으로 되돌림
		
		return isCompleted;
	}

	private static boolean check(int x, int y, int d, int[][] arr) {
		int[] idx = {0, 3, 6};
		
		for (int i = 0; i < 9; i++) {
			if (arr[x][i] == d) return false; // 행 검사
			if (arr[i][y] == d) return false; // 열 검사
		}
		
		int sx = idx[x/3];
		int sy = idx[y/3];
		
		// 3 X 3 검사
		for (int i = sx; i < sx + 3; i++) {
			for (int j = sy; j < sy + 3; j++) {
				if (arr[i][j] == d) return false; 
			}
		}
		
		return true;
	}
}
