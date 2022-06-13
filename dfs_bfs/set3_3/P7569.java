package set3_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1번 방법 
// m x n x h 값에서 익은 토마토와 빈공간을 뺀 값에서, 익지 않은 토마토 개수를 빼가며 카운트하는 방법 
public class P7569 {

	static class Point {
		int m, n, h;
		public Point(int m, int n, int h) {
			this.m = m;
			this.n = n;
			this.h = h;
		}
	}
	
	static int m, n, h, box[][][], cnt;
	static Queue <Point> q = new LinkedList<>();
	
	static int dx[] = {1, -1, 0, 0, 0, 0};
	static int dy[] = {0, 0, 1, -1, 0, 0};
	static int dz[] = {0, 0, 0, 0, 1, -1};
	
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		box = new int[h][n][m];
		cnt = m*n*h;
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				st = new StringTokenizer(br.readLine());
				
				for(int k=0; k<m; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if(box[i][j][k] == 1)
						q.add(new Point(k, j, i));
					
					if(box[i][j][k] != 0)
						cnt--;
				}
			}
		}
		
		bfs();
	}
	
	public static void bfs() {
		int day = -1;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i=0; i<size; i++) {
				Point p = q.poll();
				
				for(int j=0; j<dx.length; j++) {
					int x = p.m + dx[j];
					int y = p.n + dy[j];
					int z = p.h + dz[j];
					
					if(x >= 0 && x < m && y >= 0 && y < n && z >= 0 && z < h && box[z][y][x] == 0) {
						q.add(new Point(x, y, z));
						box[z][y][x] = 1;
						cnt--;
					}
				}
			}
			
			day++;
		}
		
		if(cnt == 0) System.out.println(day);
		else System.out.println(-1);
	}
}
