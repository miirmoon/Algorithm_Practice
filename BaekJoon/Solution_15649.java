package com.miirmoon.bj15000;

import java.util.Scanner;

/**
 * BaekJoon 15649. N과 M(1)
 * Date: 2021. 8. 4.
 * Solution: 재귀함수 이용한 순열 연습하기
 * @author MIRAE
 */

public class Solution_15649 {
	private static int[] arr;
	private static int[] numbers;
	private static boolean[] isSelected;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		arr = new int[N];             // 1 ~ N까지의 수를 담고 있는 배열
		numbers = new int[M];         // arr에서 뽑은 M개의 수를 담을 배열
		isSelected = new boolean[N];  // 뽑았던 수인지 확인하는 배열
		
		for (int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		permutation(0, M);
		sc.close();
	}
	private static void permutation(int cnt, int M) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		
		// 1부터 N까지의 모든 경우의 수를 고려함
		for (int i = 0; i < arr.length; i++) {
			if (isSelected[i]) continue;
			
			numbers[cnt] = arr[i];
			isSelected[i] = true;
			
			permutation(cnt+1, M);
			isSelected[i] = false;
		}
	}
}
