package com.miirmoon.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * SWEA 1223. [S/W 문제해결 기본] 계산기2
 * Date: 2021. 8. 20.
 * @author MIRAE
 */

public class Solution_1223 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();   // 테스트 케이스의 길이 읽어내기
			String str = br.readLine();
			
			System.out.println("#" + tc + " " + calculate(changePostfix(str)));
		}
	}
	// 후위 연산으로 변경하기
	private static String changePostfix(String str) {
		Stack<Character> stack = new Stack<Character>();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '+') {   // '+'연산자일 때 지금까지 입력된 stack 모두 비우기
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				stack.push('+');
				continue;
			} 
			if (str.charAt(i) == '*') {  // '*'연산자일 때 '*' 연산자 꺼내기
				if (!stack.isEmpty() && stack.peek() == '*') {
					sb.append(stack.pop());
				}
				stack.push('*');
				continue;
			}
			sb.append(str.charAt(i));  // 숫자일 때 결과 문자열에 저장하기
		}
		while (!stack.isEmpty()) {  // 문자열의 모든 요소에 대한 처리가 끝나면 stack 비우기
			sb.append(stack.pop());
		}
		return sb.toString();
	}
	// 후위 연산으로 입력된 문자열 계산하기
	private static int calculate(String str) {
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = 0; i < str.length(); i++) {  
			if (str.charAt(i) == '+') {  // '+' 연산자이면 stack에서 두 개의 수를 뽑아 + 연산하기
				stack.push(stack.pop() + stack.pop());
				continue;
			} 
			if (str.charAt(i) == '*') {  // '*' 연산자이면 stack에서 두 개의 수를 뽑아 * 연산하기
				stack.push(stack.pop() * stack.pop());
				continue;
			}
			stack.push(str.charAt(i)-48);  // 숫자이면 int형으로 변경하여 stack에 넣기
		}
		return stack.pop();
	}
}
