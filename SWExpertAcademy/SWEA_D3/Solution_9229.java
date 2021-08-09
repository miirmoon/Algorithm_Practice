package com.miirmoon.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA 9229. 한빈이와 Spot Mart
 * Date: 2021. 8. 9.
 * Solution: 과자봉지 개수 중 2개를 뽑는 조합을 이용하기
 * @author MIRAE
 */

public class Solution_9229 {
	private static int sum, maxSum, N, M;
	private static int[] snackWeight;
	private static int[] choice;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++)
		{
			sum = 0; maxSum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());   // 과자봉지 개수
			M = Integer.parseInt(st.nextToken());   // 한빈이가 들 수 있는 최대 무게
			snackWeight = new int[N];               // 과자 봉지별 무게 배열
			choice = new int[2];                    // 선택한 과자 봉지 2개를 담을 배열
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				snackWeight[i] = Integer.parseInt(st.nextToken());
			}
			
			combination(0, 0);
			
			if (maxSum == 0) maxSum = -1;            // 최대 무게를 넘지 않는 maxSum을 구하지 못했으면 -1
			System.out.println("#" + tc + " " + maxSum);
		}
	}
	private static void combination(int start, int cnt) {
		if (sum > M) {    // 최대 무게를 넘으면 리턴
			return;
		}
		if (cnt == 2) {   // 선택한 2개의 과자봉지 무게와 지금까지 가장 큰 무게와 비교
			if (sum > maxSum) maxSum = sum;
			return;
		}
		for (int i = start; i < N; i++) {
			choice[cnt] = snackWeight[i];
			sum += snackWeight[i];
			combination(i+1, cnt+1);
			sum -= snackWeight[i];    // 처음 선택한 과자 봉지 무게를 유지하기 위해 더했던 무게만 빼줌
		}
	}
}
