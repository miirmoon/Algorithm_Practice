package swea_D3;

import java.util.Scanner;

/**
 * SWEA 1289. 원재의 메모리 복구하기
 * Date: 2021. 8. 2.
 * Solution: 전제조건이 지정된 위치부터 뒤에 따라오는 비트가 동일하게 채워진다는 것이므로 모든 비트가 0으로 초기화된 상태에서 
 * 			원래 코드로 복구하기 위해서 처음부터 뒤까지 0과 1이 서로 달라지는 부분을 카운트한다. 
 * @author MIRAE
 */

public class Solution_1289 {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc = 1; tc <= T; tc++)
		{
			char[] memory = sc.next().toCharArray();
			int count = 0;
			
			if (memory[0] == '1') count++;   // 처음 시작 비트가 1인 경우 0 -> 1로 변경되는 것이므로 1 카운트 증가한다.
			
			for (int i = 0; i < memory.length-1; i++) {  // 현재 비트와 다음 비트를 비교해서 서로 다르면 1카운트 증가한다.
				if (memory[i] != memory[i+1]) {  
					count++;
				}
			}
					
			System.out.println("#" + tc + " " + count);
		}
		sc.close();
	}
}
