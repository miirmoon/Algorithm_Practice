import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BeakJoon 17471. 게리맨더링
 * Date: 2021. 10. 6.
 * @author MIRAE
 */

public class Solution_17471 {
	private static int N, minSub = Integer.MAX_VALUE;
	private static int[] popul;
	private static ArrayList<Integer>[] region;
	private static LinkedList<Integer> electionA, electionB;
	private static boolean[] selected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		popul = new int[N+1];             // 각 구역의 인구 수
		region = new ArrayList[N+1];      // 구역별 인접 정보
		electionA = new LinkedList<>();   // A 선거구로 들어갈 구역
		electionB = new LinkedList<>();   // B 선거구로 들어갈 구역
		selected = new boolean[N+1];      // 선거구를 나눌 때 선택 여부를 확인하는 배열
		
		// 각 구역의 인구 수 입력 받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			popul[i] = Integer.parseInt(st.nextToken());
		}
		
		// 구역별 인접 정보 입력 받기
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			region[i] = new ArrayList<>();
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				region[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		divide(1);
		System.out.println(minSub == Integer.MAX_VALUE ? -1 : minSub);
	}
	/**
	 * 선거구를 나누고, 나누어진 선거구 내에서 각 구역이 연결되어있는지 isLinked 함수를 이용해서 확인,
	 * 두 선거구가 각각 잘 연결되어 있는 경우 인구 수의 차를 계산하여 최소값을 minSub에 저장
	 * - 부분집합을 이용하되, {A+B}는 {N}이므로 중간지점부터(1이 선택되지 않은 집합)는 중복됨에 따라 계산하지 않음 
	 * @param cnt: 선택 여부를 결정한 개수, N+1이 되면 모든 수에 대해 선택 여부를 결정한 상태임
	 */
	private static void divide(int cnt) {
		
		if (cnt == N+1) {
			if (!selected[1]) return;  // 1이 선택되지 않은 경우부터는 중복된 경우이므로 바로 리턴
			
			int sumA = 0, sumB = 0;
			for (int i = 1; i <= N; i++) {
				if (selected[i]) {      // 선택값이 true인 경우 A 선거구에 배치
					electionA.add(i);
					sumA += popul[i];   // A 선거구의 인구 합산
				} else {                // 선택값이 false인 경우 B 선거구에 배치
					electionB.add(i);   
					sumB += popul[i];   // B 선거구의 인구 합산
				}
			}
			if (isLinked(electionA) && isLinked(electionB))     // 선거구 내의 구역들이 서로 연결된 상태일 경우
				minSub = Math.min(minSub, Math.abs(sumA-sumB)); // 인구 수의 차를 계산하여 최소값을 저장함  
			
			electionA.clear();   // 선거구 계산이 끝났으므로 다음 계산을 위해 비워주기
			electionB.clear();
			return;
		}
		
		selected[cnt] = true;
		divide(cnt+1);
		
		selected[cnt] = false;
		divide(cnt+1);
	}
	/**
	 * 선거구 내의 구역들이 연결되어있는지 확인(BFS 이용)
	 * @param list: 연결여부를 확인할 선거구 리스트를 입력받음
	 * @return 선거구 내 모든 구역이 연결되어 있으면 true, 아닐 경우 false 리턴
	 */
	private static boolean isLinked(LinkedList<Integer> list) {
		if (list.size() == 0) return false;   // 각 선거구는 적어도 하나의 구역을 포함해야 하므로 false
		if (list.size() == 1) return true;    // 구역이 하나이면 연결된 상태로 볼 수 있으므로 true
		
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		q.offer(list.get(0));
		visited[list.get(0)] = true;
		int cnt = 1;                         // 연결된 구역 개수 카운트(list내 0번 구역부터 시작하므로 1로 초기화)
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			int size = region[cur].size();
			
			for (int i = 0; i < size; i++) {
				int n = region[cur].get(i);
				
				if (visited[n]) continue;     // 이미 방문한 구역일 경우 pass
				
				if (list.contains(n)) {       // 선거구에 포함된 지역일 때
					q.offer(n);
					visited[n] = true;
					cnt++;
				} else {                      // 선거구에 포함되지 않은 지역일 때
					visited[n] = true;
				}
			}
		}
		// BFS를 통해 방문한 구역 수와 선거구 내 구역 수가 일치하면 서로 연결된 것으로 봄
		if (cnt == list.size()) return true;  
		
		return false;
	}
	
	
}
