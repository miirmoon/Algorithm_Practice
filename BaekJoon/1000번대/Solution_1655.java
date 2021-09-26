import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * BaekJoon 1655. 가운데를 말해요
 * Date: 2021. 9. 26.
 * Solution: 우선순위큐
 * @author MIRAE
 */

public class Solution_1655 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());  // 최대힙
		PriorityQueue<Integer> minQ = new PriorityQueue<>();	                       // 최소힙
		
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if (maxQ.size() <= minQ.size()) maxQ.offer(n);  // 최대 힙에 우선적으로 넣음
			else minQ.offer(n);                             // 2개 힙의 데이터 수를 동일하게 맞춤
			
			// 최대 힙의 최댓값과 최소 힙의 최솟값을 비교하여 최대힙 < 최소힙이 되도록 정렬(최대힙의 최댓값이 항상 중간값)
			if (!minQ.isEmpty() && maxQ.peek() > minQ.peek()) {   
				maxQ.offer(minQ.poll());
				minQ.offer(maxQ.poll());
			}
			bw.write(maxQ.peek() + "\n");
		}
		bw.close();
		br.close();
	}
}