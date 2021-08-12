package com.miirmoon.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA 6808. 규영이와 인영이의 카드게임
 * Date: 2021. 8. 12.
 * Solution: 인영이가 만들 수 있는 모든 카드 순서(순열)에 대해 게임 시도해보기
 * @author MIRAE
 */

public class Solution_6808 {
	private static int[] gyuCard, inCardTmp, inCard;
	private static int gyuWin, gyuLose;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
			
		for (int tc = 1; tc <= T; tc++) {
			gyuWin = 0;
			gyuLose = 0;
			gyuCard = new int[9];
			inCardTmp = new int[9];
			inCard = new int[9];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// 규영이 카드 입력 받기
			for (int i = 0; i < 9; i++) {
				gyuCard[i] = Integer.parseInt(st.nextToken());
			}
			
			// 인영이 카드 알아내기
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				boolean have = true;
				for (int j = 0; j < 9; j++) {
					if (gyuCard[j] == i) {
						have = false;
						break;
					}
				}
				if (have == true) {
					inCardTmp[idx] = i;
					idx++;
				}
			}
			permutation(0, 0);
			
			System.out.println("#" + tc + " " + gyuWin + " " + gyuLose);
		}
	}
	// 인영이 카드 순서 배열 구하기
	private static void permutation(int cnt, int flag) {
		if (cnt == 9) {
			game(inCard);  // 구해진 인영이 카드 순서 배열로 게임하기
			return;
		}
		for (int i = 0; i < 9; i++) {
			if ((flag & 1<<i) != 0) continue;
			
			inCard[cnt] = inCardTmp[i];
			permutation(cnt+1, flag | 1<<i);
		}
	}
	// 카드 게임하기
	private static void game(int[] incard) {
		int gyuScore = 0;
		int inScore = 0;
		
		for (int i = 0; i < 9; i++) {
			if (gyuCard[i] > incard[i]) {
				gyuScore += (gyuCard[i] + incard[i]);
			} else {
				inScore += (gyuCard[i] + incard[i]);
			}
		}
		if (gyuScore > inScore) gyuWin++;
		if (gyuScore < inScore) gyuLose++;
	}
}
