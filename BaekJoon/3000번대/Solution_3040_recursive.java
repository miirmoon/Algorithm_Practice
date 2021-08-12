package com.miirmoon.bj3000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BeakJoon 3040. 백설 공주와 일곱 난쟁이
 * Date: 2021. 8. 12.
 * Solution: 재귀함수 이용하기
 * @author MIRAE
 */

public class Solution_3040_recursive {
	private static int[] dwarfsNine, dwarfsSeven, realSeven;
	
	// 메인함수
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dwarfsNine = new int[9];  // 아홉 난쟁이 번호를 입력받을 배열
		dwarfsSeven = new int[7]; // 아홉 난쟁이 중 일곱명을 뽑은 조합을 저장할 배열
		realSeven = new int[7];   // 진짜 일곱 난쟁이를 저장할 배열
		
		for (int i = 0; i < 9; i++) {
			dwarfsNine[i] = Integer.parseInt(br.readLine());
		}
		
		isRealSeven(0, 0);
		for (int i = 0; i < 7; i++) {
			System.out.println(realSeven[i]);
		}
	}
	// 아홉 난쟁이 중 일곱명의 난쟁이를 뽑아 진위여부를 확인하기(재귀 이용)
	private static void isRealSeven(int cnt, int start) {
		if (cnt == 7) {
			int sum = 0;
			// 난쟁이 진위여부 확인하기(7명의 번호를 더했을 때 100이 되는지 여부)
			for (int i = 0; i < 7; i++) {
				sum += dwarfsSeven[i];
			}
			if (sum == 100)	realSeven = dwarfsSeven.clone();
			return;
		}
		// 7명의 난쟁이 뽑기
		for (int i = start; i < 9; i++) {
			dwarfsSeven[cnt] = dwarfsNine[i];
			isRealSeven(cnt+1, i+1);
		}
	}
}
