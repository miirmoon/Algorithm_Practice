package com.miirmoon.swea.d1;

/**
 * SWEA 2029. 몫과 나머지 출력하기
 * Date: 2021. 7. 25.
 * @author MIRAE
 */

import java.util.Scanner;

public class Solution_2029 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++)
		{
			// 2개의 수 입력받기
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			// a를 b로 나눈 몫(a/b)과 나머지(a%b) 출력
			System.out.println("#" + tc + " " + a/b + " " + a%b);
		}
	}

}
