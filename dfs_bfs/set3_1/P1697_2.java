package set3_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질  
// queue size 이용하여 level 마다 탐색 
public class P1697_2 {

	static int n, k;
	static int val_MAX = 100001;
	static boolean visited[] = new boolean[val_MAX];
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		int level = 0;
		
		visited[n] = true;
		
		Queue <Integer> queue = new LinkedList<>();
		queue.add(n);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i=0; i<size; i++) {
				int num = queue.poll();
				
				if(num == k)
					return level;
				
				if(isPossible(num*2)) {
					queue.add(num*2);
					visited[num*2] = true;
				}
				if(isPossible(num+1)) {
					queue.add(num+1);
					visited[num+1] = true;
				}
				if(isPossible(num-1)) {
					queue.add(num-1);
					visited[num-1] = true;
				}
			}
			
			level++;
		}
		
		return level;
	}
	
	public static boolean isPossible(int num) {
		if(num < 0 || num >= val_MAX || visited[num])
			return false;
		return true;
	}
}
