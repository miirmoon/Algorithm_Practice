package com.miirmoon.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * SWEA 1861. 정사각형 방
 * Date: 2021. 8. 21.
 * @author MIRAE
 */

public class Solution_1861 {
	private static int[][] room;
	private static int N, num, maxCnt;
	private static int[] dx = {-1, 1, 0, 0};  // 상 하 좌 우
	private static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			// 데이터 입력받기
			N = Integer.parseInt(br.readLine());
			room = new int[N][N];
			for (int i = 0; i < N; i++) {
				String[] tmp = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					room[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			// 다음 테스트 케이스를 위한 데이터 초기화
			num = Integer.MAX_VALUE;
			maxCnt = 0;
			// 각 방을 출발점으로 해서 이동할 수 있는 최대 방 검사하기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					moveRoom(room[i][j], i, j, 1);
				}
			}
			System.out.println("#" + tc + " " + num + " " + maxCnt);
		}
	}
	private static void moveRoom(int start, int x, int y, int cnt) {
		boolean move = false;
		// 4개 방향에 대해 갈 수 있는 곳 검사
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;  // 방의 범위를 넘어가면 다음 방향을 검사
			if (room[nx][ny] == room[x][y] + 1) {   // 검사한 방이 현재 방 번호의 +1인 경우
				move = true;
				moveRoom(start, nx, ny, cnt+1);     // 검사한 방으로 이동함
				break;
			}
		}
		if (!move) {  // 방 이동을 더 이상 할 수 없는 경우
			if (maxCnt == cnt) num = Math.min(num, start);  // 이동할 수 있는 방의 최대 개수가 같으면 더 작은 방 번호 저장
			else if (maxCnt < cnt) {   // 이동할 수 있는 방의 최대 개수가 현재 방이 더 크면 방 번호와 개수 저장
				maxCnt = cnt;
				num = start;
			}
		}
	}
}
