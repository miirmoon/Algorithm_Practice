package com.miirmoon.bj15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * BaekJoon 15686. 치킨 배달
 * Date: 2021. 8. 13.
 * Solution: 위치정보를 클래스로 만들어서 사용, 조합은 NextPermutation 이용
 * @author MIRAE
 */

// 치킨집 또는 집의 위치를 담는 클래스
class position {
	int x;
	int y;
	
	position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution_15686_sol1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);
		List<position> chicken = new ArrayList<position>();
		List<position> house = new ArrayList<position>();
		int chickenDistance = Integer.MAX_VALUE;
		
		// 치킨집(chicken)과 집(house)의 정보 각각 저장하기
		for (int i = 0; i < N; i++) {
			tmp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				if (tmp[j].equals("0")) continue;
				if (tmp[j].equals("1"))	house.add(new position(i, j));
				else chicken.add(new position(i, j));
			}
		}
		
		int[] tempArr = new int[chicken.size()];
		for (int i = 1; i <= M; i++) {
			tempArr[chicken.size()-i] = 1;
		}
		
		// 살아남을 치킨집 M개에 대해 최소 치킨거리 계산하기
		do { 
			int minCityDis = 0;
			for (int i = 0; i < house.size(); i++) {
				int homeDis = Integer.MAX_VALUE;
				for (int j = 0; j < chicken.size(); j++) {
					if (tempArr[j] == 0) continue;
					int distance = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y);
					homeDis = Math.min(homeDis, distance);
				}
				minCityDis += homeDis;
			}
			chickenDistance = Math.min(chickenDistance, minCityDis);
		} while (pick(tempArr));
		System.out.println(chickenDistance);
	}
	
	// 치킨 집 중 살아남을 치킨 집 M개 뽑기
	private static boolean pick(int[] arr) {
		int N = arr.length;
		
		int i = N-1;
		while (i > 0 && arr[i-1] >= arr[i]) i--;
		
		if (i == 0) return false;
		
		int j = N-1;
		while (arr[i-1] >= arr[j]) j--;
		
		swap(arr, i-1, j);
		
		int k = N-1;
		while(i < k) swap(arr, i++, k--);
		
		return true;
	}
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
