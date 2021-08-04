package com.miirmoon.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA 1873. 상호의 배틀필드
 * Date: 2021. 8. 4.
 * Solution: 메인에서 모든 동작을 하게되면 복잡해질 수 있으므로 동작별로 별도 함수를 만든다.
 * 	전차는 하나밖에 없으므로 현재 위치와 방향을 static으로 선언하여 계속해서 활용한다.
 * @author MIRAE
 */

public class Solution_1873 {
	private static char[][] map;
	private static int H, W;                 // 맵의 높이와 너비
	private static int curX, curY, curDir;   // 전차의 현재 위치와 방향
	private static int[] dx = {-1, 1, 0, 0}; // 상하좌우
	private static int[] dy = {0, 0, -1, 1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][];
			
			// 맵 구성하기
			for (int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			// 전차 위치 찾기
			findTank();
			
			br.readLine();   // 명령어 횟수(사용되는 곳 없음)
			
			// 명령어 입력받고 해당하는 동작 처리
			char[] commands = br.readLine().toCharArray();
			for (char c: commands) {
				switch(c) {
				case 'S': shoot(); break;
				default: act(c);
				}
			}
						
			// 결과값 출력하기
			System.out.print("#" + tc + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
	// 전차 찾기
	private static void findTank() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if ("^v<>".indexOf(map[i][j]) >= 0) {
					curX = i;
					curY = j;
					curDir = "^v<>".indexOf(map[i][j]);
				}
			}
		}
	}
	// 전차가 맵 안에 있는지 검사하기
	private static boolean isMapIn(int nx, int ny) {
		return nx >= 0 && nx < H && ny >= 0 && ny < W;
	}
	
	// 방향전환 및 이동
	private static void act(char command) {
		curDir = "UDLR".indexOf(command);
		int nx = curX + dx[curDir];
		int ny = curY + dy[curDir];
		
		if (isMapIn(nx, ny) && map[nx][ny] == '.') {   // 이동 조건에 맞으면 이동
			map[curX][curY] = '.';
			curX = nx;
			curY = ny;
		}
		map[curX][curY] = "^v<>".charAt(curDir);      // 전차 현재 위치에 전차 표시 넣어주기
	}
	
	// 포탄 발사
	private static void shoot() {
		int nx = curX + dx[curDir];
		int ny = curY + dy[curDir];
		
		while (true) {
			if (!isMapIn(nx, ny)) return;    // 포탄이 맵 밖으로 나가면 중단
			
			switch (map[nx][ny]) {
			case '*':                        // 포탄이 벽돌벽에 맞으면 그 위치는 평지가 되고 사라짐
				map[nx][ny] = '.';
				return;
			case '#': return;                // 포탄이 강철벽에 맞으면 아무일 없이 사라짐
			default: break;
			}
			nx += dx[curDir];
			ny += dy[curDir];
		}
	}
}
