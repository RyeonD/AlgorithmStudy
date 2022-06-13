package set3_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2번 방법 
// 익지 않은 토마토 개수를 box 입력과 함께 카운트한 값에서, 익지 않은 토마토 개수를 빼가며 카운트하는 방법  
// P7569 보다 P7569_2가 속도와 메모리 측면에서 우수 
public class P7569_2 {

	static class Point {
		int m, n, h;
		public Point(int m, int n, int h) {
			this.m = m;
			this.n = n;
			this.h = h;
		}
	}
	
	static int m, n, h, box[][][], notRipe;
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
		notRipe = 0;
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				st = new StringTokenizer(br.readLine());
				
				for(int k=0; k<m; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if(box[i][j][k] == 1)
						q.add(new Point(k, j, i));
					
					if(box[i][j][k] == 0)
						notRipe++;
				}
			}
		}
		
		// 익지 않은 토마토가 없는 경우 0, 있는 경우 카운트 시작 
		if(notRipe == 0) System.out.println(0);
		else bfs();
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
						notRipe--;
					}
				}
			}
			
			day++;
		}
		
		if(notRipe == 0) System.out.println(day);
		else System.out.println(-1);
	}
}
