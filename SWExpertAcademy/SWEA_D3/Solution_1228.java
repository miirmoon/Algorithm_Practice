package com.miirmoon.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * SWEA 1228. 암호문1
 * Date: 2021. 8. 9.
 * Solution: 연결리스트를 이용해서 원하는 x의 위치에 y개의 문자 삽입하여 수정된 암호문 만들기
 * @author MIRAE
 */

public class Solution_1228 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			LinkedList<String> list = new LinkedList<String>();
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				list.add(st.nextToken());
			}
			br.readLine(); // 명령어 개수 읽어내기
			st = new StringTokenizer(br.readLine(), " ");
			
			int index = 0;
			int count = 0;
			
			while (st.hasMoreTokens()) {
				st.nextToken(); // I 읽어내기
				index = Integer.parseInt(st.nextToken());
				count = Integer.parseInt(st.nextToken());
				
				for (int i = 0; i < count; i++) {
					list.add(index, st.nextToken());   // index 위치부터 count개의 문자열 추가하기
					index++;
				}
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < 10; i++) {            // 수정된 암호문에서 처음 10개 항 출력하기
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
	}
}
