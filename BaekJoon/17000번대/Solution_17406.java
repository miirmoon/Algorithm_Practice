package com.miirmoon.bj17000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BeakJoon 17406. 배열 돌리기 4
 * Date: 2021. 8. 11.
 * @author MIRAE
 */

public class Solution_17406 {
	private static int K;                          // 회전 연산 수
	private static int[] dx = {1, 0, -1, 0};       // 하, 우, 상, 좌
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] Arr, command;           // 원본 배열, 명령 배열
	private static int[] orderBefore, orderAfter;  // 명령 순서를 섞을 임시 배열
	private static boolean[] isSelected;           // 순열에서 사용할 임시 배열
	private static int MIN = Integer.MAX_VALUE;    // 최솟값(구하려는 값)
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);    // 행 입력받기
		int M = Integer.parseInt(temp[1]);    // 열 입력받기
		K = Integer.parseInt(temp[2]);        // 회전 횟수
		
		Arr = new int[N][M];                  // 원본(초기)배열 생성
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {				
				Arr[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		orderBefore = new int[K];             // 명령 순서를 섞기 위한 초기 배열
		for (int i = 0; i < K; i++) {
			orderBefore[i] = i;
		}
		orderAfter = new int[K];              // 명령 순서를 섞은 순열 결과를 저장하는 배열
		isSelected = new boolean[K];          
		command = new int[K][3];              // 회전 연산 명령어 저장
		for (int j = 0; j < K; j++) {
			temp = br.readLine().split(" ");
			command[j][0] = Integer.parseInt(temp[0]);
			command[j][1] = Integer.parseInt(temp[1]);
			command[j][2] = Integer.parseInt(temp[2]);
		}
		permutation(0);                       // 순열 구하기
		System.out.println(MIN);
	}
	
	// 배열 회전하기
	private static int[][] rotate(int[][] arr, int r, int c, int s) {
		int startR = r-s-1;
		int startC = c-s-1;
		int endR = r+s-1;
		int endC = c+s-1;
		
		for (int i = 0; i < s; i++) {
			int temp = arr[startR][startC];   // 시작지점 데이터 임시저장
			int ix = startR;
			int iy = startC;
			for (int d = 0; d < 4; d++) {
				while (true) {
					if (ix+dx[d] > endR || ix+dx[d] < startR || iy+dy[d] > endC || iy+dy[d] < startC) break;
					if (ix+dx[d] == startR && iy+dy[d] == startC) break;  // 시작지점으로 돌아오기 바로 직전에 중단(시작지점의 데이터로 채우기 위함)
					arr[ix][iy] = arr[ix+dx[d]][iy+dy[d]];				
					ix += dx[d];
					iy += dy[d];
				}
			}
			arr[ix][iy] = temp;
			startR++;
			startC++;
			endR--;
			endC--;
		}
		return arr;
	}
	
	// (순열) 명령어의 순서를 바꾸어가면서 연산해보기
	private static void permutation(int cnt) {
		if (cnt == K) {
			int[][] tArr = new int[Arr.length][Arr[0].length];
			// 임시배열에 원본 배열을 복사
			for (int c = 0; c < tArr.length; c++) {     
				System.arraycopy(Arr[c], 0, tArr[c], 0, tArr[c].length);
			}
			// 해당 순열의 순서대로 배열 회전
			for (int i = 0; i < orderAfter.length; i++) {
				int tmpi = orderAfter[i];
				tArr = rotate(tArr,command[tmpi][0], command[tmpi][1], command[tmpi][2]); 
			}
			// 최솟값 구하기
			calMin(tArr);
			return;
		}
		
		for (int i = 0; i < K; i++) {
			if (isSelected[i]) continue;
			
			orderAfter[cnt] = orderBefore[i];
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
	
	// 각 행의 합들 중 최소값 구하기
	private static void calMin(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = 0; j < arr[i].length; j++) {
				sum += arr[i][j];
			}
			MIN = Math.min(MIN, sum);
		}
	}
}
