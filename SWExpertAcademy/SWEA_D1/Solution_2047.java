package com.miirmoon.swea.d1;

/**
 * SWEA 2047. 신문 헤드라인
 * Date: 2021. 7. 25.
 * @author MIRAE
 */

import java.util.Scanner;

public class Solution_2047 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] headline = sc.next().toCharArray();
		
		// 아스키코드: (a~z) 97~122 / (A~Z) 65~90
		// 소문자의 아스키코드 값에서 -32를 해주면 매칭되는 대문자의 아스키코드 값이 된다.		
		for (int i = 0; i < headline.length; i++) {
			if (headline[i] >= 97 && headline[i] <= 122) {
				headline[i] -= 32;
			}
		}
		System.out.println(headline);
		sc.close();
	}

}
