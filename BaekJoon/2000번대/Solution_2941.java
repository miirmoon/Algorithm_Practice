import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BeakJoon 2941. 크로아티아 알파벳
 * Date: 2021. 8. 25.
 * @author MIRAE
 */

public class Solution_2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] word = br.readLine().toCharArray();
		
		int count = word.length;
		for (int i = word.length-1; i >= 0; i--) {
			if (word[i] == '-') {
				if (word[i-1] == 'c' || word[i-1] == 'd') count--;
				continue;
			}
			if (i >= 1 && word[i] == 'j') {
				if (word[i-1] == 'l' || word[i-1] == 'n') count--;
				continue;
			}
			if (word[i] == '=') {
				if (i >= 2 && word[i-1] == 'z' && word[i-2] == 'd') count -= 2;
				else if ("csz".contains(Character.toString(word[i-1]))) count--;
			}
		}
		
		System.out.println(count);
	}
}
