package com.miirmoon.bj2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * BeakJoon 2493. 탑
 * Date: 2021. 8. 5.
 * Solution: 스택활용, 현재 탑과 이전의 탑들을 비교하여 더 작은 탑은 pass, 더 큰 탑의 인덱스를 가져온다.
 * 		- 시간초과가 발생하지 않도록 구현하기
 * @author MIRAE
 */

public class Solution_2493 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer.parseInt(br.readLine());   // N의 값 읽어내기
		Stack<int[]> stack = new Stack<int[]>();
		int index = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while (st.hasMoreTokens()) {
			int curTower = Integer.parseInt(st.nextToken());
			index++;
			
			while (true) {
				// 스택이 비어있으면 현재 탑의 앞에 수신할 탑이 없는 것이므로 인덱스와 탑의 높이로 이루어진 int배열를 추가하고 0 출력
				if (stack.isEmpty()) {
					stack.push(new int[]{index, curTower}); 
					System.out.print("0 ");
					break;
				}
				// 현재 탑이 스택에 있는 top보다 크면 스택의 탑은 현재 탑 이후의 신호를 받을 수 없으므로 pop하여 삭제
				// 현재 탑이 스택에 있는 top보다 작으면 스택의 탑의 현재 탑의 신호를 받는 것이므로 해당 인덱스를 출력
				// 현재 탑은 다음에 올 탑의 신호를 수신할 수도 있으므로 스택에 추가
				if (curTower > stack.peek()[1])	stack.pop();
				else {
					System.out.print(stack.peek()[0] + " ");
					stack.push(new int[]{index, curTower});
					break;
				}
			}
		}
	}
}
