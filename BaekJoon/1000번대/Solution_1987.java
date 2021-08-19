package com.miirmoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * BaekJoon 1987. 알파벳
 * Date: 2021. 8. 19. 
 * @author MIRAE
 */

public class Solution_1987 {
	
	private static int[] dx = {0, 1, 0, -1};  // 우, 하, 좌, 상
	private static int[] dy = {1, 0, -1, 0};
	private static int R, C, maxCnt;
	private static ArrayList<Character> tmpArr;
	private static char[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		R = Integer.parseInt(tmp[0]);
		C = Integer.parseInt(tmp[1]);
		maxCnt = 1;
		tmpArr = new ArrayList<Character>();
		
		board = new char[R][];
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		move(0, 0);
		System.out.println(maxCnt);
	}
	private static void move(int x, int y) {
		tmpArr.add(board[x][y]);
		for (int i = 0; i < 4; i++) {  // 우, 하, 좌, 상 순으로 움직일 위치 확인
			if (x+dx[i] >= 0 && x+dx[i] < R && y+dy[i] >= 0 && y+dy[i] < C) {  // 다음 움직일 위치가 보드 범위 내에 있을 때에만 실행
				if (tmpArr.contains(board[x+dx[i]][y+dy[i]])) continue;        // 이미 지나온 알파벳이면 pass
				
				move(x+dx[i], y+dy[i]);
				maxCnt = Math.max(maxCnt, tmpArr.size());   // 말이 지나온 경로의 길이 최대값 구하기
				tmpArr.remove(tmpArr.size()-1);             // 다른 경로 확인을 위해 최근 경로 삭제
			}
		}
	}
}
