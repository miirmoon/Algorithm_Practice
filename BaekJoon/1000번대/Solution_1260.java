import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * BaekJoon 1260. DFS와 BFS
 * Date: 2021. 8. 23. 
 * @author MIRAE
 */

public class Solution_1260 {
	private static int N;
	private static ArrayList<Integer> resDFS, resBFS;
	private static int[][] gragh;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();      // 정점의 개수
		int M = sc.nextInt();  // 간선의 개수
		int V = sc.nextInt();  // 탐색을 시작할 정점 번호
		
		gragh = new int[N+1][N+1];
		boolean[] visited = new boolean[N+1];
		resDFS = new ArrayList<Integer>();
		resBFS = new ArrayList<Integer>();
		
		int a, b;
		for (int i = 0; i < M; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			gragh[a][b] = 1;
			gragh[b][a] = 1;
		}
		
		// DFS 수행 및 결과 출력
		dfs(V, visited);
		for (int n: resDFS) {
			System.out.print(n + " ");
		}
		System.out.println();
		// BFS 수행 및 결과 출력
		bfs(V);
		for (int n: resBFS) {
			System.out.print(n + " ");
		}
		sc.close();
	}
	// DFS 탐색
	public static void dfs(int cur, boolean[] visited) {
		visited[cur] = true;
		resDFS.add(cur);
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && gragh[cur][i] == 1) {
				dfs(i, visited);
			}
		}
	}
	// BFS 탐색
	public static void bfs(int V) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		
		queue.offer(V);
		visited[V] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			resBFS.add(cur);
			
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && gragh[cur][i] == 1) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}
