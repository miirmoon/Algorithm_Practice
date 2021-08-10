package com.miirmoon.bj2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BeakJoon 2563. 색종이
 * Date: 2021. 8. 10.
 * Solution: 색종이를 붙이는 공간을 1로 채우고(중복 여부와 관계없이) 마지막에 1의 수 총합으로 넓이 구하기
 * @author MIRAE
 */

public class Solution_2563 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] whitePaper = new int[100][100];
		int N = Integer.parseInt(br.readLine());  // 색종이의 수
		int x, y;
		
		for (int n = 0; n < N; n++) {
			String[] tmp = br.readLine().split(" ");
			x = Integer.parseInt(tmp[0])-1;
			y = Integer.parseInt(tmp[1])-1;
			
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					whitePaper[x+i][y+j] = 1;
				}
			}
		}
		
		int area = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				area += whitePaper[i][j];
			}
		}
		System.out.println(area);
	}
}
