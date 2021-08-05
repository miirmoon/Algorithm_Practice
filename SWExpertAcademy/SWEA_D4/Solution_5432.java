package com.miirmoon.swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * SWEA 5432. 쇠막대기 자르기
 * Date: 2021. 8. 5.
 * Solution: 막대기를 자르는 시점에 있는 막대기 수(스택의 '(' 수)와 막대기 길이가 끝날 때(바로 전 기호가 ')'인 ')') 끄트머리 수를 합산하여 구한다.
 * @author MIRAE
 */

public class Solution_5432 {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int count;

		for(int tc = 1; tc <= T; tc++)
		{
			String stick = br.readLine();
			Stack<Character> stack = new Stack<Character>();
			count = 0;
			
			for (int i = 0; i < stick.length(); i++) {
				if (stick.charAt(i) == '(') {
					stack.push('(');
				} else {           //  ')'
					stack.pop();
					if (stick.charAt(i-1) == '(') count += stack.size();  // 자르기 전에 생성되어있는 막대 수 합산
					else count++;  //  ')' 막대기 끄트머리 수 합산
				}
			}			
			System.out.println("#" + tc + " " + count);
		}
	}
}
