package com.miirmoon.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_3499 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Queue<String> left, right;
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			left = new LinkedList<String>();
			right = new LinkedList<String>();
			
			// 왼쪽 카드 덱 만들기
			for (int i = 0; i < N/2; i++) {
				left.offer(st.nextToken());
			}
			if (N % 2 == 1) left.offer(st.nextToken());
			
			// 오른쪽 카드 덱 만들기: 남은 카드 다 넣기
			while (st.hasMoreTokens()) right.offer(st.nextToken());
			
			System.out.print("#" + tc + " ");
			// 셔플하여 출력하기: 카드 개수가 홀수일 경우 왼쪽이 하나 더 많으므로 왼쪽만 검사
			while (!left.isEmpty()) {
				System.out.print(left.poll() + " ");
				if (right.isEmpty()) break;  // 카드 개수가 홀수일 경우 마지막 턴에선 오른쪽에 값이 없으므로 중단
				System.out.print(right.poll() + " ");
			}
			System.out.println();
		}
	}
}
