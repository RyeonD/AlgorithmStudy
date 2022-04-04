package set2_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 골드 바흐의 추측 (에라토스테네스의 체) 
public class P6588 {

	public static void main(String args[]) throws Exception {
		long start = System.currentTimeMillis();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 1000000;
		
		// max 보다 작은 홀수 소수 구하기 
		boolean[] arr = new boolean[max+1];
		
		for(int i=2; i<=max; i++)
			arr[i] = true;
	
		for(int i=2; i<=max; i++) {
			for(int j=i*2; j<=max; j+=i) {
				if(!arr[j]) continue;
				arr[j] = false;
			}
		}
		
		
		while(true) {		
			int num = Integer.parseInt(br.readLine());
			if(num == 0)
				break;
			
			boolean possible = false;
			for(int j=3; j<=num/2; j++) {
				if(arr[j] && arr[num-j]) {
					// println과 printf의 속도 차이 주의 
					System.out.println(num+" = "+ j+" + "+(num-j));			// 23
//					System.out.printf("%d = %d + %d\n", num, j, (num-j));	// 36
					possible = true;
					break;
				}
			}
			
			if(!possible) {
				System.out.println("Goldbach's conjecture is wrong.");
			}
		}
		
		long end = System.currentTimeMillis();
		System.out.println((end-start)/100);
	}
}
