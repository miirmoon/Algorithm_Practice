package com.miirmoon.bj17000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * BaekJoon 17135. 캐슬 디펜스
 * Date: 2021. 8. 13.
 * Solution: 기능별 별도 함수 구현
 * 		- arrange(): 궁수 위치 배치, 공격 기능 실행
 * 		- attack(): 적 제거하기
 * 		- choiceEnemy(): 각 궁수가 제거할 적 구하기
 * 		- moveEnemy(): 적의 위치를 아래로 한칸 이동하기
 * @author MIRAE
 */

class pos {   // 위치 클래스
	int r, c;
	pos(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Solution_17135 {
	private static int N, M, D;                                // 행, 열, 공격거리
	private static List<pos> enemies = new ArrayList<pos>();   // 적의 위치를 담을 리스트
	private static List<pos> enemiesCopy;                      // 각 조합 시도 시 적의 위치를 복사할 리스트
	private static int[] archerPos = new int[3];               // 궁수 조합을 담을 배열
	private static int maxCount, intoCastle;                   // 제거한 적의 수, 성 안으로 들어온 적의 수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);   // 행
		M = Integer.parseInt(tmp[1]);   // 열
		D = Integer.parseInt(tmp[2]);   // 최대 공격거리
		
		// 격자판 입력 받기
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			tmp = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}	
		
		// 적의 위치 저장하기(가까운 적부터)
		for (int i = N-1; i >= 0; i--) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) enemies.add(new pos(i, j));
			}
		}
		
		// 궁수 위치 배치 및 게임 실행
		arrange(0, 0);  	
		// 결과값 출력
		System.out.println(maxCount);
	}
	// 궁수 위치 배치하기(조합), 게임 실행
	private static void arrange(int cnt, int start) {
		// 3명의 궁수 위치가 모두 선택되었을 때
		if (cnt == 3) {
			// 궁수 위치에 따라 제거하는 적을 파악하기 위해 적의 위치 배열 복사(적 위치 배열 초기화)
			enemiesCopy = new ArrayList<pos>();
			for (pos p : enemies) {
				enemiesCopy.add(new pos(p.r, p.c));
			}
			intoCastle = 0;      // 성 안으로 들어가는 적 수 초기화
			
			attack(archerPos);   // 제거할 적 선택하고 공격하기 
			
			maxCount = Math.max(maxCount, enemies.size()-intoCastle);  // 처음 적의 수에서 성 안으로 들어와서 제거하지 못한 적의 수를 빼서 제거한 적의 수 구하기
			return;
		}
		// 궁수 위치 선택하기
		for (int i = start; i < M; i++) {
			archerPos[cnt] = i;
			arrange(cnt+1, i+1);
		}
	}
	// D거리 이하 가장 가까운 적 공격하여 제거하기
	private static void attack(int[] arr) {
		// 적이 모두 제거될 때까지 실행
		while (!enemiesCopy.isEmpty()) {
			pos [] target = choiceEnemy(arr);         // 궁수가 제거할 적 구하기	
			
			for (int i = 0; i < target.length; i++) {  // disFromEnemy()를 통해 찾은 적 제거
				enemiesCopy.remove(target[i]);
			}
			
			moveEnemy();  // 적 아래로 한칸 이동
		}
	}
	// 각 궁수가 제거할 적 구하기
	private static pos[] choiceEnemy(int[] arr) {
		pos[] target = new pos[3];
		
		// 각 궁수의 적과의 최소 거리 계산하기
		for (int i = 0; i < arr.length; i++) {
			int distance = D+1;   // 최소 거리 저장
			int disC = N;         // 최소 거리에서의 c위치 값 저장(같은 거리일 때 왼쪽 위치 적 선택하기 위함)
			for (int j = 0; j < enemiesCopy.size(); j++) {
				int disTmp = Math.abs(enemiesCopy.get(j).r - N) + Math.abs(enemiesCopy.get(j).c - arr[i]);  // 적과의 거리 계산
				if (disTmp > D) continue;   // 적과의 거리가 최대 공격거리(D)를 넘어가면 pass
				if (distance > disTmp || (distance == disTmp && disC > enemiesCopy.get(j).c)) {   // 적과의 거리가 최소거리거나, 이전의 최소거리와 같으면 더 왼쪽에 위치할 때
					distance = disTmp;
					disC = enemiesCopy.get(j).c;
					target[i] = enemiesCopy.get(j);  // 제거해야할 타겟으로 저장
				}
			}
		}
		return target;
	}
	// 적 위치 이동하기
	private static void moveEnemy() {
		List<pos> into = new ArrayList<pos>();  // 성에 들어와서 제거 대상이 아닌 적을 담을 임시 리스트
		for (pos p : enemiesCopy) {
			p.r++;
			
			if (p.r == N) {        // 적이 성이 있는 칸으로 이동하면 제거 대상(enemiesCopy)에서 제외 예정
				into.add(p);
				intoCastle++;      // 성으로 들어온 적의 수 카운트
			}
		}
		for (pos p : into) {
			enemiesCopy.remove(p); // 제거 대상에서 성으로 들어온 적 삭제
		}
	}
}
