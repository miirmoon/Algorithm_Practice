package com.miirmoon.bj2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BeakJoon 2309. 일곱 난쟁이
 * Date: 2021. 8. 16.
 * @author MIRAE
 */

public class Solution_2309 {
	private static int[] dwarfs = new int[9];
	private static int[] selectSeven = new int[7];
	private static int[] sevenDwarfs;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 9명의 난쟁이 키 입력 받기
		for (int i = 0; i < 9; i++) {
			dwarfs[i] = Integer.parseInt(br.readLine());
		}
		// 7명의 난쟁이를 선택하는 조합으로 난쟁이 키를 확인하기
		pickSeven(0, 0);
		// 오름차순 정렬 후 결과 출력하기
		Arrays.sort(sevenDwarfs);
		for (int i = 0; i < 7; i++) {
			System.out.println(sevenDwarfs[i]);
		}
	}
	// 9명의 난쟁이 중 7명의 난쟁이를 선택하여 키의 합이 100인 난쟁이를 구하는 함수
	private static void pickSeven(int cnt, int start) {
		// 7명의 난쟁이를 선택했을 때
		if (cnt == 7) {
			// 키의 합을 구하기
			int sum = 0;
			for (int h = 0; h < 7; h++) {
				sum += selectSeven[h];
			}
			if (sum == 100) sevenDwarfs = selectSeven.clone();
			return;
		}
		for (int i = start; i < 9; i++) {
			selectSeven[cnt] = dwarfs[i];
			pickSeven(cnt+1, i+1);
		}
	}
}
