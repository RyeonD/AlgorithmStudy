package set2_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최대 공약수와 최소 공배수 
public class P2609 {

	public static void main(String args[]) throws Exception {
		// 입력 24 18
		// 출력 6 72
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// 최대공약수 gcd = greatest common division
		// gcd(a,b) = gcd(b,r)
		// r = a % b
		int num = n;
		int gcd = m;

		while(num != 0) {
			int r = gcd % num;
			
			gcd = num;
			num = r;
		}
		
		// 최소공배수 lcm = least common multiple
		// n = a*gcd
		// m = b*gcd
		// n*m = a*b*gcd*gcd
		// n*m/gcd = a*b*gcd
		int lcm = n*m/gcd;
		
		System.out.println(gcd);
		System.out.println(lcm);
	}
}
