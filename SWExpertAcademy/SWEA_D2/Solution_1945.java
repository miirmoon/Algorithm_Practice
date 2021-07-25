package com.miirmoon.swea.d2;

import java.util.Scanner;

/**
 * SWEA 1945. 간단한 소인수분해
 * Date: 2021. 7. 25.
 * @author MIRAE
 */

public class Solution_1945 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] num = {2, 3, 5, 7, 11};  // 소인수 배열

		for(int tc = 1; tc <= T; tc++)
		{
			System.out.print("#" + tc);
			int N = sc.nextInt();
			for (int i = 0; i < num.length; i++) {
				int count = 0;
				while(true) {
					if (N % num[i] == 0) {  // 각 소인수로 나누었을 때 나누어지면 카운트
						count++;
						N /= num[i];
					} else {                // 나누어지지 않으면 다음 소인수로 넘어감
						break;
					}			
				}
				System.out.print(" " + count);
			}
			System.out.println();
		}
		sc.close();
	}
}
