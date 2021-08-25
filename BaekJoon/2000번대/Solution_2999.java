import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BeakJoon 2999. 비밀 이메일
 * Date: 2021. 8. 25.
 * @author MIRAE
 */

public class Solution_2999 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] message = br.readLine().toCharArray();
		
		// 메시지 길이의 제곱근에 가까운 약수가 가장 큰 약수
		int R = 0, C = 0;
		for (int i = 1; i <= Math.sqrt(message.length); i++) {
			if (message.length % i == 0) {
				R = i;
				C = message.length / i;
			}
		}
		
		char[][] arr = new char[R][C];
		
		int n = 0;
		for (int j = 0; j < C; j++) {
			for (int i = 0; i < R; i++) {
				arr[i][j] = message[n++];
			}
		}
		
		n = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(arr[i][j]);
			}
		}
	}
}
