package set2_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14889 {

	static int n;
	static int[][] map;
	static boolean[] visit;

	static int min = Integer.MAX_VALUE;

	// 0, 2, 1
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		visit = new boolean[n];

		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for(int j=0; j<n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		divide(0, 0);
		System.out.println(min);
	}

	// 한 팀당 N/2 
	static void divide(int idx, int cnt) {
		if(cnt == n/2) {
			// 두팀의 차 계산 후 min 값 비교
			calculator();
			return;
		}

		for(int i=idx; i<n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				divide(i+1, cnt+1);		// 여기를 divide(idx+1, cnt+1)로 하고 있었음,,
				visit[i] = false;
			}
		}
	}

	static void calculator() {
		int start = 0;
		int link = 0;

		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(visit[i] && visit[j]) {
					start += map[i][j];
					start += map[j][i];
				}
				else if(!visit[i] && !visit[j]) {
					link += map[i][j];
					link += map[j][i];
				}	
			}
		}

		int ret = Math.abs(start - link);

		// 차이가 0이면 프로그램 종료 
		if(ret == 0) {
			System.out.println(ret);
			System.exit(0);
		}

		min = Math.min(min, ret);
	}

}
