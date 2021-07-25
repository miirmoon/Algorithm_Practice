package com.miirmoon.swea.d1;

/**
 * SWEA 2050. 알파벳을 숫자로 변환
 * Date: 2021. 7. 25.
 * @author MIRAE
 */

import java.util.Scanner;

public class Solution_2050 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] str = sc.next().toCharArray();
		String result = "";
		
		// 'A'의 아스키 코드는 65이며, 알파벳 순으로 1씩 증가한다.(A~Z = 65~90)
		// 'A'를 1로 나타내기 위해 64를 빼주면 A~Z를 1~26으로 표현할 수 있다.
		for (int i = 0; i < str.length; i++) {
			result += str[i]-64 + " ";
		}
		System.out.println(result);
	}
}
