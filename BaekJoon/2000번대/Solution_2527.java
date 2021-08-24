import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BeakJoon 2527. 직사각형
 * Date: 2021. 8. 24.
 * @author MIRAE
 */

public class Solution_2527 {
	static class Rectangle {
		int x, y, p, q;
		Rectangle(int x, int y, int p, int q) {
			this.x = x;
			this.y = y;
			this.p = p;
			this.q = q;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			Rectangle A = new Rectangle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Rectangle B = new Rectangle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			// 명확하게 구분할 수 있는 것 순서대로 검사(점 -> 공통부분 없음 -> 선분 -> 직사각형)
			char result = 'a';
			if (checkC(A, B)) result = 'c';
			else if (checkD(A, B)) result = 'd';
			else if (checkB(A, B)) result = 'b';
			
			System.out.println(result);
		}
	}
	// 선분을 공통 부분으로 가지는지 검사
	private static boolean checkB(Rectangle A, Rectangle B) {
		if (A.p == B.x && A.q != B.y) return true;
		if (A.y == B.q && A.x != B.p) return true;
		if (A.x == B.p && A.y != B.q) return true;
		if (A.q == B.y && A.p != B.x) return true;
		return false;
	}
	// 점을 공통 부분으로 가지는지 검사
	private static boolean checkC(Rectangle A, Rectangle B) {
		if (A.x == B.p && A.y == B.q) return true;
		if (A.p == B.x && A.q == B.y) return true;
		if (A.p == B.x && A.y == B.q) return true;
		if (A.x == B.p && A.q == B.y) return true;
		return false;
	}
	// 공통부분이 없는지 검사
	private static boolean checkD(Rectangle A, Rectangle B) {
		if (A.x > B.p || A.p < B.x || A.y > B.q || A.q < B.y) return true;
		return false;
	}
}
