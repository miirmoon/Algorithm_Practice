package com.miirmoon.bj2000;

import java.util.Scanner;

/**
 * BeakJoon 2839. 설탕 배달
 * Date: 2021. 8. 17.
 * Solution: 3kg짜리를 하나씩 늘리다가 5kg으로 가능할 때 5kg으로 모두 채우기
 * @author MIRAE
 */

public class Solution_2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int result = 0;
		
		while (N > 0) {
			if (N % 5 == 0) {     // 5의 배수만큼 남은 경우 5kg짜리로 모두 채움
				result += N / 5;  
				N = 0;
				break;
			} else {              // 3kg짜리 추가
				N -= 3;
				result++;
			}
		}
		
		System.out.println((N == 0) ? result : -1);  // Nkg을 딱 맞게 채운 경우 해당 봉지 수를, 아닌 경우 -1 출력
		sc.close();
	}
}
