package set2_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15686 {

	static int n, m, map[][];
	static int loc[][] = new int[13][2];
	static int locCnt = 0;
	static boolean visited[] = new boolean[13];
	
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 2) {
					loc[locCnt][0] = i;
					loc[locCnt++][1] = j;
				}
			}
		}
		
		// M개 선택 조합
		combi(0, 0);
		System.out.println(min);
	}

	static void combi(int idx, int cnt) {
		if(cnt == m) {
			calculator();
			return;
		}
		
		
		for(int i=idx; i<locCnt; i++) {
			if(!visited[i]) {
				visited[i] = true;
				combi(i+1, cnt+1);
				visited[i] = false;
			}
		}
	}
	
	static void calculator() {
		int ret = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] != 1)
					continue;
				
				int val = Integer.MAX_VALUE;
				for(int k=0; k<locCnt; k++) {
					if(visited[k])
						val = Math.min(val, Math.abs(i-loc[k][0])+Math.abs(j-loc[k][1]));
				}
				
				ret += val;
			}
		}
		
		min = Math.min(ret, min);
	}
}
