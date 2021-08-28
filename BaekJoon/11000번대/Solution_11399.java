import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BeakJoon 11399. ATM
 * Date: 2021. 8. 28.
 * @author MIRAE
 */

public class Solution_11399 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] time = new int[N];
		int sum = 0, res = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time);    // 앞에 줄 선 사람의 시간이 뒤에 줄 선 사람의 시간에 영향을 주므로 짧은 시간부터 정렬
		
		for (int i = 0; i < N; i++) {
			res += sum+time[i];  // i-1번까지의 시간 합 + i번 사람의 시간
			sum += time[i];      // i번까지의 시간 합(i+1번 사람의 총 시간을 구하기 위함)
		}
		
		System.out.println(res);
	}
}
