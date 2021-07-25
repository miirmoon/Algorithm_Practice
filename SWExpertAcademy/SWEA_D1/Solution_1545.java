package com.miirmoon.swea.d1;

/**
 * SWEA 1545. 거꾸로 출력해 보아요
 * Date: 2021. 7. 25.
 * @author MIRAE
 */

import java.util.Scanner;

public class Solution_1545 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int n = N; n >= 0; n--) {
			System.out.print(n + " ");
		}
		sc.close();
	}
}
