package com.miirmoon.swea.d3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * SWEA 1208. Flatten
 * Date: 2021. 8. 3.
 * Solution: version2. 정렬을 사용하는 방법
 * 	덤프작업 매회 정렬 함수를 사용할 경우 시간이 많이 소요되기 때문에 1회 정렬 후에는 비교연산을 통해 해결하였다.
 * @author MIRAE
 */

public class Solution_1208_version2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] height = new int[100];
		
		for (int tc = 1; tc <= 10; tc++) {
			int dump = sc.nextInt();
			int min = 0, max = 99;
			
			// 각 상자의 높이 받아오기
			for (int i = 0; i < 100; i++) {
				height[i] = sc.nextInt();
			}
			
			// 상자를 높이 오름차순으로 정렬
			Arrays.sort(height); 
			
			// dump만큼 덤프(가장 높은 곳의 상자를 가장 낮은 곳으로 옮기는 작업) 실시
			for (int i = 0; i < dump; i++) {
				if (height[max] - height[min] <= 1) break;
				
				height[max]--;
				height[min]++;
				
				if (height[min] > height[min+1]) min++;
				else min = 0;

				if (height[max] < height[max-1]) max--;
				else max = 99;
			}
			
			System.out.println("#" + tc + " " + (height[max] - height[min]));
		}
	}
}
