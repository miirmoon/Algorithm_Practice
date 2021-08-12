package com.miirmoon.bj3000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BeakJoon 3040. 백설 공주와 일곱 난쟁이
 * Date: 2021. 8. 12.
 * Solution: nextPermutation 이용하기
 * @author MIRAE
 */

public class Solution_3040_nextPermutation {
	private static int[] dwarfsNine, pick;
	
	// 메인함수
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dwarfsNine = new int[9];  // 아홉 난쟁이 번호를 입력받을 배열
		pick = new int[9]; // 아홉 난쟁이 중 일곱명을 뽑은 조합을 저장할 배열
		
		for (int i = 0; i < 9; i++) {
			dwarfsNine[i] = Integer.parseInt(br.readLine());
		}
		// 뒤쪽부터 7개만큼 1로 채우기
		for (int i = 1; i <= 7; i++) {
			pick[9-i] = 1;
		}
		// 아홉 난쟁이 중 일곱명의 난쟁이를 뽑아 합 구하기		
		do {
			int sum = 0;
			for (int i = 0; i < 9; i++) {
				if (pick[i] == 0) continue;
				sum += dwarfsNine[i];
			}
			if (sum == 100) break;
		} while(pickSeven(pick));
		
		for (int i = 0; i < 9; i++) {
			if (pick[i] == 0) continue;
			System.out.println(dwarfsNine[i]);
		}
	}
	// 아홉 난쟁이 중 일곱명의 난쟁이를 뽑기(NextPermutation 이용)
	private static boolean pickSeven(int[] arr) {
		int N = arr.length;
		
		// 꼭대기 찾기
		int i = N-1;
		while (i > 0 && arr[i-1] >= arr[i]) i--;
		
		if (i == 0) return false;
		
		// i-1 위치의 값과 교환할 값 찾기
		int j = N-1;
		while (arr[i-1] >= arr[j]) j--;
		
		// i-1 위치의 값과 j 위치의 값 교환
		swap(arr, i-1, j);
		
		// 꼭대기부터 맨 뒤까지의 내림차순 형태를 오름차순으로 변경
		int k = N-1;
		while(i < k) swap(arr, i++, k--);
		
		return true;
	}
	// 위치를 서로 교환하기
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
