package com.miirmoon.swea.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * SWEA 5644. [모의 SW 역량테스트] 무선 충전
 * Date: 2021. 8. 18.
 * @author MIRAE
 */

class BC {     // BC(Battery Charger) 정보를 저장하기 위한 클래스
	int x, y, c, p;
	BC(int x, int y, int c, int p) {
		this.x = x;
		this.y = y;
		this.c = c;
		this.p = p;
	}
}
class Person { // 사용자의 위치 정보를 저장하기 위한 클래스
	int x, y;

	public Person(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Solution_5644 {
	private static BC[] BC;
	private static int[] moveA, moveB;
	private static int[] dx = {0, -1, 0, 1, 0};
	private static int[] dy = {0, 0, 1, 0, -1}; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {;
			// 필요한 정보 입력 받기
			String[] tmp = br.readLine().split(" ");
			int M = Integer.parseInt(tmp[0]);  // 총 이동 시간
			int A = Integer.parseInt(tmp[1]);  // BC의 개수
			
			moveA = new int[M+1];  // A이동정보
			moveB = new int[M+1];  // B이동정보
			
			// A의 이동 정보
			tmp = br.readLine().split(" ");
			for (int i = 1; i <= M; i++) {
				moveA[i] = Integer.parseInt(tmp[i-1]);
			}
			// B의 이동 정보
			tmp = br.readLine().split(" ");
			for (int i = 1; i <= M; i++) {
				moveB[i] = Integer.parseInt(tmp[i-1]);
			}
			// BC 관련 정보
			BC = new BC[A];
			for (int i = 0; i < A; i++) {
				tmp = br.readLine().split(" ");
				// 문제에서 사용하는 x, y와 배열에서 사용하는 x, y가 반대로 되어있으므로 바꿔서 저장
				BC[i] = new BC(Integer.parseInt(tmp[1]), Integer.parseInt(tmp[0]), Integer.parseInt(tmp[2]), Integer.parseInt(tmp[3]));
			}
			// BC 정보를 성능이 좋은 순으로 정렬하기
			Arrays.sort(BC, (o1, o2) -> o2.p - o1.p);
			
			System.out.println("#" + tc + " " + solve());
		}
	}
	private static int solve() {
		Person pA = new Person(1, 1);             // A의 위치
		Person pB = new Person(10, 10);           // B의 위치
		ArrayList<BC> bcA = new ArrayList<BC>();  // A 위치에 영향을 주는 bc
		ArrayList<BC> bcB = new ArrayList<BC>();  // B 위치에 영향을 주는 bc
		int total = 0;
		
		for (int i = 0; i < moveA.length; i++) {
			// 사용자 이동
			pA.x += dx[moveA[i]];
			pA.y += dy[moveA[i]];
			pB.x += dx[moveB[i]];
			pB.y += dy[moveB[i]];
			
			bcA.clear();
			bcB.clear();
			
			// A, B위치에 영향을 주는 BC 찾기
			findBC(bcA, pA);
			findBC(bcB, pB);
			
			// A위치에서 성능이 가장 큰 BC와 B위치에서 성능이 가장 큰 BC가 같은 경우
			if (bcA.size() != 0 && bcB.size() != 0 && (bcA.get(0).x == bcB.get(0).x) && (bcA.get(0).y == bcB.get(0).y)) {
				// 같은 BC가 A와 B에서 유일하면 반으로 나뉘므로 결국 합은 동일하고, 다른 BC가 있어도 성능이 가장 크므로 무조건 선택됨
				total += bcA.get(0).p;
				// 같은 BC 외에 A 또는 B에 다른 BC가 있으면 추가로 합산
				if (bcA.size() > 1 && bcB.size() > 1) total += Math.max(bcA.get(1).p, bcB.get(1).p);
				else if (bcA.size() > 1) total += bcA.get(1).p;
				else if (bcB.size() > 1) total += bcB.get(1).p;
				continue;
			}
			// 각 위치에서 성능이 가장 큰 BC가 서로 다르면 각각 합산
			if (bcA.size() != 0) total += bcA.get(0).p;
			if (bcB.size() != 0) total += bcB.get(0).p;
		}
		return total;
	}
	// 사용자의 위치에 영향을 주는 BC 찾기
	private static void findBC(ArrayList<BC> list, Person p) {
		for (BC b: BC) {
			if (b.c >= Math.abs(p.x - b.x) + Math.abs(p.y - b.y))
				list.add(b);
			// 사용자가 2명이기 때문에 최선책 또는 차선책까지만 선택될 수 있으므로 2개까지만 구함
			if (list.size() == 2) break;
		}
	}
}
