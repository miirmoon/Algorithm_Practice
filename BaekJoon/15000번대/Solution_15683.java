package com.miirmoon.bj15000;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * BeakJoon 15683. 감시
 * Date: 2021. 8. 20.
 * @author MIRAE
 */

class CCTV {     // cctv 정보를 저장할 클래스
	int x, y, num;

	public CCTV(int x, int y, int num) {
		this.x = x;
		this.y = y;
		this.num = num;
	}
}

public class Solution_15683 {
	
	private static int N, M, result = Integer.MAX_VALUE;
	private static int[] dx = {-1, 0, 1, 0};  // 상, 우, 하, 좌
	private static int[] dy = {0, 1, 0, -1};
	private static int[] loopNum = {0, 4, 2, 4, 4, 1};  // cctv별 반복할 횟수(0번 미사용)
	private static int[][] shape = {{}, {1}, {1, 3}, {0, 1}, {0, 1, 3}, {0, 1, 2, 3}}; // cctv별 초기 모양(0번 미사용)
	private static ArrayList<CCTV> cctv;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		int [][] office = new int[N][M];
		cctv = new ArrayList<CCTV>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				office[i][j] = sc.nextInt();
				if (office[i][j] > 0 && office[i][j] <= 5)   // cctv 관련 정보 저장하기
					cctv.add(new CCTV(i, j, office[i][j]));
			}
		}
		
		solve(office, 0);		
	
		System.out.println(result);
	}
	
	private static void solve(int[][] office, int idx) {
		// 모든 cctv를 확인했으면 사각지대 크기 구하기(office 배열에서 0의 개수)
		if (idx == cctv.size()) {
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (office[i][j] == 0) count++;
				}
			}
			result = Math.min(result, count);
			return;
		}
		
		// 90도 회전하며 확인하기
		CCTV cur = cctv.get(idx);
		for (int i = 0; i < loopNum[cur.num]; i++) {
			// 감시가능한 구역 표시를 위한 임시 배열 생성
			int[][] temp = copyOffice(office);
			// cctv 모양에 따라 감시할 수 있는 위치 확인하기
			for (int j = 0; j < shape[cur.num].length; j++) {
				int nx = cur.x;
				int ny = cur.y;
				while (true) {
					nx += dx[(shape[cur.num][j]+i) % 4];  // shape 값에 i를 더해서 90도 움직인 방향의 좌표를 줌
					ny += dy[(shape[cur.num][j]+i) % 4];
					if (nx < 0 || nx >= N || ny < 0 || ny >= M) break;   // 사무실 범위를 벗어나면 중단
					if (temp[nx][ny] == 6) break;                      // 벽을 만나면 중단
					else if (temp[nx][ny] == 0) temp[nx][ny] = 7;    // 빈칸이면 감시 가능함을 7로 표시
				}
			}
			solve(temp, idx+1);			
		}
	}
	
	// office배열 복사하기
	private static int[][] copyOffice(int[][] office) {
		int[][] result = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result[i][j] = office[i][j];
			}
		}
		return result;
	}
}