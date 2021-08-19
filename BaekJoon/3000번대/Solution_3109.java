package com.miirmoon.bj3000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BeakJoon 3109. 빵집
 * Date: 2021. 8. 19.
 * @author MIRAE
 */

public class Solution_3109 {
	
	private static int R, C, count;
	private static char[][] map;
	private static int[] dx = {-1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		R = Integer.parseInt(tmp[0]);
		C = Integer.parseInt(tmp[1]);
		
		// 빵집 근처 모습 입력받기
		map = new char[R][];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		count = 0;
		for (int i = 0; i < R; i++) {
			linkPipeline(i, 0);
		}		
		System.out.println(count);
	}

	private static boolean linkPipeline(int x, int y) {
		map[x][y] = 'o';          // 확인한 경로임을 체크
		boolean islinked = false; // 연결이 완료되었는지 여부 확인
		if (y >= C-1) {           // 원웅이네 빵집에 도달하면 카운트하고 완료 true 반환
			count++;
			return true;
		}
		for (int i = 0; i < 3; i++) {  // 오른쪽 위, 오른쪽, 오른쪽 아래 순으로 경로 확인
			int nx = x+dx[i];
			int ny = y+1;
			if (nx < 0 || nx >= R || ny >= C || map[nx][ny] != '.') continue; // R X C격자 범위를 벗어나거나 빈칸이 아니면 pass
			
			if (islinked = linkPipeline(nx, ny)) break;  // 연결이 완료되었으면 더이상 경로를 확인하지 않음
		}
		return islinked;     // 연결 완료 여부 반환
	}
}
