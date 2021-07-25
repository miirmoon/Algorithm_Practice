package com.miirmoon.swea.d2;

import java.util.Scanner;

/**
 * SWEA 1204. 최빈수 구하기
 * Date: 2021. 7. 25.
 * @author MIRAE
 */
public class Solution_1204 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		// 점수 자체를 점수배열(score)의 인덱스로 보고 해당하는 점수(인덱스)의 값을 증가시켜 카운트한다.
		// score[점수] = 점수를 받은 학생의 수
		for(int tc = 1; tc <= T; tc++)
		{
			sc.nextInt();                  // 테스트케이스 번호를 입력받으므로 하나 읽어들임
			int[] score = new int[101];    // 0이상 100이하의 점수이므로 101 크기의 배열 생성
			int max = 0, scoreIdx = 0;     // 학생 수의 최대값과 해당 점수(인덱스)를 구하기 위한 변수 초기화
			
			for (int i = 0; i < 1000; i++) {  // 점수별 개수 카운트
				score[sc.nextInt()]++;
			}
			for (int j = 0; j < score.length; j++) {  // 가장 많은 학생이 받은 점수(최빈수)가 무엇인지 확인하기
				if (max <= score[j]) {                // 최빈수가 여러개인 경우 더 큰 점수를 출력해야므로 max와 같을 때도 처리
					max = score[j];
					scoreIdx = j;
				}
			}
			System.out.println("#" + tc + " " + scoreIdx);
		}
		sc.close();
	}
}
