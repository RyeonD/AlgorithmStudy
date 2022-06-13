package set3_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 문제 review
public class P7569_r {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Queue <int[]> q = new LinkedList<>();
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int[][][] box = new int[h][n][m];
		int total = 0;
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				st = new StringTokenizer(br.readLine());
				
				for(int k=0; k<m; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if(box[i][j][k] != -1) {
						total++;
						
						if(box[i][j][k] == 1) {
							q.add(new int[] {i, j, k});
						}
					}
				}
			}
		}
		
		int[] dx = {1,-1,0,0,0,0};
		int[] dy = {0,0,1,-1,0,0};
		int[] dz = {0,0,0,0,1,-1};
		
		int cnt = -1; 
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i=0; i<size; i++) {
				int[] curr = q.poll();
				
				for(int j=0; j<6; j++) {
					int z = dz[j] + curr[0];
					int y = dy[j] + curr[1];
					int x = dx[j] + curr[2];
					
					if(x < 0 || x >= m || y < 0 || y >= n || z < 0 || z >= h) continue;
					
					if(box[z][y][x] == 0) {
						box[z][y][x] = 1;
						q.add(new int[] {z,y,x});
					}
				}
				
				total--;
			}
			
			cnt++;
		}
		
		if(total == 0) System.out.println(cnt);
		else System.out.println(-1);
	}

}
