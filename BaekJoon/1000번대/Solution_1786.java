import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * BaekJoon 1786. 찾기
 * Date: 2021. 9. 23.
 * Solution: KMP 알고리즘(Knuth-Morris-Pratt Algorithm)
 * @author MIRAE
 */

public class Solution_1786 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] T = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();
		
		int tLen = T.length;
		int pLen = P.length;
		
		// 부분 일치 테이블 만들기
		int[] pi = new int[pLen];
		for (int i = 1, j = 0; i < pLen; i++) {
			while (j > 0 && P[i] != P[j]) j = pi[j-1];
			
			if (P[i] == P[j]) pi[i] = ++j;
		}
		
		// T에서 P와 일치하는 문자열 찾기
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0, j = 0; i < tLen; i++) {
			while (j > 0 && T[i] != P[j]) j = pi[j-1];
			
			if (T[i] == P[j]) {
				if (j == pLen-1) {   // j가 P의 마지막 인덱스일 때
					list.add(i - pLen + 1);
					j = pi[j];
				} else {
					j++;
				}
			}
		}
		
		System.out.println(list.size());
		for (int n: list) {
			System.out.print((n+1) + " ");
		}
	}
}
