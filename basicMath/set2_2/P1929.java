package set2_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소수 구하기 (최대값이 10,000,000)
// 루트 이용 
// 에라토스테네스의 체 
public class P1929 {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for(int i=n; i<=m; i++) {
			boolean check = true;
			
			for(int j=2; j<=Math.sqrt(i); j++) {
				if(i % j == 0) {
					check = false;
					break;
				}
			}
			
			if(check && i != 1)
				System.out.println(i);
		}
	}
}
