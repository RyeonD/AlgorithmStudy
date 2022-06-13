package set3_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7576 {
	
	static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int n, m, matrix[][], cnt;
	static Queue <Point> q = new LinkedList<>();
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());	// x
		n = Integer.parseInt(st.nextToken());	// y
		
		matrix = new int[n][m];
		
		// 익지 않은 토마토의 개수를 카운트 하기위해 먼저 박스에 들어갈 수 있는 최대 토마토의 개수 구하기 
		cnt = n*m;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<m; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				
				if(matrix[i][j] == 1) q.add(new Point(j, i));
				if(matrix[i][j] != 0) cnt--;	// 토마토가 이미 익어있거나 없는 박스 칸은 토마토의 개수에서 제외 
			}
			
		}
		
		bfs();
		
	}
	
	public static void bfs() {
		int day = -1;	// 안 익었던 토마토가 익은 날만 계산해야하므로 처음에 익은 토마토가 있던 날을 계산에서 제외해주기위해 -1부터 
		
		while(!q.isEmpty()) {
			int size = q.size();
			day++;
			
			for(int i=0; i<size; i++) {
				Point p = q.poll();
				
				for(int j=0; j<dx.length; j++) {
					int col = p.x + dx[j];
					int row = p.y + dy[j];
					
					if(col >= 0 && col < m && row >= 0 && row < n && matrix[row][col] == 0) {
						matrix[row][col] = 1;
						q.add(new Point(col, row));
						cnt--;	// 안 익었던 토마토가 익은 경우 안 익은 토마토 개수에서 제외 
					}
						
				}
			}
		}
		
		// 안 익었던 토마토가 모두 익은 경우 cnt = 0
		if(cnt == 0) System.out.println(day);
		else System.out.println(-1);
	}
	
//	public static boolean isPossible(int x, int y) {
//		if(x >= 0 && x < m && y >= 0 && y < n)
//			return true;
//		
//		return false;
//	}
}
