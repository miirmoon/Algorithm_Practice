package com.miirmoon.bj1000;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * BeakJoon 1158. 요세푸스 문제
 * Date: 2021. 8. 10.
 * Solution: 연결리스트 이용해서 데이터를 삭제하면서 인덱스 맞춰주기
 * @author MIRAE
 */

public class Solution_1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> list = new LinkedList<Integer>();
		LinkedList<Integer> result = new LinkedList<Integer>();
		
		int N = sc.nextInt();
		int K = sc.nextInt() - 1;
		
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		
		int index = K;
		while (!list.isEmpty()) {
			result.add(list.remove(index));
			if (list.isEmpty()) break;
			index = (index+K) % list.size();  // 인덱스가 리스트 크기를 넘어가면 리스트 내의 인덱스로 바꿔주기
		}
		System.out.print("<" + result.get(0));
		for (int i = 1; i < result.size(); i++) {
			System.out.print(", " + result.get(i));
		}
		System.out.println(">");
		
		sc.close();
	}
}
