package com.miirmoon.swea.d5;

import java.util.Scanner;

/**
 * SWEA 1247. [S/W 문제해결 응용] 최적 경로
 * Date: 2021. 8. 19.
 * Solution: 고객 방문 경로를 먼저 구하고 경로를 순회하면서 거리 계산하기(메모리 23,416kb, 실행시간 1,771ms)
 * @author MIRAE
 */

class Pos {
	int x, y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Solution_1247_sol1 {
	
	private static int N, distance;
	private static int[] order;
	private static Pos company, home;
	private static Pos[] client;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			distance = Integer.MAX_VALUE;
			order = new int[N];
			
			company = new Pos(sc.nextInt(), sc.nextInt());
			home = new Pos(sc.nextInt(), sc.nextInt());
			client = new Pos[N];
			for (int i = 0; i < N; i++) {
				client[i] = new Pos(sc.nextInt(), sc.nextInt());
			}
			permu(0, 0);
			
			System.out.println("#" + tc + " " + distance);
		}
		sc.close();
	}
	// 고객 방문 경로 조합
	private static void permu(int cnt, int flag) {
		if (cnt == N) {
			calDistance();   // 만들어진 경로 조합에 대한 이동거리 구하기
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if ((flag & 1<<i) != 0) continue;
			
			order[cnt] = i;
			permu(cnt+1, flag | 1<<i);
		}
	}
	// 이동거리 구하기
	private static void calDistance() {
		int sum = 0;
		Pos curr = new Pos(company.x, company.y);  // 현재 위치를 담을 변수, 회사 위치로 초기화
		
		for (int i = 0; i < N; i++) {
			sum += Math.abs(curr.x-client[order[i]].x) + Math.abs(curr.y-client[order[i]].y);
			
			if (distance < sum) return;   // 전체 이동거리 값을 구하기 전에 거리의 합이 최대값을 넘으면 계산 중단
			
			curr.x = client[order[i]].x;
			curr.y = client[order[i]].y;
		}
		sum += Math.abs(curr.x-home.x) + Math.abs(curr.y-home.y);  // 고객을 모두 방문한 후에 집과의 거리 합산
		
		distance = Math.min(distance, sum);
	}
}
