package set3_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 미로 탐색
// dfs와 bfs의 시간복잡도 차이 
public class P2178 {

	static int n, m, matrix[][];
	static boolean visited[][];
	
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		matrix = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			String s[] = br.readLine().split("");
			
			for(int j=0; j<m; j++)
				matrix[i][j] = Integer.parseInt(s[j]);
		}
		
		System.out.println(bfs(0,0));
	}
	
	public static int bfs(int x, int y) {
		int level = 1;
		
		Queue <int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i=0; i<size; i++) {
				int point[] = queue.poll();
			
				if(point[0] == n-1 && point[1] == m-1)
					return level;
				
				for(int j=0; j<dx.length; j++) {
					int nx = point[0] + dx[j];
					int ny = point[1] + dy[j];
					
					if(isPossible(nx, ny)) {
						visited[nx][ny] = true;
						queue.add(new int[] {nx, ny});
					}
				}
			}
			
			level++;
		}
		
		return level;
	}
	
	public static boolean isPossible(int x, int y) {
		if(x >= 0 && x < n && y >= 0 && y < m && !visited[x][y] && matrix[x][y] == 1)
			return true;
		return false;
	}
}
