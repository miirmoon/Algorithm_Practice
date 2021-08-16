package com.miirmoon.swea.d3;

import java.util.Scanner;

/**
 * SWEA 1493. 수의 새로운 연산
 * Date: 2021. 8. 16.
 * Solution: &, #, 덧셈 연산을 각각 함수로 구현하여 처리
 * @author MIRAE
 */

class point {
	int x, y;
	point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution_1493_sol1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			
			System.out.println("#" + tc + " " + calSharp(plusPoint(calAnd(p), calAnd(q))));
		}		
		sc.close();
	}
	// &(p) 구하기
	private static point calAnd(int p) {
		int tn = 0;
		int px = 1;
		int py = 1;
		outer: while (tn < p) {			
			for (int i = py; i > 0; i--) {
				tn++;
				if (tn == p) {
					py = i;
					break outer;
				}
				px++;
			}
			py++;
			px = 1;
		}
		return new point(px, py);
	}
	// #(x, y) 구하기
	private static int calSharp(point po) {
		int tn = 0;
		int px = 1;
		int py = 1;
		outer: while (true) {			
			for (int i = py; i > 0; i--) {
				tn++;
				if (px == po.x && i == po.y) break outer;
				px++;
			}
			py++;
			px = 1;
		}
		return tn;
	}
	// 점(x, y)와 점(z, w)의 덧셈 구하기 
	private static point plusPoint(point p1, point p2) {
		return new point(p1.x+p2.x, p1.y+p2.y);
	}
}
