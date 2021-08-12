package com.miirmoon.bj3000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BeakJoon 3040. 백설 공주와 일곱 난쟁이
 * Date: 2021. 8. 12.
 * Solution: 반복문 이용하기
 * 		- 반복문을 이용할 경우 뽑는 수 만큼 반복문을 돌려야하기 때문에 2명을 뽑아 합을 빼주는 방식으로 반복 횟수를 줄일 수 있다.
 * @author MIRAE
 */

public class Solution_3040_loof {
	private static int[] dwarfsNine, realSeven;
	
	// 메인함수
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dwarfsNine = new int[9];  // 아홉 난쟁이 번호를 입력받을 배열
		int sum = 0;              // 아홉 난쟁이의 합
		
		for (int i = 0; i < 9; i++) {
			dwarfsNine[i] = Integer.parseInt(br.readLine());
			sum += dwarfsNine[i];
		}
		// 아홉 난쟁이 중 2명의 난쟁이 뽑기(일곱난쟁이가 아닌 난쟁이)
		// - 두 난쟁이를 제외한 일곱 난쟁이의 합으로 진위여부 확인
		int a=0, b=0;
		outer: for (a = 0; a < 9; a++) {
			for (b = a+1; b < 9; b++) {
				// 전체 합에서 a난쟁이와 b난쟁이를 뺐을 때 100이면 a와 b가 가짜 난쟁이이므로 확인 중단
				if (sum-(dwarfsNine[a]+dwarfsNine[b]) == 100) break outer;
			}
		}
		// 가짜 난쟁이인 a와 b를 제외하고 출력
		for (int i = 0; i < 9; i++) {
			if (i == a | i == b) continue;
			System.out.println(dwarfsNine[i]);
		}
	}
}