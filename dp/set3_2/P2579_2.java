package set3_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 계단 오르기 (최대값 구하기) 
public class P2579_2 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n+1];
		int dp[] = new int[n+1];
		
		for(int i=1; i<=n; i++) 
			arr[i] = Integer.parseInt(br.readLine());
		
		// 0 < n <= 300 
		dp[1] = arr[1];
		
		// 최대값 구하는 것이므로 1,2계단의 값 합하기 
		if(n > 1)
			dp[2] = arr[1] + arr[2];
		
		for(int i=3; i<=n; i++) {
			// 2연속 밟으면 해당 위치 못 밟음,,,
			// 하지만 마지막을 꼭 밟아야 하기 때문에 해당 위치는 꼭 밟을 수 있도록 해야함
			// 해당 위치를 꼭 밟으려면 앞선 2개의 칸 중 하나만 밟아야함 -> 하나는 밟고, 하나는 안 밟고..
			// i-2를 안 밟는 경우 -> dp[i-3] + arr[i-1]
			// i-1를 안 밟는 경우 -> dp[i-2]
			dp[i] = Math.max(dp[i-3]+arr[i-1], dp[i-2]) + arr[i];
		}
	}
}
