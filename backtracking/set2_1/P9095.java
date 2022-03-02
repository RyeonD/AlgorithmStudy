package set2_1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class P9095 {
	
	private static int test_case, target, ret;
	
	// dp[i] = 숫자 1,2,3을 더해서 i를 만들수 있는 방법의 개수 
	private static int dp[] = new int[11];

	public static void dfs(int sum) {
		if(sum == target) {
			ret++;
			return;
		}
		
		if(sum > target)
			return;
		
		dfs(sum+1);
		dfs(sum+2);
		dfs(sum+3);
	}
	
	public static void main(String args[]) throws Exception {
		
		System.setIn(new FileInputStream("res/p9095.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		test_case = Integer.parseInt(br.readLine());
		
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i=0; i<test_case; i++) {
			target = Integer.parseInt(br.readLine());
//			ret = 0;
			
//			dfs(0);

			for(int j=4; j<=target; j++) {
				dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
			}
			
			
			System.out.println(dp[target]);
		}
	}
}
