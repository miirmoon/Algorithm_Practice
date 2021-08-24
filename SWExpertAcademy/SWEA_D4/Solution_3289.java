import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA 3289. 서로소 집합
 * Date: 2021. 8. 24.
 * @author MIRAE
 */

public class Solution_3289 {
	private static int n, m;
	private static int[] parents;
	
	// {1}, {2}, ... {n}개의 집합 만들기
	private static void makeSet() {
		parents = new int[n+1];
		
		for (int i = 1; i < n+1; i++) {
			parents[i] = i;
		}
	}
	
	// a가 속한 집합의 대표자 찾기
	private static int find(int a) {
		if (a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	// a가 속한 집합과 b가 속한 집합 합치기
	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return;  // a의 대표자와 b의 대표자가 같으면 이미 하나의 집합이므로 중단
		
		parents[bRoot] = aRoot;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());    // 집합이 만들어지는 최대 수
			m = Integer.parseInt(st.nextToken());    // 연산의 개수
			makeSet();  // 1부터 n까지 n개의 집합 만들기
			
			System.out.print("#" + tc + " ");
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int command = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if (command == 0) union(a, b);    // 합집합 연산
				else System.out.print(find(a) == find(b) ? 1 : 0);  // 두 원소가 같은 집합에 포함되어있으면 1, 아니면 0 출력
			}
			System.out.println();
		}
	}
}