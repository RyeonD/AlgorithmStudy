package set2_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2661 {

	static int n, number[];
    static boolean flag;
	static StringBuilder sb;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
        
		n = Integer.parseInt(br.readLine());
		number = new int[n];
		number[0] = 1;
        
        flag = false;
		
		backtracking(0, 1);
        System.out.println(sb.toString());	// System.exit(0)이 더 많은 시간과 메모리를 사용함 
	}
	
	static void backtracking(int idx, int num) {
        if(flag)
            return;
        
		if(idx == n) {
			for(int i:number)
				sb.append(i);
			
			flag = true;
            return;
		}
		
		number[idx] = num;
		boolean result = possible(idx);
		
		if(!result) {
			if(num == 3)
				return;
			else
				backtracking(idx, num+1);
		}
		
		if(result) {
			for(int i=1; i<=3; i++) {
				backtracking(idx+1, i);
			}
		}

	}
	
	static boolean possible(int idx) {
		for(int i=1; i<=(idx+1)/2; i++) {
			boolean check = true;
			
			for(int j=idx; j>idx-i; j--) {
				if(number[j] != number[j-i]) {
					check = false;
					break;
				}
			}
			
			if(check)
				return false;
		}
		
		return true;
	}

}
