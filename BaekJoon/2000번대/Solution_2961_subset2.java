package com.miirmoon.bj2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BeakJoon 2961. 도영이가 만든 맛있는 음식
 * Date: 2021. 8. 12.
 * Solution: 바이너리 카운팅 이용하기
 * @author MIRAE
 */

public class Solution_2961_subset2 {
	private static int N;
	private static int[][] taste;
	private static int SUB = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());   // 재료의 개수
		taste = new int[N][2];             // 재료별 맛 배열
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			taste[i][0] = Integer.parseInt(st.nextToken());  // 재료의 신맛
			taste[i][1] = Integer.parseInt(st.nextToken());  // 재료의 쓴맛
		}
		calculate(0);
		System.out.println(SUB);
	}
	// 재료를 사용하는 부분집합 만들고 맛 차이 계산하기
	private static void calculate(int cnt) {
		for (int i = 0; i < (1<<N); i++) {
			int sour = 1;
			int bitter = 0;
			for (int j = 0; j < N; j++) {
				if ((i & (1<<j)) != 0) {
					sour *= taste[j][0];
					bitter += taste[j][1];
				}
			}
			if (sour != 1 && bitter != 0) {
				int sub = Math.max(sour, bitter) - Math.min(sour, bitter);
				SUB = Math.min(sub, SUB);
			}
		}
		
	}
}
