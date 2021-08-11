package com.miirmoon.bj16000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BeakJoon 16935. 배열 돌리기 3
 * Date: 2021. 8. 11.
 * @author MIRAE
 */

public class Solution_16935 {
	private static int N, M;
	private static int[][] arr;
	private static int[] dx = {0, 1, -1, 0};  // 우, 하, 상, 좌
	private static int[] dy = {1, 0, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		int R = Integer.parseInt(st.nextToken());	
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		String[] operations = br.readLine().split(" ");
		
		for (int i = 0; i < R; i++) {
			switch(operations[i]) {
			case "1": operateOne();   break;
			case "2": operateTwo();   break;
			case "3": operateThree(); break;
			case "4": operateFour();  break;
			case "5": operateFive();  break;
			case "6": operateSix();   break;
			}
		}
		
		for (int a = 0; a < arr.length; a++) {
			for (int b = 0; b < arr[a].length; b++) {
				System.out.print(arr[a][b] + " ");
			}
			System.out.println();
		}
	}
	// 1번 연산: 상하 반전
	private static void operateOne() {
		for (int x = 0; x < arr.length/2; x++) {
			for (int y = 0; y < arr[0].length; y++) {
				int tmp = arr[x][y];
				arr[x][y] = arr[arr.length-x-1][y];
				arr[arr.length-x-1][y] = tmp;
			}
		}
	}
	// 2번 연산: 좌우 반전
	private static void operateTwo() {
		for (int y = 0; y < arr[0].length/2; y++) {
			for (int x = 0; x < arr.length; x++) {
				int tmp = arr[x][y];
				arr[x][y] = arr[x][arr[0].length-y-1];
				arr[x][arr[0].length-y-1] = tmp;
			}
		}
	}
	// 3번 연산: 오른쪽으로 90도 회전
	private static void operateThree() {
		int[][] tmp = new int[arr[0].length][arr.length];
		
		for (int x = 0; x < arr.length; x++) {
			for (int y = 0; y < arr[0].length; y++) {
				tmp[y][arr.length-x-1] = arr[x][y];
			}
		}
		arr = tmp;
	}
	// 4번 연산: 왼쪽으로 90도 회전
	private static void operateFour() {
		int[][] tmp = new int[arr[0].length][arr.length];
		
		for (int x = 0; x < arr.length; x++) {
			for (int y = 0; y < arr[0].length; y++) {
				tmp[arr[0].length-y-1][x] = arr[x][y];
			}
		}
		arr = tmp;
	}
	// 5번 연산: 1번 그룹 -> 2번 그룹 -> 3번 그룹 -> 4번 그룹 -> 1번 그룹
	private static void operateFive() {
		int[][] tmp = new int[arr.length][arr[0].length];
		int halfX = arr.length/2;
		int halfY = arr[0].length/2;
		
		for (int x = 0; x < arr.length; x++) {
			int d = (x < halfX) ? 0 : 2;                  // 0: 1번 -> 2번 / 2: 4번 -> 1번
			for (int y = 0; y < arr[0].length; y++) {
				if (y == halfY) d = (x < halfX) ? 1 : 3;  // 1: 2번 -> 3번 / 3: 3번 -> 4번
				tmp[x+(halfX*dx[d])][y+(halfY*dy[d])] = arr[x][y];
			}
		}		
		arr = tmp;
	}
	// 6번 연산: 1번 그룹 -> 4번 그룹 -> 3번 그룹 -> 2번 그룹 -> 1번 그룹
	private static void operateSix() {
		int[][] tmp = new int[arr.length][arr[0].length];
		int halfX = arr.length/2;
		int halfY = arr[0].length/2;
		
		for (int x = 0; x < arr.length; x++) {
			int d = (x < halfX) ? 1 : 0;                   // 1: 1번 -> 4번 / 0: 4번 -> 3번
			for (int y = 0; y < arr[0].length; y++) {
				if (y == halfY) d = (x < halfX) ? 3 : 2;   // 3: 2번 -> 1번 / 2: 3번 -> 2번
				tmp[x+(halfX*dx[d])][y+(halfY*dy[d])] = arr[x][y];
			}
		}	
		arr = tmp;
	}
}