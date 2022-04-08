package set3_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 피보나치 함수(0과 1의 개수 출력)
// zero와 one 변수 생성 후 함수로 각 변수 값 구하는 방법도 있음 
public class P1003 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int test_size = Integer.parseInt(br.readLine());
		
		int fibo[] = new int[41];
		fibo[0] = 0;
		fibo[1] = 1;
		
		for(int i=2; i<=40;  i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		
		for(int i=0; i<test_size; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num > 1)
				sb.append(fibo[num-1]).append(" ").append(fibo[num]).append("\n");
			else if(num == 1)
				sb.append(fibo[0]).append(" ").append(fibo[1]).append("\n");
			else
				sb.append(fibo[1]).append(" ").append(fibo[0]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
