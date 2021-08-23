import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BaekJoon 1759. 암호 만들기
 * Date: 2021. 8. 23. 
 * @author MIRAE
 */

public class Solution_1759 {
	private static int L, C;
	private static String[] strArr, select;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp = br.readLine().split(" ");
		L = Integer.parseInt(tmp[0]);   // 암호 길이
		C = Integer.parseInt(tmp[1]);   // 암호가 될 수 있는 문자 수
		
		strArr = br.readLine().split(" ");  // 암호가 될 수 있는 C개의 문자
		select = new String[L];             // 암호로 선택된 문자를 저장할 배열
		
		Arrays.sort(strArr);                // 정렬된 상태로 조합을 만들기 위함
		
		comb(0, 0);
	}
	
	private static void comb(int cnt, int start) {
		if (cnt == L) {
			int count = 0;
			for (int i = 0; i < L; i++) {           // 모음의 개수 확인
				if ("aeiou".contains(select[i])) count++;
			}
			if (count >= 1 && L-count >= 2) {      // 모음이 1개 이상이고 자음이 2개 이상일 때
				for (int i = 0; i < L; i++) {      // 선택된 문자 출력
					System.out.print(select[i]);
				}
				System.out.println();
			}
			return;
		}
		for (int i = start; i < C; i++) {
			select[cnt] = strArr[i];
			comb(cnt+1, i+1);
		}
	}
}
