package set3_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 문제 review
public class P2606_r {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		boolean path[][] = new boolean[n+1][n+1];
		boolean visited[] = new boolean[n+1];
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int com1 = Integer.parseInt(st.nextToken());
			int com2 = Integer.parseInt(st.nextToken());
			
			path[com1][com2] = path[com2][com1] = true;
		}
		
		Stack <Integer> stack = new Stack<>();
		stack.add(1);
		
		int cnt = 0;
		while(!stack.isEmpty()) {
			int curr = stack.pop();		
			
			for(int i=2; i<=n; i++) {
				if(path[curr][i] && !visited[i]) {
					stack.push(i);
					visited[i] = true;
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
