package com.miirmoon.swea.d2;

import java.util.Scanner;

/**
 * SWEA 1946. 간단한 압축 풀기
 * Date: 2021. 7. 25.
 * @author MIRAE
 */

public class Solution_1946 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc = 1; tc <= T; tc++)
		{
			int N = sc.nextInt();
			char ch = ' ';        // 연속되는 문자를 나타낼 변수
			int count = 0;        // 문자가 연속되는 횟수를 나타낼 변수
			String result = "";   // 최종 결과 값을 저장할 변수
			int width = 10;       // 문서의 너비
			
			while(true) {
				if (count == 0) {       // 1. 문자가 필요한 횟수만큼 사용되었을 때
					if (N == 0) break;  // 입력값이 끝난 경우 while문 중단
					ch = sc.next().charAt(0);
					count = sc.nextInt();
					N--;                // 입력값을 받은 횟수 카운트
				}
				if (width == 0) {       // 2. 문서의 너비(10)만큼 한 줄이 꽉 찼을때 다음줄로 넘어감
					width = 10;
					result += "\n";
				}
				result += ch;           // 1, 2번 조건에 해당하지 않는 경우 문자를 연속해서 넣어줌
				count--;                // 1, 2번 조건을 위한 카운트
				width--;
			}
			System.out.println("#" + tc);
			System.out.println(result);
		}
		sc.close();
	}

}
