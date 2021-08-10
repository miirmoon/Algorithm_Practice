package com.miirmoon.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * SWEA 1220. Magnetic
 * Date: 2021. 8. 10.
 * Solution: 교착상태 개수 구하기: 1과 2가 1-2 순으로 만나면 하나의 교착상태가 됨
 * @author MIRAE
 */

public class Solution_1220 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			String[][] table = new String[100][];
			br.readLine();   // 한 변의 길이 읽어내기
			int count = 0;   // 교착상태 개수
			
			for (int n = 0; n < 100; n++) {
				table[n] = br.readLine().split(" ");
			}
			
			for (int y = 0; y < 100; y++) {
				String pre = "0";
				for (int x = 0; x < 100; x++) {
					switch(table[x][y]) {
					case "0": break;
					case "1": pre = "1"; break;
					case "2":    // 현재 자석이 2일 때 전 자석이 1이었으면 교착상태+1
						if (pre.equals("1")) {
							pre = "2";
							count++;
						}
						break;
					}
				}
			}
			
			System.out.println("#" + tc + " " + count);
		}
	}
}
