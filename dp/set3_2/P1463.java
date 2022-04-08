package set3_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1463 {

	static int n, dp[];
	
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		
		for(int i=n; i>1; i--) {
			if(i%2 == 0)
				value_change(i/2, dp[i]+1);
				
			if(i%3 == 0)
				value_change(i/3, dp[i]+1);
				
			value_change(i-1, dp[i]+1);
		}
		
		System.out.println(dp[1]);
	}
	
	public static void value_change(int num, int cnt) {
		if(dp[num] == 0)
			dp[num] = cnt;
		else {
			dp[num] = Math.min(dp[num], cnt);
		}
	}
}
