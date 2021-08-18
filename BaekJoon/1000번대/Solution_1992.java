package com.miirmoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * BaekJoon 1992. 쿼드트리
 * Date: 2021. 8. 18.
 * @author MIRAE
 */

public class Solution_1992 {
	private static char[][] image;
	private static ArrayList<Character> result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		image= new char[N][];
		result = new ArrayList<Character>();
		
		for (int i = 0; i < N; i++) {
			image[i] = br.readLine().toCharArray();
		}
		compress(0, 0, N);
		for (char c : result) {
			System.out.print(c);
		}
	}
	private static void compress(int x, int y, int len) {		
		char check = image[x][y];
		boolean same = true;
		int half = len / 2;
		// 전체 영상을 검사해보기
		outer: for (int i = x; i < x+len; i++) {
			for (int j = y; j < y+len; j++) {
				if (image[i][j] != check) {
					same = false;	
					break outer;
				}
			}
		}
		// 검사를 시작한 첫 원소(same)와 다른 원소가 있으면(false) 4등분해서 다시 검사
		if (same == false) {
			result.add('(');
			compress(x, y, half);           // 1사분면(왼쪽 위)
			compress(x, y+half, half);      // 2사분면(오른쪽 위)
			compress(x+half, y, half);      // 3사분면(왼쪽 아래)
			compress(x+half, y+half, half); // 4사분면(오른쪽 아래)
			result.add(')');
		} else { // 다른 원소가 없으면(true) 결과 리스트에 추가
			result.add(check);		
		}
	}
}
