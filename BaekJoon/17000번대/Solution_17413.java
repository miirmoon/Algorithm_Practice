import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BaekJoon 17413. 단어 뒤집기2
 * Date: 2021. 8. 26. 
 * @author MIRAE
 */

public class Solution_17413 {
	static char[] str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine().toCharArray();
		
		StringBuffer sb = new StringBuffer();
		int start = 0;
		int end = 0;
		boolean tag = false;  // 태그 안의 내용은 그대로 두기 위함
		
		// 단어의 시작 인덱스(start)와 끝 인덱스(end)를 구하여 reverse 함수 실행
		for (int i = 0; i < str.length; i++) {
			if (str[i] == '>') {
				sb.append(">");
				start = i+1;
				tag = false;
				continue;
			}
			if (str[i] == '<') {
				if (i != 0) {
					end = i-1;
					sb.append(reverse(start, end));
				}
				sb.append("<");
				tag = true;
				continue;
			}
			if (tag) {
				sb.append(str[i]);
				continue;
			}
			if (str[i] == ' ') {
				end = i-1;
				sb.append(reverse(start, end));
				sb.append(" ");
				start = i+1;
				continue;
			}
			if (i == str.length-1) {
				end = i;
				sb.append(reverse(start, end));
			}
		}
		System.out.println(sb.toString());
	}
	// s 인덱스부터 e 인덱스까지의 문자를 뒤집어 반환
	static String reverse(int s, int e) {
		StringBuffer sb = new StringBuffer();
		
		for (int i = e; i >= s; i--) {
			sb.append(str[i]);
		}
		return sb.toString();
	}
}
