package com.miirmoon.swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA 1974. 스도쿠 검증
 * Date: 2021. 8. 14.
 * Solution: 가로, 세로, 3X3격자를 모두 탐색하여 스도쿠 규칙에 맞는지 확인한다.
 * @author MIRAE
 */

public class Solution_1974 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] puzzle = new int[9][9];
		
		for (int tc = 1; tc <= T; tc++) {
			// 퍼즐 입력받기
			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 9; j++) {
					puzzle[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#" + tc + " " + (check(puzzle) ? 1 : 0));
		}
	}
	private static boolean check(int[][] puzzle) {
		// 가로(행) 체크
		for (int i = 0; i < 9; i++) {
			// 겹치는 숫자를 체크할 배열 초기화하기
			int[] check = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			for (int j = 0; j < 9; j++) {
				check[puzzle[i][j]] = 1;   // 퍼즐의 숫자를 인덱스로 하여 해당 위치에 1로 체크하기
			}
			// 유효성 검사하기
			for (int c = 0; c < 9; c++) {
				if (check[c] == 0) return false;
			}
		}
		
		// 세로(열) 체크
		for (int j = 0; j < 9; j++) {
			int[] check = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			for (int i = 0; i < 9; i++) {
				check[puzzle[i][j]] = 1;
			}
			for (int c = 0; c < 9; c++) {
				if (check[c] == 0) return false;
			}
		}
		
		// 3 X 3 격자 체크: 각 격자의 시작점부터 9개씩 순회하면서 체크 
		for (int startX = 0; startX <= 6; startX+=3) {
			for (int startY = 0; startY <= 6; startY+=3) {
				int[] check = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
				for (int i = startX; i < startX+3; i++) {
					for (int j = startY; j < startY+3; j++) {
						check[puzzle[i][j]] = 1;
					}
				}
				for (int c = 0; c < 9; c++) {
					if (check[c] == 0) return false;
				}
			}
		}
		return true;
	}
}
