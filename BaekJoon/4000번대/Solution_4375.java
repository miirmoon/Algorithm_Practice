import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BaekJoon 4375. 1
 * Date: 2021. 12. 7.
 * @author MIRAE
 */

public class Solution_4375 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp;		
		
		while ((tmp = br.readLine()) != null) {
			int n = Integer.parseInt(tmp);
			int num = 1;
			int count = 1;
			
			while (true) {
				if (num % n == 0) break;
				num = (num * 10 + 1) % n;
				count++;
			}
			System.out.println(count);
		}
	}
}
