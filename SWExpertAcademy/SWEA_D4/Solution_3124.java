import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * SWEA 3124. 최소 스패닝 트리
 * Date: 2021. 9. 15.
 * @author MIRAE
 */

public class Solution_3124 {
	static class Edge implements Comparable<Edge> {
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {  // 가중치 기준으로 정렬하도록 재정의
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	private static int[] parents;  // 트리처럼 사용하기 위해 부모 원소 관리
	private static int V, E;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			Edge[] edgeList = new Edge[E];
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				edgeList[i] = new Edge(a, b, c);
			}
			
			Arrays.sort(edgeList);    // 가중치 기준으로 정렬하기
			
			make();
			
			int cnt = 0;
			long resWeight = 0;
			for (Edge e: edgeList) {
				if (union(e.start, e.end)) {
					resWeight += e.weight;
					if (++cnt == V-1) break;
				}
			}
			System.out.println("#" + tc + " " + resWeight);
		}
	}
	
	/**
	 * 모든 원소에 대하여 자기 자신을 대표자로 지정하기(Union-Find)
	 */
	private static void make() {
		parents = new int[V+1];   // 정점 개수를 크기로 하는 배열 생성
		
		for (int i = 0; i <= V; i++) {
			parents[i] = i;
		}
	}
	
	/**
	 * a가 속한 집합의 대표자 찾기(Union-Find)
	 */
	private static int find(int a) {
		if (a == parents[a]) return a;        // 자기 자신이 대표자일 때
		return parents[a] = find(parents[a]); // 자신이 속한 집합의 대표자를 자신의 부모로 지정
	}
	
	/**
	 * 두 개의 집합을 하나로 합치기(Union-find)
	 */
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
}
