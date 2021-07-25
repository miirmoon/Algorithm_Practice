package com.miirmoon.swea.d1;

import java.util.Scanner;

/**
 * SWEA 2058. 자릿수 더하기
 * Date: 2021. 7. 25.
 * @author MIRAE
 */

public class Solution_2058 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int result = 0;
		
		// N이 0이 될 때까지 1의 자릿수를 더하고 삭제해주는 과정을 반복하며 합을 구한다. 
		while (N > 0) {
			int one = N % 10;
			result += one;
			N = (N-one) / 10;
		}
		
		System.out.println(result);
		sc.close();
	}
}
