package com.miirmoon.swea.d1;

/**
 * SWEA 2025. N줄덧셈
 * Date: 2021. 7. 25.
 * @author MIRAE
 */

import java.util.Scanner;

public class Solution_2025 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum = 0;
		
		// 1부터 num까지 모든 자연수 더하기
		for (int n = 1; n <= num; n++) {
			sum += n;
		}
		System.out.println(sum);
		sc.close();
	}

}
