package set2_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 가로
public class P2485 {
	
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int gcd = arr[1] - arr[0];
		for(int i=1; i<n-1; i++) {
			gcd = GCD(gcd, arr[i+1] - arr[i]);
		}
	
		gcd = (arr[n-1] - arr[0]) / gcd - (n-1);
		System.out.println(gcd);
	}
	
	public static int GCD(int x, int y) {
		if(y == 0) return x;
		return GCD(y, x % y);
	}
}
