package com.miirmoon.swea.d1;

/**
 * SWEA 1933. 간단한 N의 약수
 * Date: 2021. 7. 25.
 * @author MIRAE
 */

import java.util.Scanner;

public class Solution_1933 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		// N을 1부터 N까지의 자연수로 나누면서 나누어떨어지는 수를 출력한다.
		for (int n = 1; n <= N; n++) {
			if (N % n == 0) System.out.print(n + " ");
		}
		sc.close();
	}
}
