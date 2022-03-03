package set2_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// N-Queen
public class P9663 {
	// input 8 output 92
	private static int n, ret;
	private static int board[];
	
	public static boolean promising(int index) {
		for(int i=0; i<index; i++) {
			if(board[index] == board[i] || index-i == Math.abs(board[index]-board[i]))
				return false;
		}
		
		return true;
	}
	
	public static void dfs(int cnt) {
		if(cnt == n){
			ret++;
			return;
		}
		
		for(int i=0; i<n; i++) {
			board[cnt] = i;
			
			if(promising(cnt))
				dfs(cnt+1);
		}
	}
	
	public static void main(String args[]) throws Exception {
		// 입력 파일X
		// 입력 값 8 - 출력 값 92
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ret = 0;
		
		board = new int[n];
		
		dfs(0);
		
		System.out.println(ret);
	}
}
