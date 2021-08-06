package com.miirmoon.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * SWEA 1218. 괄호 짝짓기
 * Date: 2021. 8. 6.
 * Solution: 스택을 이용하여 괄호가 짝에 맞게 잘 매칭이 되는지 확인하기
 * @author MIRAE
 */

public class Solution_1218 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int tc = 1; tc <= 10; tc++)
		{
			Stack<Character> stack = new Stack<Character>();
			int result = -1;
			br.readLine();    // N 읽어내기
			char[] arr = br.readLine().toCharArray();
			
			for (char c: arr) {
				if ("({[<".contains(String.valueOf(c))) {
					stack.push(c);
					continue;
				} else {   // 닫는 괄호 일 때 스택이 비어있거나(여는 괄호 없음) 여는괄호와 매칭이 되지 않으면 유효하지 않음
					if (stack.isEmpty() || ")}]>".indexOf(String.valueOf(c)) != "({[<".indexOf(stack.peek())) {
						result = 0;
						break;
					}
					stack.pop();
				}
			}
			if (stack.isEmpty() && result == -1) result = 1;
			
			System.out.println("#" + tc + " " + result);
		}
	}
}
