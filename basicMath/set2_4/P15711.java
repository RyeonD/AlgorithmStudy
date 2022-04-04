package set2_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 환상의 짝꿍 
public class P15711 {

	public static ArrayList<Integer> prime = new ArrayList<>();
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 소수 추가 
		addPrime();
		
		int n = Integer.parseInt(br.readLine());

		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long num = Long.parseLong(st.nextToken()) + Long.parseLong(st.nextToken());
			
			// 무조건 계산하기보단 계산하지 않아도 결과를 알 수 있는 것과 계산이 필요한 것 구분 필요!
			check(num);
		}
		
		System.out.println(sb.toString());
	}
	
	public static void check(long num) {
		if(num < 4)
			sb.append("NO\n");
		else if(num % 2 == 0)
			sb.append("YES\n");
		else {
			// 소수는 2를 제외하곤 모두 홀수
			// num = 홀수 + 짝수 이므로 홀수 값만 확인하면됨 
			// 소수 중 짝수는 2뿐이므로, num-2의 값만 소수인지 확인하면됨 
			if(isPossible(num-2)) sb.append("YES\n");
			else sb.append("NO\n");
		}
	}
	
	public static boolean isPossible(long num) {
		// 자연수 N이 소수인지 판단 -> 2부터 루트N 까지의 숫자들로 N을 나눴을 때, 나누어 떨어지는 것이 없으면 됨 
		// 그리고 num은 홀수 -> x도 홀수 
		int x = (int)Math.sqrt(num);	// x <= 2*10^6 
		
		for(Integer p : prime) {
			// 루트num 까지만 확인하면 됨 
			if(p > x)
				return true;
			if(num % p == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void addPrime() {
		int prime_max = 2000001;
		boolean primeArr[] = new boolean[prime_max];
		
		for(int i=2; i*i<prime_max; i++) {
			for(int j=i*i; j<prime_max; j+=i) {
				primeArr[j] = true;
			}
		}
		
		for(int i=2; i<prime_max; i++) {
			if(!primeArr[i]) prime.add(i);
		}
	}
}
