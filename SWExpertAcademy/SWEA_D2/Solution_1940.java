package com.miirmoon.swea.d2;

import java.util.Scanner;

/**
 * SWEA 1940. 가랏! RC카!
 * Date: 2021. 7. 25.
 * @author MIRAE
 */

public class Solution_1940 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 0: 현재속도 유지, 1: 가속, 2: 감속
		int[] rcCar = {0, 1, -1};

		for (int tc = 1; tc <= T; tc++)
		{
			int N = sc.nextInt();
			int speed = 0;            // 현재속도를 나타내는 변수
			int distance = 0;         // 출발 시점부터 이동한 거리를 나타내는 변수
			// 1초에 한 명령씩 N초간 수행
			for (int n = 0; n < N; n++) {
				int rc = sc.nextInt();
				if (rc != 0) {         // 입력받은 명령이 0(현재 속도 유지)가 아닐때
					speed += sc.nextInt() * rcCar[rc];  // 속도를 가속(1) 또는 감속(2)
				}
				if (speed < 0) speed = 0;   // 현재 속도보다 많이 감속되어 값이 -가 된 경우 속도를 0으로 초기화
				distance += speed;          // 속도만큼 거리 이동(speed는 1초에 이동한 거리(m/s)이므로)
			}
			System.out.println("#" + tc + " " + distance);
		}
		sc.close();
	}

}
