package set3_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 예외 주의!
// 예외) 5 - 6 - (3 - 2 - 1) - (3 - 2 - 1) - ...
public class P9466 {
	
	static int n, students[], cnt;
	static boolean visited[];
	static ArrayList <Integer> arr = new ArrayList<>();
	
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int T=0; T<test_case; T++) {
			n = Integer.parseInt(br.readLine());
			students = new int[n+1];
			visited = new boolean[n+1];
			
			st= new StringTokenizer(br.readLine());
			for(int i=1; i<=n; i++) {
				students[i] = Integer.parseInt(st.nextToken());
			}
			
			// 계산 
			cnt = 0;
			
			for(int i=1; i<=n; i++) {
				if(visited[i]) continue;
				
				// 아직 선택된적 없지만, i학생이 가르키고 있는 students[i]학생은 선택된 적이 있는 경우
				// 이미 선택된적 있다는 것은 사이클을 이뤘던 이루지 않았던 결과가 나온것을 의미
				// 즉, students[i]는 i를 포함한 사이클을 이룰 수 없음 
				if(visited[students[i]]) {
					visited[i] = true;
					cnt++;
					continue;
				}
				
				dfs(i);
			}
			
			sb.append(cnt+"\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int s) {
		if(visited[s]) {
			// s를 선택한적 있는 경우
			if(arr.contains(s))  cnt += arr.indexOf(s);		// s가 현재 사이클에 있는 경우, s 앞까지만 카운트해주면 됨 
			else cnt += arr.size();							// s가 현재 사이클에 없는 경우, 현재 그래프는 사이클을 이룰 수 없으므로 모두 카운트 
 
			arr.clear();
			return;
		}
		else {
			visited[s] = true;
			arr.add(s);
			dfs(students[s]);
		}
	}
}
