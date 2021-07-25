package com.miirmoon.swea.d1;

/**
 * SWEA 2056. 연월일 달력
 * Date: 2021. 7. 25.
 * @author MIRAE
 */

import java.util.Scanner;

public class Solution_2056 {
	static int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();

		for(int tc = 1; tc <= T; tc++)
		{
			int date = sc.nextInt();
			int year = date / 10000;
			int month = (date/100) % 100;
			int day = date % 100;
			
			// 월이 1~12의 범위를 벗어나면 결과값(-1)을 출력하고 다음 testcase로 넘어감
			if (month < 1 || month > 12) {
				System.out.println("#" + tc + " -1");
				continue;
			}
			// 날짜가 해당 월의 날짜 범위를 벗어나면 결과값(-1)을 출력하고 다음 testcase로 넘어감
			if (day > days[month] || day < 1) {
				System.out.println("#" + tc + " -1");
				continue;
			}
			// 월과 날짜가 정상적인 범위 안에 있을 때 실행됨
			// year가 3자리수 또는 month와 day가 한자리 수일때 앞에 0을 붙여줌
			String strYear = (year < 1000) ? "0"+year : String.valueOf(year);
			String strMonth = (month < 10) ? "0"+month : String.valueOf(month);
			String strDay = (day < 10) ? "0"+day : String.valueOf(day);
					
			System.out.println("#" + tc + " " + strYear + "/" + strMonth + "/" + strDay);
		}
		sc.close();
	}
}
