package set3_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 바이러스
// dfs와 bfs 구분!
public class P2606 {
	
	static int n, m;
	static boolean pair[][], visited[];

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		pair = new boolean [n+1][n+1];
		visited = new boolean[n+1];
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int computer1 = Integer.parseInt(st.nextToken());
			int computer2 = Integer.parseInt(st.nextToken());
			
			pair[computer1][computer2] = pair[computer2][computer1] = true; 
		}
		
		System.out.println(dfs(1));
	}
	
	public static int dfs(int number) {
		int cnt = 0;
		
		Stack <Integer> stack = new Stack<>();
		stack.add(number);
		visited[number] = true;
		
		while(!stack.isEmpty()) {
			int curr = stack.pop();
			
			for(int i=1; i<=n; i++) {
				if(!visited[i] && pair[curr][i]) {
					stack.push(i);
					visited[i] = true;
					cnt++;
				}
			}
		}
		
		return cnt;
	}
}
