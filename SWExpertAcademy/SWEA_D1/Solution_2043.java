package com.miirmoon.swea.d1;

/**
 * SWEA 2043. 서랍의 비밀번호
 * Date: 2021. 7. 25.
 * @author MIRAE
 */

import java.util.Scanner;

public class Solution_2043 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int P = sc.nextInt();
		int K = sc.nextInt();
		
		System.out.println(P-K+1);				
		sc.close();
	}
}
