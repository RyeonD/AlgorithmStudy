package set2_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소수 찾기 (최대값 1,000)
public class P1978 {
	
	public static void main(String args[]) throws Exception {
		// 4
		// 1 3 5 7
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int cnt = 0;
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(num == 1)
				continue;
			
			boolean check = true;
			for(int j=2; j<num; j++) {
				if(num % j == 0) {
					check = false;
					break;
				}
			}
			
			if(check) cnt++;
		}
		
		System.out.println(cnt);
	}
}
