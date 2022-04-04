package set3_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// 단지번호 붙이기 
public class P2667 {
	
	static ArrayList <Integer> count = new ArrayList<>();
	static int dr[] = {1, -1, 0, 0};
	static int dc[] = {0, 0, 1, -1};
	static int n, total;
	static int matrix[][];
	static boolean visited[][];

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		total = 0;
		
		matrix = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			String str[] = br.readLine().split("");
			
			for(int j=0; j<n; j++)
				matrix[i][j] = Integer.parseInt(str[j]);
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					
					if(matrix[i][j] == 1) {
						count.add(bfs(i, j));
						total++;
					}
				}
			}
		}
		
		Collections.sort(count);
		sb.append(total);
		for(Integer i:count)
			sb.append("\n").append(i);
		
		System.out.println(sb.toString());
	}
	
	public static int bfs(int row, int col) {
		int cnt = 1;

		for(int i=0; i<dr.length; i++) {
			int r = row + dr[i];
			int c = col + dc[i];
			
			if(r >= 0 && r < n && c >= 0 && c < n) {				
				if(matrix[r][c] == 1 && !visited[r][c]) {
					visited[r][c] = true;
					cnt += bfs(r,c);
				}
			}
		}
		
		return cnt;
	}
}
