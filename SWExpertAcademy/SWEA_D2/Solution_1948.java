package com.miirmoon.swea.d2;

import java.util.Scanner;

/**
 * SWEA 1948. 날짜 계산기
 * Date: 2021. 7. 29.
 * @author MIRAE
 */

public class Solution_1948 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		for(int tc = 1; tc <= T; tc++)
		{
			int result = 0;
			int month1 = sc.nextInt();
			int day1 = sc.nextInt();
			int month2 = sc.nextInt();
			int day2 = sc.nextInt();
			
			for (int i = month1; i < month2; i++) {
				result += days[i];
			}
			result = result - day1 + day2 + 1;
			System.out.println("#" + tc + " " + result);
		}
		sc.close();
	}
}
