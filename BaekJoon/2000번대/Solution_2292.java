import java.util.Scanner;

/**
 * BeakJoon 2292. 벌집
 * Date: 2021. 8. 24.
 * @author MIRAE
 */

public class Solution_2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int end = 1;
		int count = 1;
		while (true) {
			if (N <= end) break;
			
			end += count*6;   // 1, 7, 19, 37, 61 ... 다음 줄로 넘어갈 때 6의 배수씩 증가함
			count++;
		}
		System.out.println(count);
		sc.close();
	}
}
