package set3_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// RGB거리 
public class P1149 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int dp[][] = new int[n][3];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<3; j++)
				dp[i][j] = Integer.parseInt(st.nextToken());
		}
		
//		dp[0] = arr[0];
		for(int i=1; i<n; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + dp[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + dp[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + dp[i][2];
		}
		
		int min = dp[n-1][0];
		for(int i=1; i<3; i++)
			min = Math.min(min, dp[n-1][i]);
		
		System.out.println(min);
	}
}
