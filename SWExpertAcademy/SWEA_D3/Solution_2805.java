package com.miirmoon.swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * SWEA 2805. 농작물 수확하기
 * Date: 2021. 8. 4.
 * Solution: 중간지점을 기준으로 이전의 동작과 이후의 동작을 나누어 처리
 * @author MIRAE
 */

public class Solution_2805 {
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++)
		{
			int sum = 0;
			int N = Integer.parseInt(br.readLine());
			char[][] farm = new char[N][N];
			
			for (int i = 0; i < N; i++) {
				farm[i] = br.readLine().toCharArray();
			}
			
			int start = N/2;
			int cnt = 1;
			
			// start 위치부터 cnt개의 숫자 더하기
			for (int i = 0; i < N; i++) {
				for (int j = start; j < start+cnt; j++) {
					sum += (farm[i][j]-48);    // char형 배열이기 때문에 아스키코드로 변환되는 값을 숫자 그대로가 합산되도록 하기 위해 -48
				}
				if (i < N/2) {				   // 중간 지점까지는 start위치를 하나 줄이고 더할 숫자 개수를 2개 늘림 
					start--;
					cnt += 2;
				} else {                       // 중간 지점 이후부터는 start위치를 하나 늘리고 더할 숫자 개수를 2개 줄임
					start++;
					cnt -= 2;
				}
			}
			System.out.println("#" + tc + " " + sum);
		}
	}
}
