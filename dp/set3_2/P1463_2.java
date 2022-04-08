package set3_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 1로 만들기 
public class P1463_2 {

static int n, dp[];
	
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		
		for(int i=2; i<=n; i++) {
			if(i%2 == 0) possible(i, dp[i/2]);
			if(i%3 == 0) possible(i, dp[i/3]);
			possible(i, dp[i-1]);
		}
		
		System.out.println(dp[n]);
	}
	
	public static void possible(int num, int cnt) {
		if(dp[num] != 0)
			dp[num] = Math.min(dp[num], cnt+1);
		else
			dp[num] = cnt+1;
	}
}
