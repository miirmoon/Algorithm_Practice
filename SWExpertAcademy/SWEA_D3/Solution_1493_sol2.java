package com.miirmoon.swea.d3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * SWEA 1493. 수의 새로운 연산
 * Date: 2021. 8. 16.
 * Solution: 좌표에 대한 값을 미리 계산해 놓고 처리하기
 * @author MIRAE
 */

public class Solution_1493_sol2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] map = new int[300][300];
		
		int count = 1;
		for (int i = 1; i <= 300; i++) {
			for (int j = 1; j < i; j++) {
				map[j][i-j] = count++;
			}
		}
		
		for (int[] a : map) {
			System.out.println(Arrays.toString(a));
		}
		
		for (int tc = 1; tc <= T; tc++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			
			// p, q의 좌표값 구하기
			int x=0, y=0, z=0, w=0;
			outer: for (int i = 1; i < map.length; i++) {
				for (int j = 1; j <= map[i].length-i; j++) {
					if (map[i][j] == p) {
						x = i;
						y = j;
					}
					if (map[i][j] == q) {
						z = i;
						w = j;
					}
					if (x != 0 && y != 0 && z != 0 && w != 0) break outer;
				}
			}			
			System.out.println("#" + tc + " " + map[x+z][y+w]);
		}		
		sc.close();
	}
}
