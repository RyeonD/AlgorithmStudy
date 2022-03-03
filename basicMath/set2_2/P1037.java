package set2_2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 약수 
public class P1037 {

	public static void main(String args[]) throws Exception {
		// 입력 순서대로 출력 8, 4, 24, 185192
		
		System.setIn(new FileInputStream("res/p1037.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int min = 1000000;
		int max = 0;
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
		
		System.out.println(max*min);
	}
}
