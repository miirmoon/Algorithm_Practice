package com.miirmoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BeakJoon 1074. Z
 * Date: 2021. 8. 17.
 * Solution: 4등분한 후 r과 c의 위치에 따라 Z모양 탐색을 시작하는 수를 구하는 작업을 2 X 2 배열이 될 때까지 반복한다.
 * 		- Z모양 탐색을 시작하는 수: 왼쪽 위칸(0), 오른쪽 위칸(2^N-1 * 2^N-1), 왼쪽 아래칸(2^N-1 * 2^N-1 * 2), 오른쪽 아래칸(2^N-1 * 2^N-1 * 3)
 * @author MIRAE
 */

public class Solution_1074 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int r = Integer.parseInt(tmp[1]);
		int c = Integer.parseInt(tmp[2]);
		
		int startN = 0;
		while (N > 1) {  // 2 X 2 배열이 될 때까지
			int tnum = (int) Math.pow(2, N-1);     // 2의 n-1승
			if (r < tnum && c < tnum) {           // 왼쪽 위칸
				startN += 0;
			} else if (r < tnum && c >= tnum) {   // 오른쪽 위칸
				startN += tnum*tnum;
				c -= tnum;
			} else if (r >= tnum && c < tnum) {   // 왼쪽 아래칸
				startN += tnum*tnum*2;
				r -= tnum;
			} else {                              // 오른쪽 아래칸
				startN += tnum*tnum*3;
				r -= tnum;
				c -= tnum;
			}
			N--;
		}
		startN += 2*r + c;    // 인덱스에 따라 위치값 더하기(0, 1, 2, 3)
		System.out.println(startN);
	}
}
