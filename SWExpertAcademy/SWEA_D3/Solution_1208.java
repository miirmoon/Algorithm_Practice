package com.miirmoon.swea.d3;

import java.util.Scanner;

/**
 * SWEA 1208. Flatten
 * Date: 2021. 8. 3.
 * Solution: 각 덤프를 반복하면서 높이가 가장 높은 값은 높이를 하나 낮추고, 가장 낮은 값은 높이를 하나 높인다.
 * @author MIRAE
 */

public class Solution_1208 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int tc = 1; tc <= 10; tc++)
		{
			int dump = sc.nextInt();
			int[] height = new int[100];
			int max, min;
			int maxIndex = 0;
			int minIndex = 0;
			
			for (int i = 0; i < 100; i++) {
				height[i] = sc.nextInt();
			}
			
			// 덤프 횟수가 끝난 후 높이가 가장 높은 값과 낮은 값을 구하기 위해 j <= dump처리
			for (int j = 0; j <= dump; j++) {
				// 상자의 높이가 가장 높은 값, 낮은 값 구하기
				max = 0;
				min = 101;
				for (int a = 0; a < height.length; a++) {
					if (height[a] > max) {
						max = height[a];
						maxIndex = a;
					}
					if (height[a] < min) {
						min = height[a];
						minIndex = a;
					}
				}
				// 가장 높은 위치와 가장 낮은 위치의 차이가 1 이내이거나 j == dump이면 횟수를 모두 끝낸 후 추가작업을 한 상태이므로 중단
				if (height[maxIndex] - height[minIndex] <= 1 || j == dump) break;
				// 가장 높은 위치에서 가장 낮은 위치로 상자 하나 옮기기
				height[maxIndex]--;
				height[minIndex]++;
			}	
			System.out.println("#" + tc + " " + (height[maxIndex] - height[minIndex]));
		}

		sc.close();
	}
}
