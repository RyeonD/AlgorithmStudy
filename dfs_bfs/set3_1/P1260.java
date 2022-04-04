package set3_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// dfs와 bfs
public class P1260 {
	
	static int matrix[][];
	static boolean visited[];
	static int n, m;
	static StringBuilder sb = new StringBuilder();
	static Queue <Integer> queue = new LinkedList<>();

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		matrix = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			matrix[v1][v2] = matrix[v2][v1] = 1;
		}
		
		dfs(start);
		sb.append("\n");
		
		for(int i=0; i<=n; i++)
			visited[i] = false;
		bfs(start);
		
		System.out.println(sb.toString());
	}
	
	// visited 체크와 출력을 어디서 해주냐에 따라 달라짐..
	public static void dfs(int start) {
		visited[start] = true;
		sb.append(start).append(" ");
		
		for(int i=1; i<=n; i++) {
			if(matrix[start][i] == 1 && !visited[i]) {
				dfs(i);	
			}
		}
	}
	
	public static void bfs(int start) {
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int v = queue.poll();
			sb.append(v).append(" ");
			
			for(int i=1; i<=n; i++) {
				if(matrix[v][i] == 1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
}
