package com.miirmoon.swea.d1;

/**
 * SWEA 2046. 스탬프 찍기
 * Date: 2021. 7. 25.
 * @author MIRAE
 */

import java.util.Scanner;

public class Solution_2046 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		for (int i = 0; i < num; i++) {
			System.out.print("#");
		}
		sc.close();
	}
}
