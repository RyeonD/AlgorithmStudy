package set2_1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 부분 수열의 합 
public class P1182 {

	private static int MAX_N = 20;
	private static int n, s, ret;
	private static int arr[] = new int[MAX_N];
	private static boolean check[] = new boolean[MAX_N];
	
	private static void dfs(int cnt, int index, int sum) {
		if(cnt != 0 && sum == s) {
			ret++;
		}
		
		if(cnt == n)
			return;
		
		
		for(int i=index; i<n; i++) {
			check[i] = true;
			dfs(cnt+1, i+1, sum+arr[i]);
			check[i] = false;
		}
	}
	
	private static void dfs2(int index, int sum) {
		if(index == n) {
			if(sum == s)
				ret++;
			
			return;
		}
		
		dfs2(index+1, sum);
		dfs2(index+1, sum+arr[index]);
	}
	
	public static void main(String args[]) throws Exception {
		
		System.setIn(new FileInputStream("res/p1182.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		ret = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
//			check[i] = false;
		}
		
		// 두개 결과 비슷함 
//		dfs(0, 0, 0);
		dfs2(0, 0);
		
		if(s == 0) ret--;
		
		System.out.println(ret);
	}
}
