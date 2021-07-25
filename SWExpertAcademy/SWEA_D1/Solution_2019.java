package com.miirmoon.swea.d1;

/**
 * SWEA 2019. 더블더블
 * Date: 2021. 7. 25.
 * @author MIRAE
 */

import java.util.Scanner;

public class Solution_2019 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// 2의 i제곱 출력하기
		for (int i = 0; i <= n; i++) {
			System.out.print((int)Math.pow(2, i) + " ");
		}
		sc.close();
	}
}
