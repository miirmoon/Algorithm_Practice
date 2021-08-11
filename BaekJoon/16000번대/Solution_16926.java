package com.miirmoon.bj16000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BeakJoon 16926. 배열 돌리기 1
 * Date: 2021. 8. 11.
 * @author MIRAE
 */

public class Solution_16926 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);
		int R = Integer.parseInt(tmp[2]);
		
		String[][] arr = new String[N][];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().split(" ");
		}
		// R번 회전 반복
		for (int i = 0; i < R; i++) {
			int start = 0;
			int ix, iy;
			while (start < Math.min(N, M)/2) {
				ix = start; 
				iy = start;
	
				String temp = arr[start][start]; // 시작하는 수 담아두기
				for (int d = 0; d < 4; d++) {
					while (true) {
						if (ix+dx[d] < start || ix+dx[d] >= N-start || iy+dy[d] < start || iy+dy[d] >= M-start) break;
						if (ix+dx[d] == start && iy+dy[d] == start) break;   // 시작하는 수 바로 전에 중단(시작하는 수를 담기 위함)
						arr[ix][iy] = arr[ix+dx[d]][iy+dy[d]];  // 뒤의 수를 앞으로 옮기기
						ix += dx[d];
						iy += dy[d];
					}
				}
				arr[ix][iy] = temp;   // 시작하는 수를 마지막에 담기
				start++;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
