import java.util.Scanner;

/**
 * BeakJoon 2851. 슈퍼마리오
 * Date: 2021. 8. 25.
 * @author MIRAE
 */

public class Solution_2851 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sub = 100;
		int score = 0;
		int mushroom = 0;
		for (int i = 0; i < 10; i++) {
			mushroom += sc.nextInt();
			
			if (Math.abs(mushroom - 100) <= sub) {
				sub = Math.abs(mushroom - 100);
				score = mushroom;
				continue;
			}
			break;
		}
		System.out.println(score);
		sc.close();
	}
}
