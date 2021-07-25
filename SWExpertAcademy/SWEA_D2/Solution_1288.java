package com.miirmoon.swea.d2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * SWEA 1288. 새로운 불면증 치료법
 * Date: 2021. 7. 25.
 * @author MIRAE
 */

public class Solution_1288 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc = 1; tc <= T; tc++)
		{
			int x = 0;              // 몇 번째 양을 세는지 확인하는 변수
			int N = sc.nextInt();
			int[] check = new int[10];  // 0부터 9까지 나온 숫자를 체크하는 배열
			
			while (true) {
				if (!(Arrays.toString(check).contains("0"))) break;  // 배열에 0이 없으면 while문을 빠져나간다.
				x++;
				
				int temp = N * x;
				while(temp > 0) {       // xN의 각 자리수 중 아직 안본 숫자가 나오면 1로 체크
					if (check[temp % 10] == 0) check[temp % 10] = 1;
					temp = temp / 10;
				}
			}
			System.out.println("#" + tc + " " + N*x);
		}
		sc.close();
	}

}
