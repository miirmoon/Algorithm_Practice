package com.miirmoon.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * SWEA 1210. Ladder1
 * Date: 2021. 8. 3.
 * Solution: 맨 아래 도착지점부터 출발하여 대응되는 출발점 찾기
 * @author MIRAE
 */

public class Solution_1210 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[][] ladder = new String[100][100];
		int curX = 0;
		
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();  // 테스트케이스 입력
			// 사다리 배열 구성하기
			for (int i = 0; i < 100; i++) {
				ladder[i] = br.readLine().split(" ");
			}
			
			// 맨 아래 도착지점(2) 찾기(도착지점부터 출발하여 대응되는 출발점을 찾기 위함)
			for (int i = 0; i < ladder[99].length; i++) {
				if (ladder[99][i].contains("2")) {
					curX = i;
					break;
				}
			}
			
			// 사다리 타기
			for (int a = 98; a >= 0; a--) {
				if (curX > 0 && ladder[a][curX-1].contains("1")) {           // 현재 위치 기준으로 왼쪽(curX-1)으로 연결된 사다리가 있으면 이동
					while (curX > 0 && ladder[a][curX-1].contains("1")) {
						curX--;
					}
				} else if (curX < 99 && ladder[a][curX+1].contains("1")) {   // 현재 위치 기준으로 오른쪽(curX+1)으로 연결된 사다리가 있으면 이동
					while (curX < 99 && ladder[a][curX+1].contains("1")) {
						curX++;
					}
				}						
			}
					
			System.out.println("#" + tc + " " + curX);
		}
	}
}
