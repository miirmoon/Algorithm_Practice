package com.miirmoon.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * SWEA 5215. 햄버거 다이어트
 * Date: 2021. 8. 9.
 * Solution: 1~N개 선택하는 조합을 모두 시도하여 적합한 햄버거 만들기
 * @author MIRAE
 */

public class Solution_5215 {
	private static int N, L, sum, best;
	private static int[] taste;
	private static int[] calories;
	private static int[] choice;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());		
		
		for (int tc = 1; tc <= T; tc++) {
			String[] temp = br.readLine().split(" ");
			N = Integer.parseInt(temp[0]);   // 재료 개수
			L = Integer.parseInt(temp[1]);   // 정해진 칼로리
			taste = new int[N];              // 맛 점수 배열
			calories = new int[N];           // 칼로리 배열(taste와 1대1 매칭)
			sum = 0; best = 0;
			
			for (int i = 0; i < N; i++) {
				temp = br.readLine().split(" ");
				taste[i] = Integer.parseInt(temp[0]);
				calories[i] = Integer.parseInt(temp[1]);
			}
			
			for (int j = 1; j <= N; j++) {   // 1개 ~ N개 선택하는 조합 모두 시도해보기
				choice = new int[j];
				combination(0, 0, j);
			}
			System.out.println("#" + tc + " " + best);
		}
	}
	private static void combination(int start, int cnt, int n) {
		if (sum > L) return;         // 합이 정해진 칼로리를 넘으면 리턴
		
		if (cnt == n) {              // n개가 선택되었을 때 맛 점수의 합과 이전의 최대점수 비교
			int sumTaste = 0;
			for (int j = 0; j < n; j++) {
				sumTaste += choice[j];
			}
			best = Math.max(best, sumTaste);
			return;
		}
		for (int i = start; i < N; i++) {
			choice[cnt] = taste[i];
			sum += calories[i];
			combination(i+1, cnt+1, n);
			sum -= calories[i];
		}
	}
}
