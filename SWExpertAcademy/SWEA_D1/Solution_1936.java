package com.miirmoon.swea.d1;

/**
 * SWEA 1936. 1대1 가위바위보
 * Date: 2021. 7. 25.
 * @author MIRAE
 */

import java.util.Scanner;

public class Solution_1936 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		char result = 'A';
		
		// 비기는 경우는 없으므로 result 초기값을 'A'로 두고 b가 이겼을 경우만 확인하여 'B'로 변경한다.
		switch(a) {
		case 1:
			if (b == 2) result = 'B';
			break;
		case 2:
			if (b == 3) result = 'B';
			break;
		case 3:			
			if (b == 1) result = 'B';
			break;
		}
		System.out.println(result);
		sc.close();
	}
}
