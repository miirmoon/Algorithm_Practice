package com.miirmoon.bj1000;

import java.util.Scanner;

/**
 * BaekJoon 1244. 스위치 켜고 끄기
 * Date: 2021. 8. 2.
 * Solution: 문제 내용 그대로 풀면 됨!
 * @author MIRAE
 */

public class Solution_1244 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] switchArr = new int[sc.nextInt()];   // 스위치 상태 배열(크기는 스위치 개수)
		int student, gender, num;                  // 학생 수, 성별, 학생이 받은 숫자
		
		// 입력받은 스위치 현재 상태 저장하기
		for (int i = 0; i < switchArr.length; i++) {
			switchArr[i] = sc.nextInt();
		}
		
		student = sc.nextInt();
		for (int j = 0; j < student; j++) {
			gender = sc.nextInt();
			num = sc.nextInt();
			
			if (gender == 1) {       // 남학생일때
				for (int a = num-1; a < switchArr.length; a += num) {
					switchArr[a] = switchArr[a] == 1 ? 0 : 1;       // 받은 번호의 배수에 해당하는 위치의 스위치 상태 바꾸기
				}
			} else {                 // 여학생일때
				switchArr[num-1] = switchArr[num-1] == 1 ? 0 : 1;   // 받은 번호 위치의 스위치 상태 바꾸기
				int left = num-1;
				int right = num-1;
				while(true) {
					left--;      // 받은 번호 기준 왼쪽 인덱스
					right++;     // 받은 번호 기준 오른쪽 인덱스
					if (left < 0 || left >= switchArr.length || right < 0 || right >= switchArr.length) break;  // 인덱스가 배열 범위를 벗어나면 중단
							
					if(switchArr[left] != switchArr[right]) break;  // 서로 대칭이 되지 않으면 중단
					
					switchArr[left] = switchArr[left] == 1 ? 0 : 1;
					switchArr[right] = switchArr[right] == 1 ? 0 : 1;
					
				}
			}
		}
		for (int i = 0; i < switchArr.length; i++) { 
			System.out.print(switchArr[i] + " ");
			if ((i+1) % 20 == 0)         // 한줄에 20개씩 출력하기
				System.out.println();
		}
		sc.close();
	}
}
