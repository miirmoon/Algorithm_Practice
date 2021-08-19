package com.miirmoon.swea.d5;

import java.util.Scanner;

/**
 * SWEA 1247. [S/W 문제해결 응용] 최적 경로
 * Date: 2021. 8. 19.
 * Solution: 고객 방문 경로를 따라가면서 바로 거리 계산하기(메모리 22,224kb, 실행시간 306ms)
 * @author MIRAE
 */

class Position {
	int x, y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Solution_1247_sol2 {
	
	private static int N, distance;
	private static Position company, home;
	private static Position[] client;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			distance = Integer.MAX_VALUE;
			
			company = new Position(sc.nextInt(), sc.nextInt());
			home = new Position(sc.nextInt(), sc.nextInt());
			client = new Position[N];
			for (int i = 0; i < N; i++) {
				client[i] = new Position(sc.nextInt(), sc.nextInt());
			}
			calDistance(company, 0, 0, 0);
			
			System.out.println("#" + tc + " " + distance);
		}
		sc.close();
	}
	// 고객 방문 경로에 따른 이동거리 계산하기
	private static void calDistance(Position p, int cnt, int flag, int sum) {
		
		if (sum >= distance) return;  // 전체 이동거리 값을 구하기 전에 현재까지의 합이 최대값을 넘으면 중단
		
		if (cnt == N) {   // 고객을 모두 방문한 후에 집과의 거리 합산
			distance = Math.min(distance, sum + Math.abs(home.x - p.x) + Math.abs(home.y - p.y));
			return;
		}
		for (int i = 0; i < N; i++) {
			if ((flag & 1<<i) != 0) continue;   // 이미 선택된 고객은 pass
			int dis = Math.abs(p.x - client[i].x) + Math.abs(p.y - client[i].y);
			calDistance(client[i], cnt+1, flag | 1<<i, sum + dis);
		}
	}
}
