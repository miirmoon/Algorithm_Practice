package com.miirmoon.swea.d2;

import java.util.Scanner;

/**
 * SWEA 1954. 달팽이 숫자
 * Date: 2021. 8. 1.
 * @author MIRAE
 */

public class Solution_1954 {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N;

		for(int tc = 1; tc <= T; tc++)
		{
			N = sc.nextInt();
			int[][] snail = new int[N][N];
			int num = 1;                  // 달팽이 숫자
			int i = 0, j = 0, dir = 1;    // 각 칸의 인덱스(i, j) 및 움직일 방향
			int n = N-1;                  // 가로 또는 세로로 달팽이 숫자가 움직일 횟수
			
			for (int a = 0; a < N; a++) { // 첫줄(달팽이 숫자 1~N) 먼저 처리
				snail[0][a] = num++;
				j = a;
			}
			while (num <= N*N) {               // 두번째 줄부터 움직이는 횟수(n)를 1씩 줄여가면서 num이 N*N이 될때까지 채움
				for (int a = 0; a < n; a++) {  // 세로방향(상, 하)
					i = i+dir;
					snail[i][j] = num++;
				}
				for (int b = 0; b < n; b++) {  // 가로방향(좌, 우)
					j = j-dir;
					snail[i][j] = num++;
				}
				dir *= -1;                     // 움직이는 방향을 바꾸어줌(상 <-> 하, 좌 <-> 우)
				n -= 1;                        // 움직일 횟수를 1칸 줄임
			}
			System.out.println("#" + tc);
			for (int a = 0; a < snail.length; a++) {
				for (int b = 0; b < snail[a].length; b++) {
					System.out.print(snail[a][b] + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
