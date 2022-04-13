package set3_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 정수 삼격형 
public class P1932 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n][n];
		int dp[][] = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<=i; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		dp[n-1] = arr[n-1];
		for(int i=n-2; i>=0; i--) {
			for(int j=0; j<=i; j++) 
				dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]) + arr[i][j];
		}
		
		System.out.println(dp[0][0]);
	}
}
