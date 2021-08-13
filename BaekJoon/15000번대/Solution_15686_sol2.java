package com.miirmoon.bj15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * BaekJoon 15686. 치킨 배달
 * Date: 2021. 8. 13.
 * Solution: 위치정보를 int배열로 사용, 조합은 재귀함수 이용, 각 치킨집과 집의 거리를 미리 계산하여 거리계산 중복을 제거
 * @author MIRAE
 */

public class Solution_15686_sol2 {
	static ArrayList<int[]> home = new ArrayList<int[]>();
	static ArrayList<int[]> chickens = new ArrayList<int[]>();
	static int N, M, ans = (int)1e9;
	static int[] sel;     // (조합) 선택된 것을들 담을 배열
	static int[][] dist;  // 치킨집과 집 사이 거리를 저장할 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] data = br.readLine().split(" ");
		N = Integer.parseInt(data[0]);
		M = Integer.parseInt(data[1]);
		
		for (int i = 0; i < N; i++) {
			data = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				int v = Integer.parseInt(data[j]);
				if (v == 1) home.add(new int[] {i, j});   // 집
				else if (v == 2) chickens.add(new int[] {i, j}); // 치킨집
			}
		}
		
		//치킨집과 집의 거리 저장하기(거리계산 중복 제거)
		dist = new int[chickens.size()][home.size()];
		for (int i = 0; i < chickens.size(); i++) {
			for (int j = 0; j < home.size(); j++) {
				dist[i][j] = calcDist(chickens.get(i), home.get(j));
			}
		}
		
		sel = new int[M];
		comb(0, 0);
		System.out.println(ans);
	}
	
	private static void comb(int cnt, int start) {
		if (cnt == M) {
			// 도시의 치킨거리 구하기
			int cityDist = 0;
			for (int i = 0; i < home.size(); i++) {
				int homeDist = (int)1e9;
				for (int j = 0; j < M; j++) {
					homeDist = Math.min(homeDist, dist[sel[j]][i]);  // 집의 치킨거리
				}
				cityDist += homeDist;
			}
			ans = Math.min(ans, cityDist);
			return;
		}
		for (int i = start; i < chickens.size(); i++) {
			sel[cnt] = i;
			comb(cnt+1, i+1);
		}
	}

	private static int calcDist(int[] loc1, int[] loc2) {
		return Math.abs(loc1[0] - loc2[0]) + Math.abs(loc1[1] - loc2[1]);		
	}
}
