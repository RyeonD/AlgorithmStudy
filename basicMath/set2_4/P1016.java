package set2_4;

import java.util.Scanner;

// 제곱 ㄴㄴ 수 
public class P1016 {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		long min = sc.nextLong();
		long max = sc.nextLong();

		int len = (int)(max-min+1);

		boolean check[] = new boolean[len];

		// 10^6 < 10^12+10^6의 제곱근 = 10^6+0.499xxxx...
		for(long i=2; i<=Math.sqrt(max); i++) {
			long pow = i*i;
			long start = min/pow;

			if(min % pow != 0)
				start++;

			start *= pow;

			while(start <= max) {
				check[(int)(start-min)] = true;
				
				// 시간복잡도 고려 사항: min~max까지 모두 확인하지 않고, 해당 되는 것만 확인해야함 
				start += pow;	
			}
		}

		int cnt = 0;
		for(int i=0; i<len; i++) {
			if(check[i])
				cnt++;
		}


		System.out.println(len-cnt);
	}
}
