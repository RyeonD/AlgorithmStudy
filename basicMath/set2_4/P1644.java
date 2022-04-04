package set2_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 소수의 연속합 
public class P1644 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ArrayList <Integer> prime = new ArrayList<>();

		int n = Integer.parseInt(br.readLine());
		boolean [] arr = new boolean[n+1];
		arr[0] = arr[1] = true;

		// n까지 소수를 구한다면
		for(int i=2; i*i<=n; i++) {
			if(!arr[i]) 
				for(int j=i*i; j<=n; j+=i) arr[j] = true;
		}
		
		for(int i=2; i<=n; i++) if(!arr[i]) prime.add(i);

		int sum = 0;
		int start = 0;
		int end = 0;
		int cnt = 0;
		
		while(true) {
			if(sum >= n) sum -= prime.get(start++);
			else if(end == prime.size()) break;
			else sum += prime.get(end++);

			if(sum == n) cnt++;
		}

		System.out.println(cnt);
	}
}
