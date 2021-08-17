package com.miirmoon.jo1800;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Jungol 1828. 냉장고
 * Date: 2021. 8. 17.
 * Solution: 최저 온도 기준으로 오름차순 정렬하여, 현재 냉장고의 최고 온도와 다음 물질의 최저 온도 비교를 통해 필요한 냉장고의 수를 구한다.
 * @author MIRAE
 */

public class Solution_1828 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Temper[] temper = new Temper[N];
		for (int i = 0; i < N; i++) {
			temper[i] = new Temper(sc.nextInt(), sc.nextInt());
		}
		
		Arrays.sort(temper);
		
		Temper current = temper[0];
		int count = 1;
		for (int i = 1; i < N; i++) {
			// 현재 냉장고에 담을 수 있는 최고 온도보다 다음 물질의 최저온도가 높으면 다른 냉장고에 담아야 함
			if (current.maxTemper < temper[i].minTemper) {
				count++;
				current = temper[i];
				continue;
			}
			// 현재 냉장고에 담을 수 있는 최고 온도보다 다음 물질의 최고 온도가 낮으면 현재 냉장고의 가능한 온도를 더 작은 범위로 잡아주기
			if (current.maxTemper > temper[i].maxTemper) current = temper[i];
		}
		System.out.println(count);
		sc.close();
	}
}

class Temper implements Comparable<Temper>{
	int minTemper;
	int maxTemper;
	
	Temper(int minTemper, int maxTemper) {
		this.minTemper = minTemper;
		this.maxTemper = maxTemper;
	}

	@Override
	public int compareTo(Temper o) {
		if (this.minTemper - o.minTemper == 0) 
			return this.maxTemper - o.maxTemper;
		return this.minTemper - o.minTemper;
	}
}
