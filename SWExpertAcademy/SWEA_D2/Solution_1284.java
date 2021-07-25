package com.miirmoon.swea.d2;

import java.util.Scanner;

/**
 * SWEA 1284. 수도 요금 경쟁
 * Date: 2021. 7. 25.
 * @author MIRAE
 */

public class Solution_1284 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc = 1; tc <= T; tc++)
		{
			int A = 0, B = 0;       // A사 및 B사의 수도요금
			
			int P = sc.nextInt();   // A사의 1L당 요금
			int Q = sc.nextInt();   // B사의 RL 이하 기본 요금
			int R = sc.nextInt();   // B사의 기본요금 기준
			int S = sc.nextInt();   // B사의 RL 이상 시 1L당 요금
			int W = sc.nextInt();   // 종민이 집에서 사용한 수도 양
			
			// A사 기준 요금 계산
			A = P * W;
			
			// B사 기준 요금 계산
			B = (W <= R) ? Q : Q + (W-R) * S;
			
			// A와 B중 더 적은 요금 출력
			System.out.println("#" + tc + " " + Math.min(A, B));	
		}	
		sc.close();
	}
}
