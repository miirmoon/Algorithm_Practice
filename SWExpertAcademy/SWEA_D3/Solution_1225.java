package com.miirmoon.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * SWEA 1225. 암호생성기
 * Date: 2021. 8. 5.
 * Solution: 큐를 이용해서 암호만드는 작업하기
 * @author MIRAE
 */

public class Solution_1225 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> num = new LinkedList<Integer>();
		
		for (int tc = 1; tc <= 10; tc++) {
            br.readLine(); // 테스트케이스 번호 읽어들이기
            num.clear();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
             
            for (int i = 0; i < 8; i++) {
                num.offer(Integer.parseInt(st.nextToken()));
            }
         
            int count = 1;
             
            while (true) {
                int cal = num.poll()-count;
                if (cal <= 0) {
                    num.offer(0);
                    break;
                }
                num.offer(cal);         
                if (++count >= 6) count = 1;
            }
             
            System.out.print("#" + tc + " ");
            for (int n: num) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
	}
}
