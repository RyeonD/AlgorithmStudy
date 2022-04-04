package set3_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질  
public class P1697 {

	static int n, k, time;
	static int val_MAX = 100001;
	static boolean visited[] = new boolean[val_MAX];
	
	static class Pair {
		int node;
		int second;
		public Pair(int node, int second) {
			this.node = node;
			this.second = second;
		}
	}
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		time = val_MAX;
		
		visited[n] = true;
		
		Queue <Pair> queue = new LinkedList<>();
		queue.add(new Pair(n, 0));
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			int curr = p.node;
			int second = p.second;
			
			if(second >= time)
				break;
			
			if(p.node == k)
				time = Math.min(time, p.second);
			
			if(isPossible(curr*2)) {
				visited[curr*2] = true;
				queue.add(new Pair(curr*2, second+1));
			}
			if(isPossible(curr+1)) {
				visited[curr+1] = true;
				queue.add(new Pair(curr+1, second+1));
			}
			if(isPossible(curr-1)) {
				visited[curr-1] = true;
				queue.add(new Pair(curr-1, second+1));
			}
		}
		
		System.out.println(time);
	}
	
	public static boolean isPossible(int num) {
		if(num < 0 || num >= val_MAX || visited[num])
			return false;
		return true;
	}
}
