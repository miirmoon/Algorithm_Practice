package com.miirmoon.swea.d2;

import java.util.Scanner;

/**
 * SWEA 2001. 파리 퇴치
 * Date: 2021. 8. 4.
 * Solution: N X N 크기 배열 내에서 (0, 0)부터 시작하여 M X M 크기의 경우의 수를 전부 구해보기
 * @author MIRAE
 */

public class Solution_2001 {
	private static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N, M, max, sum;
		
		for (int tc = 1; tc <= T; tc++) {
			max = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N][N];
			
			// 배열안에 파리의 수 입력하기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			// (0, 0)부터 (N-M, N-M)까지 M X M크기의 경우의 수를 전부 구해서 비교하기
			for (int i = 0; i <= N-M; i++) {
				for (int j = 0; j <= N-M; j++) {
					sum = 0;
					for (int a = i; a < i+M; a++) {
						for (int b = j; b < j+M; b++) {
							sum += arr[a][b];
						}
					}
					if (max < sum) max = sum;
				}
			}
			System.out.println("#" + tc + " " + max);
		}
		sc.close();
	}
}
