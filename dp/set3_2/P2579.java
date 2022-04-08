package set3_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 계단 오르기 
public class P2579 {
	
	static int n, stairs[], dp[];
	static boolean visited[];

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		stairs = new int[n+1];
		dp = new int[n+1];
		
		for(int i=1; i<=n; i++)
			stairs[i] = Integer.parseInt(br.readLine());
		
		dp[1] = stairs[1];
		
		if(n >= 2) {
			dp[2] = stairs[1] + stairs[2];
		}
		
		for(int i=3; i<=n; i++) {
			// i-3, i-2, i-1, i
			// 현재 i위치에서 얻을 수 잇는 점수 + i-2까지 계산한 값 (or i-3까지 계산한 값 + i-1에서 얻을 수 잇는 점수)
			// 1) i-1을 건너 뛰는 경우 => i-2까지 계산한 값
			// 2) i-2를 건너 뛰는 경우  => i-3까지 계산한 값 + i-1에서 얻을 수 잇는 점수 
			dp[i] = Math.max(dp[i-2], dp[i-3]+stairs[i-1]) + stairs[i];
		}
		
		System.out.println(dp[n]);
	}
}
