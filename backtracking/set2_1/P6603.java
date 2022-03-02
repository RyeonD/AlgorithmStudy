package set2_1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 로또 
public class P6603 {
	
	private static int k_MAX = 12;
	private static int MAX_CNT = 6;
	
	private static int k;
	private static int s[] = new int[k_MAX];
	private static boolean check[] = new boolean[k_MAX];
	
	public static void lotto(int cnt, int index, String output) {
		if(cnt == 6) {
			System.out.println(output);
			return;
		} 
		
		// 출력할 숫자 중간마다 띄어쓰기 
		if(cnt != 0)
			output += " ";
		
		for(int i=index+1; i<k; i++) {
			lotto(cnt+1, i, output+s[i]);
		}
		
	}
	
	public static void dfs(int index, int cnt) {
		if(cnt == 6) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<k; i++) {
				if(check[i])
					sb.append(s[i]+" ");
			}
			
			System.out.println(sb.toString());
		}
		
		for(int i=index; i<k; i++) {
			check[i] = true;
			dfs(i+1, cnt+1);
			check[i] = false;
		}
	}

	public static void main(String args[]) throws Exception {
		
		System.setIn(new FileInputStream("res/p6603.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			
			if(k == 0)
				break;
			
			for(int i=0; i<k; i++) {
				s[i] = Integer.parseInt(st.nextToken());
				check[i] = false;
			}

			// 1번 방법 - 각 테스트 케이스마다 실행 횟수 : 95, 215
//			for(int i=0; i<=k-MAX_CNT; i++)
//				lotto(1, i, Integer.toString(s[i]));
			
			// 2번 방법 - 96, 225
//			for(int i=0; i<=k-MAX_CNT; i++) {
//				check[i] = true;
//				dfs(i+1,1);
//				check[i] = false;
//			}
//			
			// 3번 방법 - 128, 256
			dfs(0,0);

			System.out.println();
		}
	}
}