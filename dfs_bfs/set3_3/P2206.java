package set3_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2206 {

	static class Location {
		int row, col, dis, broke;
		public Location(int row, int col, int dis, int broke) {
			this.row = row;
			this.col = col;
			this.dis = dis;
			this.broke = broke;
		}
	}

	static int n, m, path[][], visited[][];

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		path = new int[n][m];
		visited = new int[n][m];

		for(int i=0; i<n; i++) {
			String arr[] = br.readLine().split("");

			for(int j=0; j<m; j++) {
				path[i][j] = Integer.parseInt(arr[j]);
				visited[i][j] = Integer.MAX_VALUE;
			}
		}

		System.out.println(bfs());
	}

	public static int bfs() {
		int cnt = 0;

		int rows[] = {1, -1, 0, 0};
		int cols[] = {0, 0, 1, -1};

		visited[0][0] = 0;

		Queue <Location> q = new LinkedList<>();
		q.add(new Location(0, 0, 1, 0));

		while(!q.isEmpty()) {
			Location curr = q.poll();

			if(curr.row == n-1 && curr.col == m-1)
				return curr.dis;

			for(int i=0; i<rows.length; i++) {
				int r = curr.row + rows[i];
				int c = curr.col + cols[i];

				if(r < 0 || r >= n || c < 0 || c >= m) continue;

				// visited[r][c] <= curr.broke 면, 벽은 1번만 부술 수 있기 때문에 방문 불가 
				if(visited[r][c] > curr.broke) {
					if(path[r][c] == 0) {
						q.add(new Location(r, c, curr.dis+1, curr.broke));
						visited[r][c] = curr.broke;
					}
					else {
						if(curr.broke == 0) {
							q.add(new Location(r, c, curr.dis+1, curr.broke+1));
							visited[r][c] = curr.broke + 1;
						}

					}
				}
			}
		}
		
		return -1;
	}
}

